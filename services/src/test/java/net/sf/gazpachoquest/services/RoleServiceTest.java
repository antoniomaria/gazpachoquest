package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("RoleService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void findRolesByUserTest() {
        Integer userId = 2;
        List<Role> roles = roleService.findByUser(userId);
        assertThat(roles).contains(Role.with().id(1).build());
    }
}
