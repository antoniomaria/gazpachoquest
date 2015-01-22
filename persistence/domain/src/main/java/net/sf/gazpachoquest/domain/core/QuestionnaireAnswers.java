/*
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 */
package net.sf.gazpachoquest.domain.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.sf.gazpachoquest.domain.support.Persistable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;

public class QuestionnaireAnswers implements Persistable {
    private static final long serialVersionUID = -214686516454070394L;

    private Integer id;

    private Map<String, Object> answers;

    public QuestionnaireAnswers() {
        super();
    }

    public Map<String, Object> getAnswers() {
        if (answers == null) {
            answers = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
        }
        return answers;
    }

    public void setAnswers(Map<String, Object> answers) {
        this.answers = answers;
    }

    public void setAnswer(String code, Object answer) {
        Assert.notNull(code);
        getAnswers().put(code.toLowerCase(), answer);
    }

    public Object getAnswer(String code) {
        return getAnswers().get(code);
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public int hashCode() {
        if (!isNew()) {
            return (new HashCodeBuilder()).append(getId()).toHashCode();
        } else {
            return HashCodeBuilder.reflectionHashCode(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persistable) {
            final Persistable other = (Persistable) obj;
            if (!isNew()) {
                return (new EqualsBuilder()).append(getId(), other.getId()).isEquals();
            } else {
                return EqualsBuilder.reflectionEquals(this, obj);
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

    public static Builder with() {
        return new Builder();
    }
    
    /**
     * @hidden 
     */
    public static class Builder {
        private Integer id;
        private Map<String, Object> answers;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder answer(String code, Object answer) {
            Assert.notNull(code);
            if (answer == null) {
                answers = new HashMap<String, Object>();
            }
            answers.put(code.toLowerCase(), answer);
            return this;
        }

        public QuestionnaireAnswers build() {
            QuestionnaireAnswers questionnaireAnswers = new QuestionnaireAnswers();
            questionnaireAnswers.setId(id);
            return questionnaireAnswers;
        }
    }
}
