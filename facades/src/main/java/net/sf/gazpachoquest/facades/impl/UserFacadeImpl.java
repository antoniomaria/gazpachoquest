/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.facades.impl;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.facades.UserFacade;
import net.sf.gazpachoquest.services.UserService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    @Override
    public void delete(final Integer id) {
        userService.delete(id);
    }

    @Override
    public UserDTO findOne(Integer id) {
        User user = userService.findOne(id);
        if (user == null) {
            return null;
        }
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO save(final UserDTO user) {
        User entity = mapper.map(user, User.class);
        return mapper.map(userService.save(entity), UserDTO.class);
    }

}
