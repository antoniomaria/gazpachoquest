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
package net.sf.gazpachoquest.repository.dynamic;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.dynamic.DynamicClassLoader;
import org.eclipse.persistence.internal.queries.ReportItem;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.queries.ConstructorReportItem;
import org.eclipse.persistence.queries.DatabaseQuery;
import org.eclipse.persistence.queries.ReportQuery;
import org.eclipse.persistence.sessions.server.Server;

/**
 * Simple helper responsible for creation of JPA and MOXy contexts.
 * 
 * @author dclarke
 */
public class PersistenceHelper {

    public static final String EMPLOYEE_API_PU = "employee-api";

    public static EntityManagerFactory createEntityManagerFactory(DynamicClassLoader dcl, String persistenceUnit,
            boolean createTables) {
        Map<String, Object> props = new HashMap<String, Object>();

        // Ensure the persistence.xml provided data source are ignored for Java
        // SE testing
        props.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, "");
        props.put(PersistenceUnitProperties.JTA_DATASOURCE, "");

        if (createTables) {
            props.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE);
            props.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_DATABASE_GENERATION);
        }

        // Configure the use of embedded derby for the tests allowing system
        // properties of the same name to override
        props.put(PersistenceUnitProperties.JDBC_DRIVER, "org.hsqldb.jdbcDriver");
        props.put(PersistenceUnitProperties.JDBC_URL, "jdbc:hsqldb:mem:testdb");
        props.put(PersistenceUnitProperties.JDBC_USER, "sa");
        props.put(PersistenceUnitProperties.JDBC_PASSWORD, "");
        props.put(PersistenceUnitProperties.CLASSLOADER, dcl);
        props.put(PersistenceUnitProperties.WEAVING, "static");
        return Persistence.createEntityManagerFactory(persistenceUnit, props);
    }

    private static JAXBContext context;

    public static JAXBContext getContext(EntityManager em) throws JAXBException {
        if (context == null) {
            Set<Class<?>> classes = new HashSet<Class<?>>();

            Server serverSession = em.unwrap(Server.class);

            for (List<DatabaseQuery> queryList : serverSession.getQueries().values()) {
                for (DatabaseQuery query : queryList) {
                    if (query.isReportQuery()) {
                        ReportQuery rq = (ReportQuery) query;
                        for (ReportItem item : rq.getItems()) {
                            if (item.isConstructorItem()) {
                                classes.add(((ConstructorReportItem) item).getResultType());
                            }
                        }
                    }
                }
            }

            context = JAXBContextFactory.createContext(classes.toArray(new Class[classes.size()]), null);
        }
        return context;
    }

}
