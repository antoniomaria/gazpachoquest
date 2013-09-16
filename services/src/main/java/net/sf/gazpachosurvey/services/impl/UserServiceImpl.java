package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.user.User;
import net.sf.gazpachosurvey.dto.UserDTO;
import net.sf.gazpachosurvey.repository.UserRepository;
import net.sf.gazpachosurvey.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  extends AbstractPersistenceService<User, UserDTO, Integer> implements UserService { 

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository, User.class, UserDTO.class);
    }

}
