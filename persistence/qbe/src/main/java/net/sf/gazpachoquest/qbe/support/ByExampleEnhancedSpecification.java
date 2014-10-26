/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.qbe.support;

import static javax.persistence.metamodel.Attribute.PersistentAttributeType.EMBEDDED;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.MANY_TO_ONE;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.ONE_TO_ONE;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;

import net.sf.gazpachoquest.domain.support.Persistable;

import org.apache.commons.lang3.Validate;
import org.eclipse.persistence.indirection.ValueHolderInterface;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;

public class ByExampleEnhancedSpecification {

    private final EntityManager em;

    public ByExampleEnhancedSpecification(final EntityManager em) {
        this.em = em;
    }

    public <T extends Persistable> Specification<T> byExampleOnEntity(final T example, final SearchParameters sp) {
        Validate.notNull(example, "example must not be null");

        return new Specification<T>() {
            
            @Override
            public Predicate toPredicate(final Root<T> rootPath, final CriteriaQuery<?> query,
                    final CriteriaBuilder builder) {
                Class<T> type = rootPath.getModel().getBindableJavaType();

                ManagedType<T> mt = em.getMetamodel().entity(type);

                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.addAll(byExample(mt, rootPath, example, sp, builder));
                predicates.addAll(byExampleOnXToOne(mt, rootPath, example, sp, builder)); 
                // 1 level deep only
                predicates.addAll(byExampleOnManyToMany(mt, rootPath, example, sp, builder));
                // order by
                query.orderBy(JpaUtil.buildJpaOrders(sp.getOrders(), rootPath, builder));
                return JpaUtil.andPredicate(builder, predicates);
            }

            //https://github.com/jaxio/generated-projects/tree/master/jsf2-spring-conversation/src/main/generated-java/com/jaxio/appli/repository/support
                
            public <T extends Persistable> List<Predicate> byExample(final ManagedType<T> mt, final Path<T> mtPath,
                    final T mtValue, final SearchParameters sp, final CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (SingularAttribute<? super T, ?> attr : mt.getSingularAttributes()) {
                    if (attr.getPersistentAttributeType() == MANY_TO_ONE
                            || attr.getPersistentAttributeType() == ONE_TO_ONE
                            || attr.getPersistentAttributeType() == EMBEDDED
                            || attr.getJavaType().isAssignableFrom(Map.class)) {
                        continue;
                    }
                    Object attrValue = getValue(mtValue, attr);

                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) {
                            if (isNotEmpty((String) attrValue)) {
                                SingularAttribute<? super T, String> stringAttribute = mt.getSingularAttribute(
                                        attr.getName(), String.class);
                                predicates.add(JpaUtil.stringPredicate(mtPath.get(stringAttribute), attrValue, sp,
                                        builder));
                            }
                        } else {
                            SingularAttribute<? super T, ?> attribute = mt.getSingularAttribute(attr.getName(),
                                    attr.getJavaType());
                            // apply equal
                            predicates.add(builder.equal(mtPath.get(attribute), attrValue));
                        }
                    }
                }
                return predicates;
            }

            /**
             * Construct a join predicate on collection (eg many to many, List)
             */
            public <T extends Persistable> List<Predicate> byExampleOnManyToMany(final ManagedType<T> mt,
                    final Root<T> mtPath, final T mtValue, final SearchParameters sp, final CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (PluralAttribute<T, ?, ?> pa : mt.getDeclaredPluralAttributes()) {
                    if (pa.getCollectionType() == PluralAttribute.CollectionType.LIST) {
                        List<?> value = (List<?>) getValue(mtValue, mt.getAttribute(pa.getName()));

                        if (value != null && !value.isEmpty()) {
                            ListJoin<T, ?> join = mtPath.join(mt.getDeclaredList(pa.getName()));
                            predicates.add(join.in(value));
                        }
                    }
                    if (pa.getCollectionType() == PluralAttribute.CollectionType.SET) {
                        Set<?> value = (Set<?>) getValue(mtValue, mt.getAttribute(pa.getName()));

                        if (value != null && !value.isEmpty()) {
                            SetJoin<T, ?> join = mtPath.join(mt.getDeclaredSet(pa.getName()));
                            predicates.add(join.in(value));
                        }
                    }
                }
                return predicates;
            }

            /**
             * Invoke byExample method for each not null x-to-one association
             * when their pk is not set. This allows you
             * to search entities based on an associated entity's properties
             * value.
             */
            @SuppressWarnings("unchecked")
            public <T extends Persistable, M2O extends Persistable> List<Predicate> byExampleOnXToOne(
                    final ManagedType<T> mt, final Root<T> mtPath, final T mtValue, final SearchParameters sp,
                    final CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (SingularAttribute<? super T, ?> attr : mt.getSingularAttributes()) {
                    if (attr.getPersistentAttributeType() == MANY_TO_ONE
                            || attr.getPersistentAttributeType() == ONE_TO_ONE) { //
                        M2O m2oValue = (M2O) getValue(mtValue, mt.getAttribute(attr.getName()));

                        if (m2oValue != null) {
                            Class<M2O> m2oType = (Class<M2O>) attr.getBindableJavaType();
                            ManagedType<M2O> m2oMt = em.getMetamodel().entity(m2oType);
                            Path<M2O> m2oPath = (Path<M2O>) mtPath.get(attr);
                            predicates.addAll(byExample(m2oMt, m2oPath, m2oValue, sp, builder));
                        }
                    }
                }
                return predicates;
            }

            private <T> Object getValue(final T example, final Attribute<? super T, ?> attr) {
                Object value = null;
                try {
                    if (attr.getJavaMember() instanceof Method) {
                        value = ((Method) attr.getJavaMember()).invoke(example, new Object[0]);
                    } else if (attr.getJavaMember() instanceof Field) {
                        value = ReflectionUtils.getField((Field) attr.getJavaMember(), example);
                    }

                    if (value instanceof ValueHolderInterface) {
                        value = ((ValueHolderInterface) value).getValue();
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                return value;
            }

        };

    }

}
