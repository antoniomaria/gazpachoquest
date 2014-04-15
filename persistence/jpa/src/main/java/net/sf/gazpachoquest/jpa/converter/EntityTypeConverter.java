package net.sf.gazpachoquest.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import net.sf.gazpachoquest.types.*;

@Converter(autoApply = true)
public class EntityTypeConverter implements
		AttributeConverter<EntityType, String> {

	@Override
	public String convertToDatabaseColumn(EntityType type) {
		return type.getCode();
	}

	@Override
	public EntityType convertToEntityAttribute(String code) {
		return EntityType.fromCode(code);
	}

}
