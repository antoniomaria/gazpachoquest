package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.UserDTO;

public interface UserFacade {

    void delete(Integer id);

    UserDTO findOne(Integer id);

    UserDTO save(UserDTO user);

}
