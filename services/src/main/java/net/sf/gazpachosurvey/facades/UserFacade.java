package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.UserDTO;

public interface UserFacade {

    UserDTO save(UserDTO participant);

    UserDTO findOne(Integer id);

    void delete(Integer id);

}
