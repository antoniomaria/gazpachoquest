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
package net.sf.gazpachoquest.repository.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import net.sf.gazpachoquest.qbe.ByExampleSpecification;
import net.sf.gazpachoquest.qbe.NamedQueryUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class DefaultRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends
        JpaRepositoryFactoryBean<T, S, ID> {

    @Autowired
    private ByExampleSpecification byExampleSpecification;

    @Autowired
    private NamedQueryUtil namedQueryUtil;

    /**
     * Returns a {@link RepositoryFactorySupport}.
     * 
     * @param entityManager
     * @return
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(final EntityManager entityManager) {
        return new DefaultRepositoryFactory(entityManager, byExampleSpecification, namedQueryUtil);
    }
}
