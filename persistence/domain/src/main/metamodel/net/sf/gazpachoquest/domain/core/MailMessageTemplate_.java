package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable_;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(MailMessageTemplate.class)
public class MailMessageTemplate_ extends AbstractLocalizable_ {

    public static volatile MapAttribute<MailMessageTemplate, Language, MailMessageTemplateTranslation> translations;
    public static volatile SingularAttribute<MailMessageTemplate, String> replyTo;
    public static volatile SingularAttribute<MailMessageTemplate, MailMessageTemplateLanguageSettings> languageSettings;
    public static volatile SingularAttribute<MailMessageTemplate, Language> language;
    public static volatile SingularAttribute<MailMessageTemplate, String> fromAddress;
    public static volatile SingularAttribute<MailMessageTemplate, QuestionnaireDefinition> questionnaireDefinition;
    public static volatile SingularAttribute<MailMessageTemplate, MailMessageTemplateType> type;

}