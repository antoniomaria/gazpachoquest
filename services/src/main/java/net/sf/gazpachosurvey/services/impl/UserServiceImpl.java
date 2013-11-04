package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.user.UserAccount;
import net.sf.gazpachosurvey.dto.UserAccountDTO;
import net.sf.gazpachosurvey.repository.UserAccountRepository;
import net.sf.gazpachosurvey.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractPersistenceService<UserAccount, UserAccountDTO> implements UserService {

    @Autowired
    public UserServiceImpl(UserAccountRepository repository) {
        super(repository, UserAccount.class, UserAccountDTO.class);
    }

}
