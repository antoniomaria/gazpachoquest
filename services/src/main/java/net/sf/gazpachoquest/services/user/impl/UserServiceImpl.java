/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.user.impl;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.user.UserRepository;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.services.core.impl.AbstractPersistenceService;
import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends AbstractPersistenceService<User> implements UserService {

    private static final int API_KEY_LENGTH = 15;

    @Autowired
    private RandomTokenGenerator tokenGenerator;

    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public User save(final User user) {
        User existing = null;
        if (user.isNew()) {
            String apikey = user.getApiKey();
            if (StringUtils.isBlank(apikey)) {
                apikey = tokenGenerator.generate(API_KEY_LENGTH);
                user.setApiKey(apikey);
            }
            existing = repository.save(user);
        } else {
            existing = repository.findOne(user.getId());
            existing.setEmail(user.getEmail());
            existing.setGivenNames(user.getGivenNames());
            existing.setSurname(user.getSurname());

            existing.setPreferedLanguage(user.getPreferedLanguage());
            existing.setGender(user.getGender());
        }
        return existing;
    }
}
