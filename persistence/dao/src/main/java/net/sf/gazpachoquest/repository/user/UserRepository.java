/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.repository.user;

import java.util.List;

import net.sf.gazpachoquest.domain.support.Permission;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends GenericRepository<User> {

    @Query("select g from Group g  left join g.users u where u.id = :userId")
    List<Group> getGroups(@Param("userId")
    Integer userId);

    @Query("select r from Role r left join r.users u where u.id = :userId")
    List<Role> getRoles(@Param("userId")
    Integer userId);

    @Query("select p from QuestionnairDefinitionPermission p where p.user.id = :userId  union "
            + "select rp from ResearchPermission rp where rp.user.id = :userId")
    List<Permission<?>> getPermissions(@Param("userId")
    Integer userId);

}
