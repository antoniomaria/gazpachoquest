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
package net.sf.gazpachoquest.domain.support;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractSecurizableLocalizable<P extends Permission<?>, TR extends Translation<LS>, LS extends LanguageSettings>
        extends AbstractAuditable implements Localizable<LS, TR>, Securizable<P> {

    protected AbstractSecurizableLocalizable() {
        super();
    }

    @OneToMany(mappedBy = "target", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @XmlTransient
    protected final Set<P> permissions = new HashSet<P>();

    @Override
    public Set<P> getPermissions() {
        return Collections.unmodifiableSet(permissions);
    }

}
