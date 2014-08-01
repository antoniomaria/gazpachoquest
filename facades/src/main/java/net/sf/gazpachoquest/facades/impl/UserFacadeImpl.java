/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.facades.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.dto.support.PageDTO;
import net.sf.gazpachoquest.facades.UserFacade;
import net.sf.gazpachoquest.services.UserService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public List<UserDTO> findAll() {
        List<User> entities = userService.findAll();
        List<UserDTO> users = new ArrayList<>();
        for (User entity : entities) {
            users.add(mapper.map(entity, UserDTO.class));
        }
        return users;
    }

    @Override
    public PageDTO<UserDTO> findPaginated(Integer pageNumber, Integer size) {
        Page<User> page = userService.findPaginated(pageNumber, size);
        PageDTO<UserDTO> pageDTO = new PageDTO<>();
        pageDTO.setNumber(page.getNumber());
        pageDTO.setSize(page.getSize());
        pageDTO.setTotalPages(page.getTotalPages());
        pageDTO.setTotalElements(page.getTotalElements());

        for (User user : page.getContent()) {
            UserDTO userDTO = mapper.map(user, UserDTO.class);
            pageDTO.addElement(userDTO);
        }
        return pageDTO;
    }

    @Override
    public UserDTO save(final UserDTO user) {
        User entity = mapper.map(user, User.class);
        return mapper.map(userService.save(entity), UserDTO.class);
    }

}
