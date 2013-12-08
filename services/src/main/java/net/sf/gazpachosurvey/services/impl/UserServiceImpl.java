package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.user.User;
import net.sf.gazpachosurvey.repository.UserRepository;
import net.sf.gazpachosurvey.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractPersistenceService<User> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User save(User user) {
        User existing = null;
        if (user.isNew()) {
            existing = repository.save(user);
        } else {
            existing = repository.findOne(user.getId());
            existing.setEmail(user.getEmail());
            existing.setFirstName(user.getFirstName());
            existing.setLastName(user.getLastName());
        }
        return existing;
    }

}
