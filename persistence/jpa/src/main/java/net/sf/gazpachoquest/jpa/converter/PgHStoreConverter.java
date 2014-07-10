package net.sf.gazpachoquest.jpa.converter;

import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;
//import org.eclipse.persistence.mappings.converters.ObjectTypeConverter;

public class PgHStoreConverter implements Converter {

    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isMutable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
        mapping.getField().setSqlType(java.sql.Types.OTHER);
    }

}
