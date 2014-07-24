/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.user.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.user.GroupRepository;
import net.sf.gazpachoquest.repository.user.RoleRepository;
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

    private static final int SECRET_LENGTH = 32;

    @Autowired
    private RandomTokenGenerator tokenGenerator;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public User save(final User user) {
        User existing = null;
        if (user.isNew()) {
            user.setApiKey(tokenGenerator.generate(API_KEY_LENGTH));
            user.setSecret(tokenGenerator.generate(SECRET_LENGTH));
            Role role = Role.with().name("User Role")
                    .description(String.format("Specific role for %s %s ", user.getGivenNames(), user.getSurname()))
                    .build();
            existing = repository.save(user);

            role = roleRepository.save(role);
            existing.assignToRole(role);
            existing.setDefaultRole(role);
        } else {
            existing = repository.findOne(user.getId());
            existing.setEmail(user.getEmail());
            existing.setGivenNames(user.getGivenNames());
            existing.setSurname(user.getSurname());

            if (StringUtils.isNotEmpty(user.getSecret())) {
                user.setSecret(tokenGenerator.generate(SECRET_LENGTH));
            }
            existing.setPreferredLanguage(user.getPreferredLanguage());
            existing.setGender(user.getGender());
        }
        return existing;
    }

    @Override
    public Set<Permission> getPermissions(Integer userId) {
        Set<Permission> permissions = new HashSet<Permission>();
        permissions.addAll(((UserRepository) repository).getPermissions(userId));
        List<Group> groups = ((UserRepository) repository).getGroups(userId);
        for (Group group : groups) {
            List<Permission> groupPermissions = groupRepository.getPermissions(group.getId());
            permissions.addAll(groupPermissions);
        }

        return permissions;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Group> getGroups(Integer userId) {
        return ((UserRepository) repository).getGroups(userId);
    }

    @Override
    public Set<Role> getRoles(Integer userId) {
        return ((UserRepository) repository).getRoles(userId);
    }
}
