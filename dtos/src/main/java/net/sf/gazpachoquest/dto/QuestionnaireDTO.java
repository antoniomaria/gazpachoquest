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
package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "QuestionnaireDTO", description = "Questionnaire resource representation")
@SuppressWarnings("serial")
public class QuestionnaireDTO extends AbstractIdentifiableDTO {

    public QuestionnaireDTO() {
        super();
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public QuestionnaireDTO build() {
            QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
            questionnaireDTO.setId(id);
            return questionnaireDTO;
        }
    }
}
