package net.sf.gazpachosurvey.jpa;

import java.sql.SQLException;
import java.util.Vector;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.tools.schemaframework.IndexDefinition;

public class CamelNamingStrategy implements SessionCustomizer {

    @Override
    public void customize(Session session) throws SQLException {
        for (ClassDescriptor descriptor : session.getDescriptors().values()) {
            if (!descriptor.getTables().isEmpty()) {

                // Take table name from @Table if exists
                String tableName = null;
                if (descriptor.getAlias().equalsIgnoreCase(
                        descriptor.getTableName())) {
                    tableName = unqualify(descriptor.getJavaClassName());
                } else {
                    tableName = descriptor.getTableName();
                }

                tableName = addUnderscores(tableName);
                descriptor.setTableName(tableName);

                for (IndexDefinition index : descriptor.getTables().get(0)
                        .getIndexes()) {
                    index.setTargetTable(tableName);
                }
                Vector<DatabaseMapping> mappings = descriptor.getMappings();
                for (DatabaseMapping mapping : mappings) {
                    DatabaseField field = mapping.getField();
                    if (mapping.isDirectToFieldMapping()
                            && !mapping.isPrimaryKeyMapping()) {
                        String attributeName = mapping.getAttributeName();

                        String underScoredFieldName = addUnderscores(attributeName);
                        field.setName(underScoredFieldName);
                    }
                }
            }
        }
    }

    public static String unqualify(String qualifiedName) {
        int loc = qualifiedName.lastIndexOf(".");
        return (loc < 0) ? qualifiedName : qualifiedName
                .substring(qualifiedName.lastIndexOf(".") + 1);
    }

    protected static String addUnderscores(String name) {
        StringBuffer buf = new StringBuffer(name.replace('.', '_'));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1))
                    && Character.isUpperCase(buf.charAt(i))
                    && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }
        return buf.toString().toLowerCase();
    }

}
