package net.sf.gazpachoquest.services.permission.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.sf.gazpachoquest.domain.support.IPermission;
import net.sf.gazpachoquest.domain.support.Securizable;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.types.Perm;

import org.springframework.data.jpa.domain.Specification;

public class PermissionSpecification<T extends Securizable<?>, P extends IPermission<T>> {

    private final static Integer READ_ONLY = Perm.READ.getMask();

    public Specification<T> canRead(final Integer userId, final Integer... groupsIds) {

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);
                Join<T, P> permission = root.join("permissions", JoinType.LEFT);

                Path<Integer> userIdPath = permission.get("user").get("id");
                Path<Integer> maskPath = permission.get("mask");

                Predicate matchUserId = cb.equal(userIdPath, userId);
                Expression<Integer> readPermission = cb.mod(cb.quot(maskPath, READ_ONLY).as(Integer.class), 2);
                Predicate canRead = cb.equal(readPermission, 1);

                Predicate predicate = null;

                if (groupsIds.length > 0) {
                    Path<Group> group = permission.get("group");
                    Predicate inGroups = group.in((Object[]) groupsIds);
                    predicate = cb.and(cb.or(inGroups, matchUserId), canRead);
                } else {
                    predicate = cb.and(matchUserId, canRead);
                }
                return predicate;
            }
        };
    }
}
