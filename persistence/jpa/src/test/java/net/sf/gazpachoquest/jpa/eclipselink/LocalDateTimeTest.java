package net.sf.gazpachoquest.jpa.eclipselink;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.chrono.ISOChronology;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class LocalDateTimeTest {

    @Test
    public void moreTests(){
        DateTimeZone.setDefault(DateTimeZone.UTC);
        
        LocalDateTime date = LocalDateTime.now();
        DateTimeZone tz = DateTimeZone.getDefault();
        
        
        System.out.println("1: " + date);
        System.out.println(tz);
        System.out.println("-----");
        System.out.println("2: " + date.toDateTime(tz));
        System.out.println("3: " +date.toDateTime(tz).toInstant());
        System.out.println("4: " +date.toDateTime(tz).toDateTime(DateTimeZone.UTC));
        System.out.println("-----");
        System.out.println("5: " +date.toDateTime(tz).getMillis());
        System.out.println("6: " +date.toDateTime(tz).toInstant().getMillis());
        System.out.println("7: " +date.toDateTime(tz).toDateTime(DateTimeZone.UTC).getMillis());
        System.out.println("-----");
        System.out.println(new Timestamp(date.toDateTime(tz).getMillis()));
        System.out.println(new Timestamp(date.toDateTime(tz).toInstant().getMillis()));
        System.out.println(new Timestamp(date.toDateTime(tz).toDateTime(DateTimeZone.UTC).getMillis()));
    }
    
    @Test
    public void f(){
        // TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        ISOChronology chronology = ISOChronology.getInstanceUTC();
        
        LocalDateTime dateTime = new LocalDateTime();
        
        
        System.out.println("Local " + dateTime);
        System.out.println("utc1 " + dateTime.toDate(TimeZone.getTimeZone("UTC")));
        System.out.println("utc2 " + dateTime.toDateTime(DateTimeZone.UTC));
        
        DateTimeZone tz = DateTimeZone.getDefault();
        
        Date localDate = new Date();
        System.out.println("Local Date : " + localDate);
        
        Date utcDate = new Date(tz.convertLocalToUTC(localDate.getTime(), false));
        System.out.println("UTC Date : " + utcDate);
        
        long utcDate2 = tz.convertLocalToUTC(dateTime.toDateTime().getMillis(), false);
        LocalDateTime UTCDateTime = new LocalDateTime(utcDate2);
        System.out.println("UTC Date1 : " + new LocalTime(UTCDateTime));
        Set<String> availables = DateTimeZone.getAvailableIDs();
        System.out.println(availables);
      //  UTCDateTime.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ID)))
        System.out.println("Local Date1 : " + new LocalTime(tz.convertUTCToLocal(UTCDateTime.toDateTime().getMillis())));
        
    }
}
