package net.sf.gazpachoquest.domain.i18;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(QuestionnaireDefinitionTranslation.class)
public class QuestionnaireDefinitionTranslation_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<QuestionnaireDefinitionTranslation, QuestionnaireDefinitionLanguageSettings> languageSettings;
    public static volatile SingularAttribute<QuestionnaireDefinitionTranslation, Language> language;
    public static volatile SingularAttribute<QuestionnaireDefinitionTranslation, QuestionnaireDefinition> questionnaireDefinition;

}