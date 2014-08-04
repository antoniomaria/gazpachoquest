package net.sf.gazpachoquest.codelab.massive;

import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachoquest.codelab.randomuser.RandomUserCreator;
import net.sf.gazpachoquest.codelab.randomuser.support.RandomUser;
import net.sf.gazpachoquest.domain.user.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.services.PermissionService;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.types.EntityType;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Perm;
import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MassiveUserLoadLab {

    private static Logger logger = LoggerFactory.getLogger(MassiveUserLoadLab.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    private final String positions[] = { "employee", "supervisor", "foreman", "manager", "vice president " };

    private final String divisions[] = { "Helsinki", "Jyväskylä", "Roma", "Madrid", "London", "Berlin", "Barcelona",
            "Paris", "Moscow" };

    private final String companies[] = { "Basware", "Codenomicon", "Rovio Mobile", "Supercell", "Tieto", "Vaisala",
            "Stockmann", "Verkkokauppa.com", "Fazer", "Metso" };

    @Autowired
    private RandomTokenGenerator tokenGenerator;

    public void execute() {
        int userCount = 10;

        for (int index = 0; index < userCount; index++) {
            RandomUser randomUser = RandomUserCreator.getRandomUser();
            Gender gender = Gender.fromCode(randomUser.getGender().substring(0, 1).toUpperCase());
            User user = User.with().givenNames(randomUser.getName().getFirst()).surname(randomUser.getName().getLast())
                    .email(randomUser.getEmail()).gender(gender)
                    .username(randomUser.getUsername() + "_" + tokenGenerator.generate(5))
                    .password(randomUser.getPassword()).build();

            Map<String, String> attributes = new HashMap<String, String>();
            attributes.put("ssn", randomUser.getSSN());
            attributes.put("age", String.valueOf(RandomUtils.nextInt(18) + 20));
            attributes.put("company", getCompany());
            attributes.put("division", getDivision());
            attributes.put("position", getPosition());
            attributes.put("title", randomUser.getName().getTitle());
            user.setAttributes(attributes);

            user = userService.save(user);
            logger.info("User {} created with id {}", index, user.getId());
            Permission entity = Permission.with().entityId(user.getId()).scope(EntityType.USER).addPerm(Perm.READ)
                    .build();
            entity.setRole(Role.with().id(2).build());

            permissionService.save(entity);
        }

        // SELECT * FROM users WHERE attributes @>
        // '"division"=>"Helsinki","position"=>"manager","title"=>"mr"'::hstore

    }

    private String getDivision() {
        return divisions[RandomUtils.nextInt(divisions.length)];
    }

    private String getCompany() {
        return companies[RandomUtils.nextInt(companies.length)];
    }

    private String getPosition() {
        float random = RandomUtils.nextFloat() * 10;
        if (random < 7) {
            return positions[0];
        } else if (random > 7 && random < 8) {
            return positions[1];
        } else if (random > 8 && random < 8.5) {
            return positions[2];
        } else if (random > 8.5 && random < 9.5) {
            return positions[3];
        } else {
            return positions[4];
        }
    }
}
