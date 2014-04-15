/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.jpa.converter;

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
