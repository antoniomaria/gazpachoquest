package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable_;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-20T09:44:39")
@StaticMetamodel(Question.class)
public class Question_ extends AbstractLocalizable_ {

    public static volatile SingularAttribute<Question, QuestionLanguageSettings> languageSettings;
    public static volatile ListAttribute<Question, QuestionOption> questionOptions;
    public static volatile MapAttribute<Question, Language, QuestionTranslation> translations;
    public static volatile SingularAttribute<Question, String> relevance;
    public static volatile SingularAttribute<Question, Question> parent;
    public static volatile SingularAttribute<Question, Language> language;
    public static volatile ListAttribute<Question, Question> subquestions;
    public static volatile SingularAttribute<Question, String> code;
    public static volatile SingularAttribute<Question, Boolean> required;
    public static volatile SingularAttribute<Question, Boolean> otherAllowed;
    public static volatile SingularAttribute<Question, QuestionType> type;
    public static volatile SingularAttribute<Question, Section> section;

}