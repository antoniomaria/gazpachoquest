package net.sf.gazpachoquest.codelab;

import net.sf.gazpachoquest.codelab.randomuser.RandomUserCreator;
import net.sf.gazpachoquest.codelab.randomuser.support.RandomUser;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.services.GroupService;
import net.sf.gazpachoquest.services.PermissionService;
import net.sf.gazpachoquest.services.RoleService;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.types.Gender;
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

    public void execute() {
        User support = userService.findOne(1);
        Role supportRole = roleService.findOne(2);
        Group administrators = groupService.save(Group.with().name("Administrator").build());

        Role administratorsRole = roleService.save(Role.with().name("Specific role for administrators group").build());

        administrators.assignToRole(administratorsRole);
        administrators.assignUser(support);
        groupService.save(administrators);

        int userCount = 5;
        for (int index = 0; index < userCount; index++) {
            RandomUser randomUser = RandomUserCreator.getRandomUser();
            Gender gender = Gender.fromCode(randomUser.getGender().substring(0, 1).toUpperCase());
            User user = User.with().givenNames(randomUser.getName().getFirst()).surname(randomUser.getName().getLast())
                    .email(randomUser.getEmail()).gender(gender)
                    .username(randomUser.getUsername() + "_" + tokenGenerator.generate(5))
                    .password(randomUser.getPassword()).build();
            user = userService.save(user);

        }

    }
}
