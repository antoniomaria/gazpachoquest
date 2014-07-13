/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.codelab;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.user.UserRepository;
import net.sf.gazpachoquest.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HStoreLab {

    private static Logger logger = LoggerFactory.getLogger(HStoreLab.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userService;
    
    /*-
     * http://www.youlikeprogramming.com/2011/11/working-with-the-hstore-data-type-in-postgresql-9-0/
     * http://skipperkongen.dk/2012/08/02/examples-of-querying-a-osm-postgresql-table-with-the-hstore-tags-column/
     */
    public void execute() {
        String attributeName = "position";
        String attributeValue = "manager";
        logger.debug("Starting");
        User user = userService.findOne(4);
        HashMap<String, String> attributes = new HashMap<String, String>();
        user.setAttributes(attributes);
        // SELECT * FROM users wHERE attributes->'age'='25' and attributes->'position' IN ('Manager');
        // http://www.creapptives.com/post/14062057061/the-key-value-store-everyone-ignored-postgresql
        userService.save(user);
        logger.debug("the End!");
        
     }

    @SuppressWarnings("unchecked")
    private List<User> findByAttributeName(String attributeName, String attributeValue) {
        String sqlString = String.format("SELECT * FROM users WHERE attributes @> '\"%s\"=>\"%s\"'::hstore",
                attributeName, attributeValue);
        List<User> users = entityManager.createNativeQuery(sqlString, User.class).getResultList();
        return users;
    }

}
