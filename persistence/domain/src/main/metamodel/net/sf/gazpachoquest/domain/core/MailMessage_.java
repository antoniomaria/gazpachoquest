package net.sf.gazpachoquest.domain.core;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(MailMessage.class)
public class MailMessage_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<MailMessage, LocalDateTime> sentDate;
    public static volatile SingularAttribute<MailMessage, String> subject;
    public static volatile SingularAttribute<MailMessage, String> replyTo;
    public static volatile SingularAttribute<MailMessage, String> fromAddress;
    public static volatile SingularAttribute<MailMessage, String> body;
    public static volatile SingularAttribute<MailMessage, String> toAddress;
    public static volatile SingularAttribute<MailMessage, Integer> deliveryAttempts;

}