package net.sf.gazpachoquest.services.impl;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.UserRepository;
import net.sf.gazpachoquest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends AbstractPersistenceService<User> implements UserService {

    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public User save(final User user) {
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
