/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.facades;

import java.util.List;

import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.dto.support.PageDTO;

public interface UserFacade {

    void delete(Integer id);

    UserDTO findOne(Integer id);

    UserDTO save(UserDTO user);

    List<UserDTO> findAll();

    PageDTO<UserDTO> findPaginated(Integer pageNumber, Integer size);

}
