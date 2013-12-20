package net.sf.gazpachosurvey.facades.impl;

import net.sf.gazpachosurvey.domain.user.User;
import net.sf.gazpachosurvey.dto.UserDTO;
import net.sf.gazpachosurvey.facades.UserFacade;
import net.sf.gazpachosurvey.services.UserService;

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
    public UserDTO save(UserDTO user) {
        User entity = mapper.map(user, User.class);
        return mapper.map(userService.save(entity), UserDTO.class);
    }

    @Override
    public UserDTO findOne(Integer id) {
        return mapper.map(userService.findOne(id), UserDTO.class);
    }

    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }
}
