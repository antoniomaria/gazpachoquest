package net.sf.gazpachoquest.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.sf.gazpachoquest.types.EntityStatus;

@Converter(autoApply = true)
public class EntityStatusConverter implements AttributeConverter<EntityStatus, String> {

    @Override
    public String convertToDatabaseColumn(EntityStatus type) {
        return type == null ? null : type.getCode();
    }

    @Override
    public EntityStatus convertToEntityAttribute(String code) {
        return code == null ? null : EntityStatus.fromCode(code);
    }

}
