package net.sf.gazpachoquest.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.sf.gazpachoquest.types.RandomizationStrategy;

@Converter(autoApply = true)
public class RandomizationStrategyTypeConverter implements AttributeConverter<RandomizationStrategy, String> {

    @Override
    public String convertToDatabaseColumn(RandomizationStrategy code) {
        return code == null ? RandomizationStrategy.NONE.getCode() : code.getCode();
    }

    @Override
    public RandomizationStrategy convertToEntityAttribute(String code) {
        return RandomizationStrategy.fromCode(code);
    }

}
