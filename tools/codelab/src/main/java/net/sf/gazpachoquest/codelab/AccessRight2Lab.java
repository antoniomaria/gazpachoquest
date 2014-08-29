package net.sf.gazpachoquest.codelab;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.permission.ResearchPermission;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.services.GroupService;
import net.sf.gazpachoquest.services.ResearchService;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.services.permission.ResearchPermissionService;
import net.sf.gazpachoquest.types.Perm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessRight2Lab {

    private static Logger logger = LoggerFactory.getLogger(AccessRight2Lab.class);

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private ResearchPermissionService researchPermissionService;

    @Autowired
    private ResearchService researchService;

    @PersistenceContext
    private EntityManager entityManager;

    public void execute() {
        populateDataBase();

    }

    public void populateDataBase() {
        User support = userService.findOne(1);

        Group administrators = Group.with().name("Administrators").build();
        administrators = groupService.save(administrators);

        groupService.addUserToGroup(support, administrators.getId());

        ResearchPermission permission = null;
        Research research = null;

        research = researchService.findOne(102);
        permission = ResearchPermission.with().user(support).target(research).addPerm(Perm.READ).build();
        researchPermissionService.save(permission);

        permission = ResearchPermission.with().group(administrators).target(research).addPerm(Perm.READ)
                .addPerm(Perm.UPDATE).build();
        researchPermissionService.save(permission);

        research = researchService.findOne(119);
        permission = ResearchPermission.with().user(support).target(research).addPerm(Perm.READ).build();
        researchPermissionService.save(permission);

        research = researchService.findOne(211);
        permission = ResearchPermission.with().user(support).target(research).addPerm(Perm.READ).addPerm(Perm.UPDATE)
                .build();
        researchPermissionService.save(permission);

        User tyrion = userService.findOne(4);

        research = researchService.findOne(228);
        permission = ResearchPermission.with().user(tyrion).target(research).addPerm(Perm.READ).build();
        researchPermissionService.save(permission);

    }
}
