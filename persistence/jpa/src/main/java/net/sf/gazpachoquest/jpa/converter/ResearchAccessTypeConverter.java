package net.sf.gazpachoquest.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.sf.gazpachoquest.types.ResearchAccessType;

@Converter(autoApply = true)
public class ResearchAccessTypeConverter implements AttributeConverter<ResearchAccessType, String> {

    @Override
    public String convertToDatabaseColumn(ResearchAccessType type) {
        return type == null ? null : type.getCode();
    }

    @Override
    public ResearchAccessType convertToEntityAttribute(String code) {
        return code == null ? null : ResearchAccessType.fromCode(code);
    }

}
