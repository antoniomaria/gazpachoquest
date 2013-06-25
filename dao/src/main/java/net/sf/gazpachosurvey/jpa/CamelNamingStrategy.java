package net.sf.gazpachosurvey.jpa;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.internal.helper.Helper;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectToFieldMapping;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.tools.schemaframework.IndexDefinition;

public class CamelNamingStrategy implements SessionCustomizer {
    @Override
    public void customize(Session session) throws SQLException {
        for (ClassDescriptor descriptor : session.getDescriptors().values()) {
            //Only change the table name for non-embedable entities with no @Table already
            if (!descriptor.getTables().isEmpty() && descriptor.getAlias().equalsIgnoreCase(descriptor.getTableName())) {
                String nonQualifiedClassName = unqualify(descriptor.getJavaClassName());
                String tableName = addUnderscores(nonQualifiedClassName);
                descriptor.setTableName(tableName);
                for (IndexDefinition index : descriptor.getTables().get(0).getIndexes()) {
                    index.setTargetTable(tableName);
                }
            }
        }
   }
    
    private void updateMappings(ClassDescriptor desc, String tableName) {
        for (DatabaseMapping mapping : desc.getMappings()) {
            if (mapping.isDirectToFieldMapping()) {
                DirectToFieldMapping directMapping = (DirectToFieldMapping) mapping;
                directMapping.getField().setTableName(tableName);
            }
        }
    }

    private String customizeTableName(String className) {
        return "T_" + className;
    }
    

    public static String unqualify(String qualifiedName) {
            int loc = qualifiedName.lastIndexOf(".");
            return ( loc < 0 ) ? qualifiedName : qualifiedName.substring( qualifiedName.lastIndexOf(".") + 1 );
    }
    
    protected static String addUnderscores(String name) {
        
        StringBuffer buf = new StringBuffer( name.replace('.', '_') );
        for (int i=1; i<buf.length()-1; i++) {
                if (
                        Character.isLowerCase( buf.charAt(i-1) ) &&
                        Character.isUpperCase( buf.charAt(i) ) &&
                        Character.isLowerCase( buf.charAt(i+1) )
                ) {
                        buf.insert(i++, '_');
                }
        }
        return buf.toString().toLowerCase();
}

}
