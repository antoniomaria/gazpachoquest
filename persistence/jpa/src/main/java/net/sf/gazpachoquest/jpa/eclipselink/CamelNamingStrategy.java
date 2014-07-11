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
package net.sf.gazpachoquest.jpa.eclipselink;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.tools.schemaframework.IndexDefinition;

public class CamelNamingStrategy implements SessionCustomizer {

    public static String unqualify(final String qualifiedName) {
        int loc = qualifiedName.lastIndexOf(".");
        return loc < 0 ? qualifiedName : qualifiedName.substring(qualifiedName.lastIndexOf(".") + 1);
    }

    @Override
    public void customize(final Session session) throws SQLException {
        for (ClassDescriptor descriptor : session.getDescriptors().values()) {
            if (!descriptor.getTables().isEmpty()) {
                // Take table name from @Table if exists
                String tableName = null;
                if (descriptor.getAlias().equalsIgnoreCase(descriptor.getTableName())) {
                    tableName = unqualify(descriptor.getJavaClassName());
                } else {
                    tableName = descriptor.getTableName();
                }
                tableName = camelCaseToUnderscore(tableName);
                descriptor.setTableName(tableName);

                for (IndexDefinition index : descriptor.getTables().get(0).getIndexes()) {
                    index.setTargetTable(tableName);
                }
                Vector<DatabaseMapping> mappings = descriptor.getMappings();
                camelCaseToUnderscore(mappings);
            } else if (descriptor.isAggregateDescriptor()) {
                camelCaseToUnderscore(descriptor.getMappings());
            }
        }
    }

    private void camelCaseToUnderscore(Vector<DatabaseMapping> mappings) {
        for (DatabaseMapping mapping : mappings) {
            DatabaseField field = mapping.getField();
            if (mapping.isDirectToFieldMapping() && !mapping.isPrimaryKeyMapping()) {
                String attributeName = mapping.getAttributeName();
                String underScoredFieldName = camelCaseToUnderscore(attributeName);
                field.setName(underScoredFieldName);
            }
        }
    }

    private String camelCaseToUnderscore(final String name) {
        StringBuffer buf = new StringBuffer(name.replace('.', '_'));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1)) && Character.isUpperCase(buf.charAt(i))
                    && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }
        return buf.toString().toLowerCase(Locale.ENGLISH);
    }

}
