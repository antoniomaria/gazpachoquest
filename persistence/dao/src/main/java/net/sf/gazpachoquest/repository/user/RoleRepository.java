/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.sf.gazpachoquest.domain.support.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.repository.support.GenericRepository;

public interface RoleRepository extends GenericRepository<Role> {

    @Query("select qdp from QuestionnaireDefinitionPermission qdp where qdp.role.id = :roleId union "
            + "select qp from QuestionnairePermission qp where qp.role.id = :roleId union "
            + "select rp from ResearchPermission rp where rp.role.id = :roleId union "
            + "select up from UserPermission up where up.role.id = :roleId")
    List<Permission<?>> getPermissions(@Param("roleId")
    Integer roleId);

}
