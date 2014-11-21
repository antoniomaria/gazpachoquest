package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionOptionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(QuestionOption.class)
public class QuestionOption_ extends AbstractLocalizable_ {

    public static volatile SingularAttribute<QuestionOption, String> code;
    public static volatile SingularAttribute<QuestionOption, Question> question;
    public static volatile MapAttribute<QuestionOption, Language, QuestionOptionTranslation> translations;
    public static volatile SingularAttribute<QuestionOption, QuestionOptionLanguageSettings> languageSettings;
    public static volatile SingularAttribute<QuestionOption, Language> language;

}