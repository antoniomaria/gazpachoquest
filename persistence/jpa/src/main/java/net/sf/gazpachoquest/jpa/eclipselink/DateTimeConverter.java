package net.sf.gazpachoquest.jpa.eclipselink;

import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.DateTime;

@Converter(autoApply = true)
public class DateTimeConverter implements AttributeConverter<DateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(DateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.toDate();
    }

    @Override
    public DateTime convertToEntityAttribute(Date date) {
        if (date == null) {
            return null;
        }
        return new DateTime(date);
    }

}