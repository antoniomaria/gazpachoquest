package net.sf.gazpachoquest.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.sf.gazpachoquest.types.Gender;

@Converter(autoApply = true)
public class GenderTypeConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender type) {
        return type == null ? null : type.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(String code) {
        return code == null ? null : Gender.fromCode(code);
    }

}
