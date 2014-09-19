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
import java.util.Set;

import net.sf.gazpachoquest.domain.permission.QuestionnaireDefinitionPermission;
import net.sf.gazpachoquest.domain.permission.QuestionnairePermission;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends GenericRepository<User> {

    @Query("select g from Group g  left join g.users u where u.id = :userId")
    Set<Group> getGroups(@Param("userId")
    Integer userId);

    @Query("select r from Role r left join r.users u where u.id = :userId")
    Set<Role> getRoles(@Param("userId")
    Integer userId);

    @Query("select qdp from QuestionnaireDefinitionPermission qdp where qdp.user.id = :userId ")
    List<QuestionnaireDefinitionPermission> getQuestionnairDefinitionPermissions(@Param("userId")
    Integer userId);

    @Query("select qp from QuestionnairePermission qp where qp.user.id = :userId ")
    List<QuestionnairePermission> getQuestionnairPermissions(@Param("userId")
    Integer userId);

    @Query("select rp from ResearchPermission rp where rp.user.id = :userId")
    List<QuestionnairePermission> getResearchPermissions(@Param("userId")
    Integer userId);

    @Query("select up from UserPermission up where up.user.id = :userId")
    List<QuestionnairePermission> getUserPermissions(@Param("userId")
    Integer userId);

}
