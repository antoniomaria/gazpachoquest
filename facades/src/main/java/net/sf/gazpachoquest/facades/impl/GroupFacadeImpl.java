/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.facades.impl;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.GroupDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.facades.GroupFacade;
import net.sf.gazpachoquest.services.GroupService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupFacadeImpl implements GroupFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private GroupService groupService;

    @Override
    public void delete(final Integer id) {
        groupService.delete(id);
    }

    @Override
    public GroupDTO findOne(Integer id) {
        Group group = groupService.findOne(id);
        if (group == null) {
            return null;
        }
        return mapper.map(group, GroupDTO.class);
    }

    @Override
    public GroupDTO save(final GroupDTO group) {
        Group entity = mapper.map(group, Group.class);
        return mapper.map(groupService.save(entity), GroupDTO.class);
    }

    @Override
    public void addUserToGroup(UserDTO userDTO, Integer groupId) {
        User user = null;
        if (userDTO != null) {
            user = mapper.map(userDTO, User.class);
        }
        groupService.addUserToGroup(user, groupId);

    }

}
