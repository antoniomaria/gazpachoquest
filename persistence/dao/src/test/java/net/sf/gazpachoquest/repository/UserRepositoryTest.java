package net.sf.gazpachoquest.repository;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachoquest.domain.support.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.repository.user.UserRepository;
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

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("UserRepository-dataset.xml")
@DatabaseTearDown("UserRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void getRolesTest() {
        Integer userId = 1;
        List<Role> roles = repository.getRoles(userId);
        assertThat(roles).contains(Role.with().id(1).build());
    }
    @Test
    public void getPermissionsTest() {
        Integer userId = 1;
        List<Permission<?>> roles = repository.getPermissions(userId);
    System.out.println(roles);
        System.out.println("fin");
    }
}
