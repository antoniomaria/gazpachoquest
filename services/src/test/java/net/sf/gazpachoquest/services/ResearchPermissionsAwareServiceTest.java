package net.sf.gazpachoquest.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import javax.persistence.criteria.Subquery;

import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.permission.AbstractPermission_;
import net.sf.gazpachoquest.domain.permission.ResearchPermission;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Group_;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.domain.user.User_;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("ResearchService-dataset.xml")
@DatabaseTearDown("ResearchService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class ResearchPermissionsAwareServiceTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Qualifier("researchPermissionsAwareServiceImpl")
    private ResearchService researchService;

    @Test
    public void findAllWithSpecificationTest() {
        // Subject subject = SecurityUtils.getSubject();
        // subject.
        // Subject.Builder().principals(identity).buildSubject();
        List<Research> entities = researchService.findAll();
        System.out.println(entities);
        System.out.println("fin");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void findAllWithgroupsVersion2Test() {
        // @Query("select distinct r from ResearchPermission p join p.target r where p.user.id = :userId and mod(p.mask / :bitMask, 2) = 1")
        // @Query("select distinct r from Research r join r.researchPermissions p where p.user.id = :userId and mod(p.mask / :bitMask, 2) = 1")
        // Criteria builder

        Integer userId = 1;
        Integer bitMask = 1;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Research> query = cb.createQuery(Research.class);
        Root<ResearchPermission> root = query.from(ResearchPermission.class);
        query.distinct(true);
        Join<ResearchPermission, Research> research = root.join("target", JoinType.LEFT);
        query.select(research);

        Path<Integer> userIdPath = root.get(AbstractPermission_.user).get(User_.id);
        Path<Group> group = root.get(AbstractPermission_.group);
        Path<Integer> mask = root.get(AbstractPermission_.mask);

        ParameterExpression<Integer> param = cb.parameter(Integer.class, "userId");
        Predicate predicate = cb.equal(userIdPath, param);

        Expression<Number> divExpression = cb.quot(mask, bitMask);
        Expression<Integer> modExpression = cb.mod(divExpression.as(Integer.class), 2);

        // Predicate inGroups = group.in(Group.with().id(1).build());

        Subquery<Integer> subquery = query.subquery(Integer.class);
        Root<Group> rootSubquery = subquery.from(Group.class);
        SetJoin<Group, User> users = rootSubquery.join(Group_.users, JoinType.LEFT);
        subquery.select(rootSubquery.get(Group_.id));
        subquery.where(cb.equal(users.get(User_.id), param));

        Predicate inGroups = group.get(Group_.id).in(subquery);
        /*-
         CriteriaQuery<Integer> userGroupQuery = cb.createQuery(Integer.class);
         Root<Group> rootUserGroup = userGroupQuery.from(Group.class);
         SetJoin<Group, User> join = rootUserGroup.join(Group_.users);
         userGroupQuery.where(cb.equal(join.get(User_.id), param));
         userGroupQuery.select(rootUserGroup.get(Group_.id));

         List<Integer> userGroups = entityManager.createQuery(userGroupQuery).setParameter("userId", userId)
         .getResultList();
         if (userGroups.isEmpty()) {
         query.where(cb.and(predicate), cb.equal(modExpression, 1));
         } else {
         Predicate inGroups = group.get(Group_.id).in(userGroups);
         query.where(cb.and(cb.or(inGroups, predicate), cb.equal(modExpression, 1)));
         }
         */
        // query.where(cb.and(cb.equal(modExpression, 1), cb.or(inGroups,
        // predicate ));
        query.where(cb.or(cb.and(inGroups, cb.equal(modExpression, 1)), cb.and(predicate, cb.equal(modExpression, 1))));
        // query.where(cb.and(cb.or(inGroups, predicate),
        // cb.equal(modExpression, 1)));

        // query.where(cb.and(cb.or(predicate, inGroups),
        // cb.equal(modExpression, 1)));

        // http://www.altuure.com/2010/09/23/jpa-criteria-api-by-samples-%E2%80%93-part-ii/

        System.out.println(entityManager.createQuery(query).setParameter("userId", userId).getResultList());

        // System.out.println(researchService.findAll());
    }

    @Test
    public void findUserGroups() {
        Integer userId = 1;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        ParameterExpression<Integer> param = cb.parameter(Integer.class, "userId");

        CriteriaQuery<Integer> query = cb.createQuery(Integer.class);
        Root<Group> root = query.from(Group.class);
        SetJoin<Group, User> users = root.join(Group_.users);
        query.where(cb.equal(users.get(User_.id), param));
        query.select(root.get(Group_.id));

        System.out.println(entityManager.createQuery(query).setParameter("userId", userId).getResultList());
    }

    @Test
    public void findAllWithgroupsTest() {
        // @Query("select distinct r from ResearchPermission p join p.target r where p.user.id = :userId and mod(p.mask / :bitMask, 2) = 1")
        // @Query("select distinct r from Research r join r.researchPermissions p where p.user.id = :userId and mod(p.mask / :bitMask, 2) = 1")
        // Criteria builder

        Integer userId = 1;
        Integer bitMask = 1;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Research> query = cb.createQuery(Research.class);
        Root<Research> root = query.from(Research.class);
        query.select(root);
        query.distinct(true);
        Join<Research, ResearchPermission> researchPermission = root.join("permissions", JoinType.LEFT);
        // Join<Research, ResearchPermission> researchPermission =
        // root.join(Research_.researchPermissions, JoinType.LEFT);

        Path<Integer> userIdPath = researchPermission.get(AbstractPermission_.user).get(User_.id);
        Path<Group> group = researchPermission.get(AbstractPermission_.group);
        Path<Integer> mask = researchPermission.get(AbstractPermission_.mask);

        ParameterExpression<Integer> param = cb.parameter(Integer.class, "userId");
        Predicate predicate = cb.equal(userIdPath, param);

        Expression<Number> divExpression = cb.quot(mask, bitMask);
        Expression<Integer> modExpression = cb.mod(divExpression.as(Integer.class), 2);

        // Predicate inGroups = group.in(Group.with().id(1).build());

        Subquery<Integer> subquery = query.subquery(Integer.class);
        Root<Group> rootSubquery = subquery.from(Group.class);
        SetJoin<Group, User> users = rootSubquery.join(Group_.users, JoinType.LEFT);
        subquery.select(rootSubquery.get(Group_.id));
        subquery.where(cb.equal(users.get(User_.id), param));

        // Predicate inGroups = group.get(Group_.id).in(subquery);

        CriteriaQuery<Integer> userGroupQuery = cb.createQuery(Integer.class);
        Root<Group> rootUserGroup = userGroupQuery.from(Group.class);
        SetJoin<Group, User> join = rootUserGroup.join(Group_.users);
        userGroupQuery.where(cb.equal(join.get(User_.id), param));
        userGroupQuery.select(rootUserGroup.get(Group_.id));

        List<Integer> userGroups = entityManager.createQuery(userGroupQuery).setParameter("userId", userId)
                .getResultList();
        if (userGroups.isEmpty()) {
            query.where(cb.and(predicate), cb.equal(modExpression, 1));
        } else {
            Predicate inGroups = group.get(Group_.id).in(userGroups);
            query.where(cb.and(cb.or(inGroups, predicate), cb.equal(modExpression, 1)));
        }

        // query.where(cb.and(cb.or(predicate, inGroups),
        // cb.equal(modExpression, 1)));

        // http://www.altuure.com/2010/09/23/jpa-criteria-api-by-samples-%E2%80%93-part-ii/

        System.out.println(entityManager.createQuery(query).setParameter("userId", userId).getResultList());

        // System.out.println(researchService.findAll());
    }

    @Test
    public void findAllTest() {
        // @Query("select distinct r from ResearchPermission p join p.target r where p.user.id = :userId and mod(p.mask / :bitMask, 2) = 1")
        // @Query("select distinct r from Research r join r.researchPermissions p where p.user.id = :userId and mod(p.mask / :bitMask, 2) = 1")
        // Criteria builder

        Integer userId = 1;
        Integer bitMask = 1;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Research> query = cb.createQuery(Research.class);
        Root<Research> root = query.from(Research.class);
        query.select(root);
        query.distinct(true);
        // Join<Research, ResearchPermission> researchPermission =
        // root.join(Research_.researchPermissions, JoinType.LEFT);
        Join<Research, ResearchPermission> researchPermission = root.join("permissions", JoinType.LEFT);
        Path<User> user = researchPermission.get(AbstractPermission_.user);
        Path<Integer> mask = researchPermission.get(AbstractPermission_.mask);

        Predicate predicate = cb.equal(user, User.with().id(userId).build());

        Expression<Number> divExpression = cb.quot(mask, bitMask);
        Expression<Integer> modExpression = cb.mod(divExpression.as(Integer.class), 2);
        query.where(cb.and(predicate, cb.equal(modExpression, 1)));

        System.out.println(entityManager.createQuery(query).getResultList());

        // System.out.println(researchService.findAll());
    }
}
