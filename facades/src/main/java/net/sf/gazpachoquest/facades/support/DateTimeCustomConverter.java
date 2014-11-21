package net.sf.gazpachoquest.facades.support;
import java.time.*;

import org.dozer.DozerConverter;

public class DateTimeCustomConverter extends DozerConverter<LocalDateTime, LocalDateTime>{

    public DateTimeCustomConverter() {
        super(LocalDateTime.class, LocalDateTime.class);
    }

    @Override
    public LocalDateTime convertTo(LocalDateTime source, LocalDateTime destination) {
        if (source == null) {
            return null;
        }
        return LocalDateTime.from(source);
    }

    @Override
    public LocalDateTime convertFrom(LocalDateTime source, LocalDateTime destination) {
        if (source == null) {
            return null;
        }
        return LocalDateTime.from(source);
    }

}
