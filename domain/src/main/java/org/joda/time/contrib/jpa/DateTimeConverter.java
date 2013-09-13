package org.joda.time.contrib.jpa;

import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.DateTime;

@Converter(autoApply=true)
public class DateTimeConverter implements AttributeConverter<DateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(DateTime dateTime) {
        if (dateTime == null) {
            return null;
        } else if (dateTime instanceof DateTime) {
            return ((DateTime) dateTime).toDate();
        } else {
            throw new IllegalStateException(
                    "Conversion exception, value is not of java.util.Date type.");
        }

    }

    @Override
    public DateTime convertToEntityAttribute(Date date) {
        if (date == null) {
            return null;
        } else if (date instanceof Date) {
            return new DateTime(date);
        } else {
            throw new IllegalStateException(
                    "Conversion exception, value is not of LocalDate type.");
        }

    }

}
