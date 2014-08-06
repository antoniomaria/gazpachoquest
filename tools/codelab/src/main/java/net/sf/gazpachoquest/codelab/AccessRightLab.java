package net.sf.gazpachoquest.codelab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.sf.gazpachoquest.codelab.randomuser.RandomUserCreator;
import net.sf.gazpachoquest.codelab.randomuser.support.RandomUser;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.services.GroupService;
import net.sf.gazpachoquest.services.PermissionService;
import net.sf.gazpachoquest.services.RoleService;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.types.EntityType;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Perm;
import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessRightLab {

    private static Logger logger = LoggerFactory.getLogger(AccessRightLab.class);

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RandomTokenGenerator tokenGenerator;

    @PersistenceContext
    private EntityManager entityManager;

    public void execute() {
        // select g.id from users u join user_group ug on u.id = ug.user_id join
        // groups g on ug.group_id=g.id where u.id=1
        Integer userId = 1;
        String userGroups = "select g.id from Group g left join g.users u where u.id = :userId";
        Query query = entityManager.createQuery(userGroups);
        query.setParameter("userId", userId);
        List<Integer> userGroupIds = query.getResultList();

        // select r.* from role r join user_role ur on ur.role_id = r.id join
        // users u on ur.user_id = u.id where u.id = 1
        String userRoleIdsJPQL = "select r from Role r left join r.users u where u.id = :userId";
        query = entityManager.createQuery(userRoleIdsJPQL);
        query.setParameter("userId", userId);
        List<Role> userRoleIds = query.getResultList();

        // Group Roles per user
        // select r.* from role r join group_role gr on gr.role_id = r.id join
        // groups g on gr.group_id = g.id where g.id in (select g.id from users
        // u join user_group ug on u.id = ug.user_id join groups g on
        // ug.group_id=g.id where u.id=1)
        String groupRolesIdsJPQL = "select r from Role r left join r.groups g where g.id in (" + userGroups + ")";
        query = entityManager.createQuery(groupRolesIdsJPQL);
        query.setParameter("userId", userId);
        List<Role> groupRolesIds = query.getResultList();
        /*-
        String grantedPermissionJPQL = "select p from Permission p from ( " + groupRolesIdsJPQL + " union "
                + userRoleIdsJPQL + ") as r join r.permissions";
        query = entityManager.createQuery(grantedPermissionJPQL);
        query.setParameter("userId", userId);
        List<Permission> permissions = query.getResultList();
         */

        String grantedRoleJPQL = groupRolesIdsJPQL + " union " + userRoleIdsJPQL;
        query = entityManager.createQuery(grantedRoleJPQL);
        query.setParameter("userId", userId);
        List<Role> roles = query.getResultList();

        System.out.println(roles);
    }

    public void populateDataBase() {
        User support = userService.findOne(1);
        Role supportRole = roleService.findOne(2);

        Group administrators = Group.with().name("Administrators").build();
        Role administratorsRole = Role.with().name("Administrators role")
                .description("Specific role for administrators group").build();
        administrators.assignToRole(administratorsRole);

        administrators = groupService.save(administrators);

        groupService.addUserToGroup(support, administrators.getId());

        int userCount = 5;
        for (int index = 0; index < userCount; index++) {
            RandomUser randomUser = RandomUserCreator.getRandomUser();
            Gender gender = Gender.fromCode(randomUser.getGender().substring(0, 1).toUpperCase());
            User user = User.with().givenNames(randomUser.getName().getFirst()).surname(randomUser.getName().getLast())
                    .email(randomUser.getEmail()).gender(gender)
                    .username(randomUser.getUsername() + "_" + tokenGenerator.generate(5))
                    .password(randomUser.getPassword()).build();
            user = userService.save(user);

            if (index < userCount - 1) {
                if (index % 2 == 0) {
                    Permission individualPermission = Permission.with().entityId(user.getId()).scope(EntityType.USER)
                            .addPerm(Perm.UPDATE).addPerm(Perm.READ).addPerm(Perm.DELETE).build();
                    individualPermission.setRole(supportRole);

                    permissionService.save(individualPermission);
                } else {
                    Permission groupPermission = Permission.with().entityId(user.getId()).scope(EntityType.USER)
                            .addPerm(Perm.READ).build();
                    groupPermission.setRole(administratorsRole);

                    permissionService.save(groupPermission);
                }
            } else {
                Permission individualPermission = Permission.with().entityId(user.getId()).scope(EntityType.USER)
                        .addPerm(Perm.UPDATE).addPerm(Perm.READ).addPerm(Perm.DELETE).build();
                individualPermission.setRole(supportRole);

                permissionService.save(individualPermission);
                Permission groupPermission = Permission.with().entityId(user.getId()).scope(EntityType.USER)
                        .addPerm(Perm.READ).build();
                groupPermission.setRole(administratorsRole);

                permissionService.save(groupPermission);
            }

        }

    }
}
