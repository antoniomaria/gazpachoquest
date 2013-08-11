package net.sf.gazpachosurvey.repository.qbe;

import static javax.persistence.metamodel.Attribute.PersistentAttributeType.EMBEDDED;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.MANY_TO_ONE;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.ONE_TO_ONE;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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


import net.sf.gazpachosurvey.domain.support.Persistable;

import org.apache.commons.lang.Validate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;

public class ByExampleEnhancedSpecification {

    private final EntityManager em;

    public ByExampleEnhancedSpecification(EntityManager em) {
        this.em = em;
    }

    public <T extends Persistable<?>> Specification<T> byExampleOnEntity(
            final T example, final SearchParameters sp) {
        Validate.notNull(example, "example must not be null");

        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> rootPath,
                    CriteriaQuery<?> query, CriteriaBuilder builder) {
                Class<T> type = rootPath.getModel().getBindableJavaType();

                ManagedType<T> mt = em.getMetamodel().entity(type);

                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates
                        .addAll(byExample(mt, rootPath, example, sp, builder));
                predicates.addAll(byExampleOnXToOne(mt, rootPath, example, sp,
                        builder)); // 1
                                   // level
                                   // deep
                                   // only
                predicates.addAll(byExampleOnManyToMany(mt, rootPath, example,
                        sp, builder));
                return JpaUtil.andPredicate(builder, predicates);
            }

            public <T extends Persistable<?>> List<Predicate> byExample(
                    ManagedType<T> mt, Path<T> mtPath, final T mtValue,
                    SearchParameters sp, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (SingularAttribute<? super T, ?> attr : mt
                        .getSingularAttributes()) {
                    if (attr.getPersistentAttributeType() == MANY_TO_ONE //
                            || attr.getPersistentAttributeType() == ONE_TO_ONE //
                            || attr.getPersistentAttributeType() == EMBEDDED) {
                        continue;
                    }
                    Object attrValue = ReflectionUtils.invokeMethod(
                            (Method) attr.getJavaMember(), mtValue);

                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) {
                            if (isNotEmpty((String) attrValue)) {
                                SingularAttribute<? super T, String> stringAttribute = mt
                                        .getSingularAttribute(attr.getName(),
                                                String.class);
                                predicates.add(JpaUtil.stringPredicate(
                                        mtPath.get(stringAttribute), attrValue,
                                        sp, builder));
                            }
                        } else {
                            SingularAttribute<? super T, ?> attribute = mt
                                    .getSingularAttribute(attr.getName(),
                                            attr.getJavaType());
                            // apply equal
                            predicates.add(builder.equal(mtPath.get(attribute),
                                    attrValue));
                        }
                    }
                }
                return predicates;
            }

            /**
             * Invoke byExample method for each not null x-to-one association
             * when their pk is not set. This allows you to search entities
             * based on an associated entity's properties value.
             */
            @SuppressWarnings("unchecked")
            public <T extends Persistable<?>, M2O extends Persistable<?>> List<Predicate> byExampleOnXToOne(
                    ManagedType<T> mt, Root<T> mtPath, final T mtValue,
                    SearchParameters sp, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (SingularAttribute<? super T, ?> attr : mt
                        .getSingularAttributes()) {
                    if (attr.getPersistentAttributeType() == MANY_TO_ONE
                            || attr.getPersistentAttributeType() == ONE_TO_ONE) { //
                        /*
                         * Attribute<? super T, ?> m2oattr =
                         * mt.getAttribute(attr.getName()); M2O m2oValue = (M2O)
                         * ReflectionUtils
                         * .invokeMethod((Method)m2oattr.getJavaMember(),
                         * mtValue);
                         */
                        M2O m2oValue = (M2O) getValue(mtValue,
                                mt.getAttribute(attr.getName()));
                        // if (m2oValue != null && !mtValue.isIdSet()) {
                        if (m2oValue != null) {
                            Class<M2O> m2oType = (Class<M2O>) attr
                                    .getBindableJavaType();
                            ManagedType<M2O> m2oMt = em.getMetamodel().entity(
                                    m2oType);
                            Path<M2O> m2oPath = (Path<M2O>) mtPath.get(attr);
                            predicates.addAll(byExample(m2oMt, m2oPath,
                                    m2oValue, sp, builder));
                        }
                    }
                }
                return predicates;
            }

            /**
             * Construct a join predicate on collection (eg many to many, List)
             */
            public <T extends Persistable<?>> List<Predicate> byExampleOnManyToMany(
                    ManagedType<T> mt, Root<T> mtPath, final T mtValue,
                    SearchParameters sp, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (PluralAttribute<T, ?, ?> pa : mt
                        .getDeclaredPluralAttributes()) {
                    if (pa.getCollectionType() == PluralAttribute.CollectionType.LIST) {
                        List<?> value = (List<?>) getValue(mtValue,
                                mt.getAttribute(pa.getName()));

                        if (value != null && !value.isEmpty()) {
                            ListJoin<T, ?> join = mtPath.join(mt
                                    .getDeclaredList(pa.getName()));
                            predicates.add(join.in(value));
                        }
                    }
                    if (pa.getCollectionType() == PluralAttribute.CollectionType.SET) {
                        Set<?> value = (Set<?>) getValue(mtValue,
                                mt.getAttribute(pa.getName()));

                        if (value != null && !value.isEmpty()) {
                            SetJoin<T, ?> join = mtPath.join(mt
                                    .getDeclaredSet(pa.getName()));
                            predicates.add(join.in(value));
                        }
                    }
                }
                return predicates;
            }

            private <T> Object getValue(T example, Attribute<? super T, ?> attr) {
                try {
                    return ((Method) attr.getJavaMember()).invoke(example,
                            new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        };

    }

}
