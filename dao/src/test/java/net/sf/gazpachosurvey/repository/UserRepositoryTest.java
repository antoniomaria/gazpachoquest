package net.sf.gazpachosurvey.repository;

import net.sf.gazpachosurvey.domain.user.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
        "classpath:/hsql-context.xml" })
public class UserRepositoryTest {

    private static final Logger logger = LoggerFactory
            .getLogger(SurveyRunningRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest() {
        User user = new User();
        user.setEmail("admin@gazpachosurvey.net");
        user.setFirstName("admin");
        user.setLastName("admin");
        User savedUser = userRepository.save(user);
        
        System.out.println(userRepository.count());
    }

}
