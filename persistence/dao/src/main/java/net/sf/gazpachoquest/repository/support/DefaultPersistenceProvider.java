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

import static org.springframework.data.jpa.repository.utils.JpaClassUtils.isEntityManagerOfType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.spi.PersistenceProvider;

import org.eclipse.persistence.jpa.JpaQuery;
import org.springframework.data.jpa.repository.query.QueryExtractor;

/**
 * 
 * @author Boris lam This class is use when you use DefaultRepositoryFactory to
 *         override default repository factory
 *         class.
 * 
 */

public enum DefaultPersistenceProvider implements QueryExtractor {

    /**
     * EclipseLink persistence provider.
     */
    ECLIPSELINK("org.eclipse.persistence.jpa.JpaEntityManager") {

        @Override
        public String extractQueryString(final Query query) {
            return ((JpaQuery<?>) query).getDatabaseQuery().getJPQLString();
        }

    },

    /**
     * Unknown special provider. Use standard JPA.
     */
    GENERIC_JPA("javax.persistence.EntityManager") {

        @Override
        public boolean canExtractQuery() {

            return false;
        }

        @Override
        public String extractQueryString(final Query query) {

            return null;
        }
    },

    /**
     * Hibernate persistence provider.
     */
    HIBERNATE("org.hibernate.ejb.HibernateEntityManager") {

        @Override
        public String extractQueryString(final Query query) {

            // return ((HibernateQuery)
            // query).getHibernateQuery().getQueryString();
            return null;
        }

        /**
         * Return custom placeholder ({@code *}) as Hibernate does create
         * invalid queries for count queries for objects
         * with compound keys.
         * 
         * @see HHH-4044
         * @see HHH-3096
         */
        @Override
        protected String getCountQueryPlaceholder() {

            return "*";
        }
    },

    /**
     * OpenJpa persistence provider.
     */
    OPEN_JPA("org.apache.openjpa.persistence.OpenJPAEntityManager") {

        @Override
        public String extractQueryString(final Query query) {
            // return ((OpenJPAQuery) query).getQueryString();
            return null;
        }
    };

    /**
     * Determines the {@link PersistenceProvider} from the given
     * {@link EntityManager}. If no special one can be
     * determined {@value #GENERIC_JPA} will be returned.
     * 
     * @param em
     * @return
     */
    public static DefaultPersistenceProvider fromEntityManager(final EntityManager em) {

        for (DefaultPersistenceProvider provider : values()) {
            if (isEntityManagerOfType(em, provider.entityManagerClassName)) {
                return provider;
            }
        }

        return GENERIC_JPA;
    }

    private String entityManagerClassName;

    /**
     * Creates a new {@link PersistenceProvider}.
     * 
     * @param entityManagerClassName
     *            the name of the provider specific {@link EntityManager}
     *            implementation
     */
    private DefaultPersistenceProvider(final String entityManagerClassName) {

        this.entityManagerClassName = entityManagerClassName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.data.jpa.repository.query.QueryExtractor#canExtractQuery
     * ()
     */
    @Override
    public boolean canExtractQuery() {

        return true;
    }

    /**
     * Returns the placeholder to be used for simple count queries. Default
     * implementation returns {@code *}.
     * 
     * @return
     */
    protected String getCountQueryPlaceholder() {

        return "x";
    }

}
