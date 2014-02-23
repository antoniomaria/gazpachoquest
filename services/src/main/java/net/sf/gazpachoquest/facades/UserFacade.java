package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.UserDTO;

public interface UserFacade {

    void delete(Integer id);

    UserDTO findOne(Integer id);

    UserDTO save(UserDTO user);

}
