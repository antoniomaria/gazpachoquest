package net.sf.gazpachoquest.qbe;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

@SuppressWarnings("unchecked")
public class PropertySelectorSpecification {

    public static <E> Specifications<E> andPropertySelectorIfSet(Specifications<E> specifications,
            final SearchParameters sp) {
        specifications = specifications.and((Specification<E>) toSpecification(sp));
        return specifications;
    }

    public static <E> Specification<E> toSpecification(final SearchParameters sp) {
        return new Specification<E>() {

            @Override
            public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (PropertySelector<?, ?> selector : sp.getProperties()) {
                    if (selector.isBoolean()) {
                        byBooleanSelector(root, builder, predicates, sp,
                                (PropertySelector<? super E, Boolean>) selector);
                    } else {
                        byObjectSelector(root, builder, predicates, sp, (PropertySelector<? super E, ?>) selector);
                    }
                }
                return JpaUtil.concatPredicate(sp, builder, predicates);
            }

            private void byBooleanSelector(Root<E> root, CriteriaBuilder builder, List<Predicate> predicates,
                    SearchParameters sp, PropertySelector<? super E, Boolean> selector) {
                if (selector.isNotEmpty()) {
                    List<Predicate> selectorPredicates = new ArrayList<Predicate>();
                    for (Boolean selection : selector.getSelected()) {
                        Path<Boolean> path = JpaUtil.getPath(root, selector.getAttributes());
                        if (selection == null) {
                            selectorPredicates.add(builder.isNull(path));
                        } else {
                            selectorPredicates.add(selection ? builder.isTrue(path) : builder.isFalse(path));
                        }
                    }
                    predicates.add(JpaUtil.orPredicate(builder, selectorPredicates));
                }
            }

            private void byObjectSelector(Root<E> root, CriteriaBuilder builder, List<Predicate> predicates,
                    SearchParameters sp, PropertySelector<? super E, ?> selector) {
                if (selector.isNotEmpty()) {
                    List<Predicate> selectorPredicates = new ArrayList<Predicate>();
                    for (Object selection : selector.getSelected()) {
                        if (selection instanceof String) {
                            Path<String> path = JpaUtil.getPath(root, selector.getAttributes());
                            selectorPredicates.add(JpaUtil.stringPredicate(path, selection, selector.getSearchMode(),
                                    sp, builder));
                        } else {
                            Path<?> path = JpaUtil.getPath(root, selector.getAttributes());
                            selectorPredicates.add(selection == null ? builder.isNull(path) : builder.equal(path,
                                    selection));
                        }
                    }
                    predicates.add(JpaUtil.orPredicate(builder, selectorPredicates));
                }
            }

        };
    }
    /*-
     public <E> Predicate byPropertySelectors(Root<E> root, CriteriaBuilder builder, SearchParameters sp) {
     List<Predicate> predicates = new ArrayList();
     for (PropertySelector<?, ?> selector : sp.getProperties()) {
     if (selector.isBoolean()) {
     byBooleanSelector(root, builder, predicates, sp, (PropertySelector<? super E, Boolean>) selector);
     } else {
     byObjectSelector(root, builder, predicates, sp, (PropertySelector<? super E, ?>) selector);
     }
     }
     return JpaUtil.concatPredicate(sp, builder, predicates);
     }

     private static <E> void byBooleanSelector(Root<E> root, CriteriaBuilder builder, List<Predicate> predicates,
     SearchParameters sp, PropertySelector<? super E, Boolean> selector) {
     if (selector.isNotEmpty()) {
     List<Predicate> selectorPredicates = new ArrayList();
     for (Boolean selection : selector.getSelected()) {
     Path<Boolean> path = JpaUtil.getPath(root, selector.getAttributes());
     if (selection == null) {
     selectorPredicates.add(builder.isNull(path));
     } else {
     selectorPredicates.add(selection ? builder.isTrue(path) : builder.isFalse(path));
     }
     }
     predicates.add(JpaUtil.orPredicate(builder, selectorPredicates));
     }
     }

     private static <E> void byObjectSelector(Root<E> root, CriteriaBuilder builder, List<Predicate> predicates,
     SearchParameters sp, PropertySelector<? super E, ?> selector) {
     if (selector.isNotEmpty()) {
     List<Predicate> selectorPredicates = new ArrayList();
     for (Object selection : selector.getSelected()) {
     if (selection instanceof String) {
     Path<String> path = JpaUtil.getPath(root, selector.getAttributes());
     selectorPredicates.add(JpaUtil.stringPredicate(path, selection, selector.getSearchMode(), sp,
     builder));
     } else {
     Path<?> path = JpaUtil.getPath(root, selector.getAttributes());
     selectorPredicates.add(selection == null ? builder.isNull(path) : builder.equal(path, selection));
     }
     }
     predicates.add(JpaUtil.orPredicate(builder, selectorPredicates));
     }
     }*/
}
