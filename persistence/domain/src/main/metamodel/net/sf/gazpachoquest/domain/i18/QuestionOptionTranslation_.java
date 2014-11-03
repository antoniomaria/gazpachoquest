package net.sf.gazpachoquest.domain.i18;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-28T07:30:16")
@StaticMetamodel(QuestionOptionTranslation.class)
public class QuestionOptionTranslation_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<QuestionOptionTranslation, QuestionOptionLanguageSettings> languageSettings;
    public static volatile SingularAttribute<QuestionOptionTranslation, Language> language;
    public static volatile SingularAttribute<QuestionOptionTranslation, QuestionOption> questionOption;

}