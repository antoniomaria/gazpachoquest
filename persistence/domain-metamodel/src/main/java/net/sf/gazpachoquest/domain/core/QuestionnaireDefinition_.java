package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnaireDefinitionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractSecurizableLocalizable_;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-18T16:48:29")
@StaticMetamodel(QuestionnaireDefinition.class)
public class QuestionnaireDefinition_ extends AbstractSecurizableLocalizable_ {

    public static volatile SingularAttribute<QuestionnaireDefinition, Boolean> questionNumberVisible;
    public static volatile SingularAttribute<QuestionnaireDefinition, QuestionnaireDefinitionLanguageSettings> languageSettings;
    public static volatile SingularAttribute<QuestionnaireDefinition, Boolean> sectionInfoVisible;
    public static volatile SingularAttribute<QuestionnaireDefinition, EntityStatus> status;
    public static volatile SingularAttribute<QuestionnaireDefinition, RandomizationStrategy> randomizationStrategy;
    public static volatile SetAttribute<QuestionnaireDefinition, Research> researches;
    public static volatile SetAttribute<QuestionnaireDefinition, Questionnaire> questionnaires;
    public static volatile SingularAttribute<QuestionnaireDefinition, Boolean> welcomeVisible;
    public static volatile SingularAttribute<QuestionnaireDefinition, Boolean> progressVisible;
    public static volatile ListAttribute<QuestionnaireDefinition, Section> sections;
    public static volatile SingularAttribute<QuestionnaireDefinition, RenderingMode> renderingMode;
    public static volatile MapAttribute<QuestionnaireDefinition, Language, QuestionnaireDefinitionTranslation> translations;
    public static volatile SingularAttribute<QuestionnaireDefinition, Integer> questionsPerPage;
    public static volatile MapAttribute<QuestionnaireDefinition, MailMessageTemplateType, MailMessageTemplate> mailTemplates;
    public static volatile SingularAttribute<QuestionnaireDefinition, Language> language;

}