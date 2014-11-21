package net.sf.gazpachoquest.domain.i18;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(QuestionTranslation.class)
public class QuestionTranslation_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<QuestionTranslation, Question> question;
    public static volatile SingularAttribute<QuestionTranslation, QuestionLanguageSettings> languageSettings;
    public static volatile SingularAttribute<QuestionTranslation, Language> language;

}