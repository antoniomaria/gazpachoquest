package net.sf.gazpachoquest.jpa.converter;

import java.util.HashMap;
import java.util.Map;

import net.sf.gazpachoquest.jpa.converter.support.HstoreSupport;
import net.sf.gazpachoquest.jpa.converter.support.PGHStore;

import org.apache.commons.lang3.Validate;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.platform.database.PostgreSQLPlatform;
import org.eclipse.persistence.sessions.Session;

public class MapToStringConverter implements Converter {

    private static final long serialVersionUID = 7555313947774805921L;

    @SuppressWarnings("unchecked")
    @Override
    public Object convertObjectValueToDataValue(Object objectValue, Session session) {
        Validate.isInstanceOf(Map.class, objectValue);
        Map<String, String> map = (Map<String, String>) objectValue;
        if (map.isEmpty()) {
            return null;
        }
        Object dataValue = null;

        if (isPostgresProvider(session)) {
            dataValue = new PGHStore(map);
        } else {
            dataValue = HstoreSupport.toString(map);
        }
        return dataValue;
    }

    public boolean isPostgresProvider(Session session) {
        return (session.getPlatform() instanceof PostgreSQLPlatform);
    }

    @Override
    public Object convertDataValueToObjectValue(Object dataValue, Session session) {
        Object objectValue = null;
        if (dataValue == null) {
            return new HashMap<>();
        }
        if (dataValue instanceof Map) {
            objectValue = dataValue;
        } else if (dataValue instanceof String) {
            objectValue = HstoreSupport.toMap((String) objectValue);
        } else {
            throw new IllegalStateException(dataValue + " is not a valid map representation");
        }
        return objectValue;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
        if (isPostgresProvider(session)) {
            mapping.getField().setSqlType(java.sql.Types.OTHER);
        } else {
            mapping.getField().setSqlType(java.sql.Types.VARCHAR);
        }

    }

}
