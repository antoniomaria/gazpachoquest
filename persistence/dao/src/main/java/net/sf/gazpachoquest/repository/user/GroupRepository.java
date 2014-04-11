/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.repository.user;

import java.util.List;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupRepository extends GenericRepository<Group> {

    @Query("select g from Group g  left join g.users u where u.id = :userId")
    List<Group> findGroups(@Param("userId")
    Integer userId);

    @Query("select count(g) from Group g left join g.users u where u.id = :userId and g.id = :groupId")
    int isUserInGroup(@Param("userId")
    Integer userId, @Param("groupId")
    Integer groupId);

    @Query("select u from User u left join u.groups g where g.id = :groupId")
    List<User> findUsersInGroup(@Param("groupId")
    Integer groupId);

    @Query("select count(g) from Group g left join g.users u where u.id = :userId and g.name like :groupName")
    int isUserInGroup(@Param("userId")
    Integer userId, @Param("groupName")
    String groupName);

    @Query("select r from Role r left join r.groups g where g.id = :groupId")
    List<Role> getRoles(@Param("groupId")
    Integer groupId);

}
