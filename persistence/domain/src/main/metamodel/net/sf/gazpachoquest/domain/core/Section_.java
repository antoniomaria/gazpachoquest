package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.SectionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.SectionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(Section.class)
public class Section_ extends AbstractLocalizable_ {

    public static volatile SingularAttribute<Section, Boolean> randomizationEnabled;
    public static volatile MapAttribute<Section, Language, SectionTranslation> translations;
    public static volatile ListAttribute<Section, Question> questions;
    public static volatile SingularAttribute<Section, SectionLanguageSettings> languageSettings;
    public static volatile SingularAttribute<Section, Language> language;
    public static volatile SingularAttribute<Section, QuestionnaireDefinition> questionnaireDefinition;
    public static volatile SingularAttribute<Section, String> relevance;

}