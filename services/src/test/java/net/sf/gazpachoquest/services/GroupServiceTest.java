package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.user.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@DatabaseSetup("GroupService-dataset.xml")
@DatabaseTearDown("GroupService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class GroupServiceTest {

    @Autowired
    private GroupService groupService;

    @Test
    public void getUsersInGroupTest() {
        Integer groupId = 2;
        List<User> users = groupService.getUsersInGroup(groupId);
        assertThat(users).hasSize(4);
    }

    @Test
    public void getRolesTest() {
        Integer groupId = 2;
        List<Role> roles = groupService.getRoles(groupId);
        assertThat(roles).hasSize(1);
    }

    @Test
    public void getPermissionsTest() {
        Integer groupId = 2;
        List<Permission> permissions = groupService.getPermissions(groupId);
        assertThat(permissions).hasSize(1);
    }

    @Test
    public void isUserInGroupTest() {
        Integer userId = 3;
        Integer groupId = 2;
        boolean isInGroup = groupService.isUserInGroup(userId, groupId);
        assertThat(isInGroup).isTrue();
    }

    @Test
    public void isUserInGroupIdentifiedByNameTest() {
        Integer userId = 3;
        String groupName = "Respondents";
        boolean isInGroup = groupService.isUserInGroup(userId, groupName);
        assertThat(isInGroup).isTrue();
    }
}
