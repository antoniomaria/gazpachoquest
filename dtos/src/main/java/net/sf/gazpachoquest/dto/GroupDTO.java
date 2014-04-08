/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import java.util.Set;

import net.sf.gazpachoquest.dto.support.AbstractAuditableDTO;

public class GroupDTO extends AbstractAuditableDTO {

    private static final long serialVersionUID = 7370786032611110768L;

    private String name;

    private Set<UserDTO> users;

    public GroupDTO() {
        super();
    }

    public void addUser(final UserDTO user) {
        if (!getUsers().contains(user)) {
            users.add(user);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public GroupDTO build() {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.name = name;
            return groupDTO;
        }
    }
}
