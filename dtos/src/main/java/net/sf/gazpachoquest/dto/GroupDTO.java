/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.AbstractAuditableDTO;

@SuppressWarnings("serial")
public class GroupDTO extends AbstractAuditableDTO {

    private String name;

    private String description;

    public GroupDTO() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description = "";

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public GroupDTO build() {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.name = name;
            groupDTO.description = description;
            return groupDTO;
        }
    }
}
