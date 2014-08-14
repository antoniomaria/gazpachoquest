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
package net.sf.gazpachoquest.domain.core;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gazpachoquest.domain.support.AbstractAuditable;
import net.sf.gazpachoquest.jpa.converter.RenderingModeConverter;
import net.sf.gazpachoquest.types.RenderingMode;

@Entity
@Table(name = "breadcrumb")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Breadcrumb extends AbstractAuditable {

    private static final long serialVersionUID = 8807488300208839486L;

    @ManyToOne(fetch = FetchType.LAZY)
    protected Questionnair questionnair;

    @Enumerated(EnumType.STRING)
    @Convert(converter = RenderingModeConverter.class)
    protected RenderingMode renderingMode;

    @Basic
    protected Boolean last;

    public Breadcrumb() {
        super();
    }

    public Questionnair getQuestionnair() {
        return questionnair;
    }

    public void setQuestionnair(Questionnair questionnair) {
        this.questionnair = questionnair;
    }

    public Boolean isLast() {
        return last;
    }

    public void setLast(Boolean actual) {
        last = actual;
    }

    public static BuilderImpl withProps() {
        return new BuilderImpl();
    }

    public RenderingMode getRenderingMode() {
        return renderingMode;
    }

    public void setRenderingMode(RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

    public static class BuilderImpl {
        private Integer id;
        private Questionnair questionnair;
        private Boolean last;

        public BuilderImpl questionnair(Questionnair questionnair) {
            this.questionnair = questionnair;
            return this;
        }

        public BuilderImpl id(Integer id) {
            this.id = id;
            return this;
        }

        public BuilderImpl last(Boolean last) {
            this.last = last;
            return this;
        }

        public Breadcrumb build() {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setId(id);
            breadcrumb.questionnair = questionnair;
            breadcrumb.last = last;
            return breadcrumb;
        }
    }
}
