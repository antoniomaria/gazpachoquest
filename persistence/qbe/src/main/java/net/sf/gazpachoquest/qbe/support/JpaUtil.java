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
/*
 * Copyright 2012 JAXIO http://www.jaxio.com Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package net.sf.gazpachoquest.qbe.support;

import static java.lang.reflect.Modifier.isPublic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;

import org.apache.commons.lang3.StringUtils;

public class JpaUtil {

    public static Predicate andPredicate(final CriteriaBuilder builder, final Iterable<Predicate> predicatesNullAllowed) {
        List<Predicate> predicates = withoutNullEntries(predicatesNullAllowed);
        if (predicates.isEmpty()) {
            return null;
        } else if (predicates.size() == 1) {
            return predicates.get(0);
        } else {
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        }
    }

    public static Predicate andPredicate(final CriteriaBuilder builder, final Predicate... predicatesNullAllowed) {
        return andPredicate(builder, Arrays.asList(predicatesNullAllowed));
    }

    public static <E> List<Order> buildJpaOrders(final Iterable<OrderBy> orders, final Root<E> root,
            final CriteriaBuilder builder) {
        List<Order> jpaOrders = new ArrayList<Order>();

        for (OrderBy ob : orders) {
            Path<?> path = getPropertyPath(root, ob.getProperty());

            if (ob.isOrderDesc()) {
                jpaOrders.add(builder.desc(path));
            } else {
                jpaOrders.add(builder.asc(path));
            }
        }
        return jpaOrders;
    }

    public static boolean isEntityIdManuallyAssigned(final Class<?> type) {
        for (Method method : type.getMethods()) {
            if (isPrimaryKey(method)) {
                return isManuallyAssigned(method);
            }
        }
        return false; // no pk found, should not happen
    }

    public static Predicate concatPredicate(SearchParameters sp, CriteriaBuilder builder,
            Predicate... predicatesNullAllowed) {
        List<Predicate> predicatesNullAllowedList = new ArrayList<Predicate>();
        for (Predicate predicate : predicatesNullAllowed) {
            predicatesNullAllowedList.add(predicate);
        }
        return concatPredicate(sp, builder, predicatesNullAllowedList);
    }

    public static Predicate concatPredicate(SearchParameters sp, CriteriaBuilder builder,
            Iterable<Predicate> predicatesNullAllowed) {
        if (sp.isAndMode()) {
            return andPredicate(builder, predicatesNullAllowed);
        } else {
            return orPredicate(builder, predicatesNullAllowed);
        }
    }

    public static Predicate orPredicate(final CriteriaBuilder builder, final Iterable<Predicate> predicatesNullAllowed) {
        List<Predicate> predicates = withoutNullEntries(predicatesNullAllowed);
        if (predicates.isEmpty()) {
            return null;
        } else if (predicates.size() == 1) {
            return predicates.get(0);
        } else {
            return builder.or(predicates.toArray(new Predicate[predicates.size()]));
        }
    }

    public static <E> Predicate stringPredicate(Expression<String> path, Object attrValue, final SearchParameters sp,
            final CriteriaBuilder builder) {
        if (sp.isCaseInsensitive()) {
            path = builder.lower(path);
            attrValue = ((String) attrValue).toLowerCase(Locale.ENGLISH);
        }

        switch (sp.getSearchMode()) {
        case EQUALS:
            return builder.equal(path, attrValue);
        case ENDING_LIKE:
            return builder.like(path, "%" + attrValue);
        case STARTING_LIKE:
            return builder.like(path, attrValue + "%");
        case ANYWHERE:
            return builder.like(path, "%" + attrValue + "%");
        case LIKE:
            return builder.like(path, (String) attrValue); // assume user
                                                           // provide the wild
                                                           // cards
        default:
            throw new IllegalStateException("expecting a search mode!");
        }
    }

    /**
     * Convert the passed propertyPath into a JPA path. Note: JPA will do joins
     * if the property is in an associated
     * entity.
     */
    private static <E> Path<?> getPropertyPath(final Path<E> root, final String propertyPath) {
        String[] pathItems = StringUtils.split(propertyPath, ".");

        Path<?> path = root.get(pathItems[0]);
        for (int i = 1; i < pathItems.length; i++) {
            path = path.get(pathItems[i]);
        }
        return path;
    }

    private static boolean isManuallyAssigned(final Method method) {
        if (method.getAnnotation(Id.class) != null) {
            return method.getAnnotation(GeneratedValue.class) == null;
        } else if (method.getAnnotation(EmbeddedId.class) != null) {
            return true;
        } else {
            return true;
        }
    }

    private static boolean isPrimaryKey(final Method method) {
        return isPublic(method.getModifiers())
                && (method.getAnnotation(Id.class) != null || method.getAnnotation(EmbeddedId.class) != null);
    }

    private static <T> List<T> withoutNullEntries(final Iterable<T> input) {
        List<T> output = new ArrayList<T>();
        for (T element : input) {
            if (element != null) {
                output.add(element);
            }
        }
        return output;
    }

    public static String getPath(List<Attribute<?, ?>> attributes) {
        StringBuilder builder = new StringBuilder();
        for (Attribute<?, ?> attribute : attributes) {
            builder.append(attribute.getName()).append(".");
        }
        return builder.substring(0, builder.length() - 1);
    }

    /**
     * Convert the passed propertyPath into a JPA path.
     * <p>
     * Note: JPA will do joins if the property is in an associated entity.
     */
    @SuppressWarnings("unchecked")
    public static <E, F> Path<F> getPath(Root<E> root, List<Attribute<?, ?>> attributes) {
        Path<?> path = root;
        for (Attribute<?, ?> attribute : attributes) {
            boolean found = false;
            // handle case when order on already fetched attribute
            for (Fetch<E, ?> fetch : root.getFetches()) {
                if (attribute.getName().equals(fetch.getAttribute().getName()) && (fetch instanceof Join<?, ?>)) {
                    path = (Join<E, ?>) fetch;
                    found = true;
                    break;
                }
            }
            for (Join<E, ?> join : root.getJoins()) {
                if (attribute.getName().equals(join.getAttribute().getName())) {
                    path = join;
                    found = true;
                    break;
                }
            }
            if (!found) {
                path = path.get(attribute.getName());
            }
        }
        return (Path<F>) path;
    }

    public static <E> Predicate stringPredicate(Expression<String> path, Object attrValue, SearchMode searchMode,
            SearchParameters sp, CriteriaBuilder builder) {
        if (!sp.isCaseSensitive()) {
            path = builder.lower(path);
         //   attrValue = ((String) attrValue).toLowerCase(LocaleContextHolder.getLocale());
            attrValue = ((String) attrValue).toLowerCase();
        }
        switch (searchMode != null ? searchMode : sp.getSearchMode()) {
        case EQUALS:
            return builder.equal(path, attrValue);
        case NOT_EQUALS:
            return builder.notEqual(path, attrValue);
        case ENDING_LIKE:
            return builder.like(path, "%" + attrValue);
        case STARTING_LIKE:
            return builder.like(path, attrValue + "%");
        case ANYWHERE:
            return builder.like(path, "%" + attrValue + "%");
        case LIKE:
            return builder.like(path, (String) attrValue); // assume user
                                                           // provide the wild
                                                           // cards
        default:
            throw new IllegalStateException("expecting a search mode!");
        }
    }


}
