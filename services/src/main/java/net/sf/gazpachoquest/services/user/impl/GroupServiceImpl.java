/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.user.impl;

import java.util.List;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.user.GroupRepository;
import net.sf.gazpachoquest.repository.user.UserRepository;
import net.sf.gazpachoquest.services.GroupService;
import net.sf.gazpachoquest.services.core.impl.AbstractPersistenceService;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class GroupServiceImpl extends AbstractPersistenceService<Group> implements GroupService {

    @Autowired
    private UserRepository participantRepository;

    @Autowired
    public GroupServiceImpl(final GroupRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Group save(final Group group) {
        Group existing = null;
        if (group.isNew()) {
            existing = repository.save(group);
        } else {
            existing = repository.findOne(group.getId());
            existing.setName(group.getName());
            existing.setDescription(group.getDescription());
        }
        return existing;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Group> findGroups(Integer userId) {
        return ((GroupRepository) repository).findGroups(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsersInGroup(Integer groupId) {
        return ((GroupRepository) repository).findUsersInGroup(groupId);
    }

    public List<Role> getRoles(Integer groupId) {
        return ((GroupRepository) repository).getRoles(groupId);
    }

    @Transactional(readOnly = false)
    @Override
    public void addUserToGroup(User user, Integer groupId) {
        Group group = repository.findOne(groupId);
        Assert.notNull(group, "Group not found");
        Assert.state(!user.isNew(), "Persist user before adding to groups");

        user = participantRepository.findOne(user.getId());
        Assert.notNull(user, "User not found");
        group.assignUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean isUserInGroup(Integer userId, Integer groupId) {
        return BooleanUtils.toBoolean(((GroupRepository) repository).isUserInGroup(userId, groupId));
    }

    @Transactional(readOnly = true)
    @Override
    public boolean isUserInGroup(Integer userId, String groupName) {
        return BooleanUtils.toBoolean(((GroupRepository) repository).isUserInGroup(userId, groupName));
    }
}
