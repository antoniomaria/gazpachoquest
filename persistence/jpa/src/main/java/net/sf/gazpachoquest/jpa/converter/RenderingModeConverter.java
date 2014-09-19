package net.sf.gazpachoquest.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.sf.gazpachoquest.types.RenderingMode;

@Converter(autoApply = true)
public class RenderingModeConverter implements AttributeConverter<RenderingMode, String> {

    @Override
    public String convertToDatabaseColumn(RenderingMode type) {
        return type == null ? null : type.getCode();
    }

    @Override
    public RenderingMode convertToEntityAttribute(String code) {
        return code == null ? null : RenderingMode.fromCode(code);
    }

}
