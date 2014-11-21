package net.sf.gazpachoquest.domain.i18;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractAuditable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(MailMessageTemplateTranslation.class)
public class MailMessageTemplateTranslation_ extends AbstractAuditable_ {

    public static volatile SingularAttribute<MailMessageTemplateTranslation, MailMessageTemplate> mailMessageTemplate;
    public static volatile SingularAttribute<MailMessageTemplateTranslation, MailMessageTemplateLanguageSettings> languageSettings;
    public static volatile SingularAttribute<MailMessageTemplateTranslation, Language> language;

}