package net.sf.gazpachoquest.dbpopulator.samples;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionGroupDTO;
import net.sf.gazpachoquest.dto.QuestionGroupLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.QuestionOptionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.SubquestionDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.facades.QuestionnairDefinitionEditorFacade;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;
import net.sf.gazpachoquest.types.RandomizationStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoSurveyCreator {

    @Autowired
    private QuestionnairDefinitionEditorFacade questionnairDefinitionEditorFacade;

    public QuestionnairDefinitionDTO create() {
        QuestionnairDefinitionDTO survey = QuestionnairDefinitionDTO
                .with()
                .language(Language.EN)
                .welcomeVisible(true)
                .progressVisible(true)
                .randomizationStrategy(RandomizationStrategy.NONE)
                .questionGroupInfoVisible(true)
                .questionnairLanguageSettingsStart()
                .title("Sample QuestionnairDefinition")
                .description(
                        "<p>This is a <strong><em>sample questionnairDefinition</em></strong> designed for testing GazpachoSurvey.</p>")
                .welcomeText("Thank you for taking the time to participate in this questionnairDefinition.")
                .questionnairLanguageSettingsEnd().build();
        survey = questionnairDefinitionEditorFacade.save(survey);

        TranslationDTO<QuestionnairDefinitionDTO, QuestionnairDefinitionLanguageSettingsDTO> surveyTranslation = new TranslationDTO<>();
        surveyTranslation.setLanguage(Language.ES);
        surveyTranslation.setLanguageSettings(QuestionnairDefinitionLanguageSettingsDTO.with()
                .title("Ejemplo de encuesta")
                .description("<p>Esto es una encuesta de ejemplo diseñada para GazpachoSurvey</p>")
                .welcomeText("Gracias por participar en esta encuesta").build());
        surveyTranslation.setTranslatedEntity(survey);

        questionnairDefinitionEditorFacade.saveQuestionnairTranslation(surveyTranslation);

        // Page 1
        QuestionGroupDTO questionGroup1 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("QuestionGroup 1").pageLanguageSettingsEnd().randomizationEnabled(false).build();

        survey.addQuestionGroup(questionGroup1);
        survey = questionnairDefinitionEditorFacade.save(survey);

        questionGroup1 = survey.getLastQuestionGroupDTO();

        TranslationDTO<QuestionGroupDTO, QuestionGroupLanguageSettingsDTO> questionGroupTranslation = new TranslationDTO<>();
        questionGroupTranslation.setLanguage(Language.ES);
        questionGroupTranslation.setLanguageSettings(QuestionGroupLanguageSettingsDTO.with().title("Grupo 1").build());
        questionGroupTranslation.setTranslatedEntity(questionGroup1);
        questionnairDefinitionEditorFacade.saveQuestionGroupTranslation(questionGroupTranslation);

        // Page 2
        QuestionGroupDTO questionGroup2 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("QuestionGroup 2").pageLanguageSettingsEnd().randomizationEnabled(false).build();

        survey.addQuestionGroup(questionGroup2);
        survey = questionnairDefinitionEditorFacade.save(survey);
        questionGroup2 = survey.getLastQuestionGroupDTO();

        questionGroupTranslation = new TranslationDTO<>();
        questionGroupTranslation.setLanguage(Language.ES);
        questionGroupTranslation.setLanguageSettings(QuestionGroupLanguageSettingsDTO.with().title("Grupo 2").build());
        questionGroupTranslation.setTranslatedEntity(questionGroup2);
        questionnairDefinitionEditorFacade.saveQuestionGroupTranslation(questionGroupTranslation);

        // Page 3
        QuestionGroupDTO questionGroup3 = QuestionGroupDTO.with().language(Language.EN).randomizationEnabled(false)
                .pageLanguageSettingsStart().title("QuestionGroup 3").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup3);
        survey = questionnairDefinitionEditorFacade.save(survey);
        questionGroup3 = survey.getLastQuestionGroupDTO();

        questionGroupTranslation = new TranslationDTO<>();
        questionGroupTranslation.setLanguage(Language.ES);
        questionGroupTranslation.setLanguageSettings(QuestionGroupLanguageSettingsDTO.with().title("Grupo 3").build());
        questionGroupTranslation.setTranslatedEntity(questionGroup3);
        questionnairDefinitionEditorFacade.saveQuestionGroupTranslation(questionGroupTranslation);

        // 1 Single Textbox
        QuestionDTO question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).code("Q1")
                .languageSettingsStart().title("What is your name?").languageSettingsEnd().required(true).build();
        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);
        question = questionGroup1.getLastQuestionDTO();

        TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with().title("¿Cómo te llamas?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 2 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q2").languageSettingsStart()
                .title("What is your age group?").languageSettingsEnd().required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("0-18 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("19-26 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("27-40 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("40 and over")
                .build());

        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);
        question = questionGroup1.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with().title("¿Cuál es su grupo de edad?")
                .build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("0-18 años")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("19-26 años")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("27-40 años")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Más de 40 años")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        // 3 Numeric
        question = QuestionDTO.with().type(QuestionType.N).language(Language.EN).code("Q3").languageSettingsStart()
                .title("And for our records, specifically how old are you?").languageSettingsEnd().required(true)
                .build();

        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);

        question = questionGroup1.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Qué edad tienes exactamente?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 4 Comment/Essay Box
        question = QuestionDTO.with().type(QuestionType.T).language(Language.EN).code("Q4").languageSettingsStart()
                .title("Please tell us a little about yourself. What was your first job, and did you enjoy it?")
                .languageSettingsEnd().required(true).build();

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);

        question = questionGroup2.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("Cuentanos un poco sobre ti. ¿Cuál fue tu primer trabajo?, ¿era divertido?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 5 List (Radio) Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q5").languageSettingsStart()
                .title("Given your extraordinary age, how do you find using this questionnairDefinition tool?")
                .languageSettingsEnd().required(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN)
                .title("Very difficult to read, my eyesight is dim").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN)
                .title("Easy, my carer is doing it all for me").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("How <b><i>dare</i></b> you insult me like that! I'm YOUNG").build());

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);

        question = questionGroup2.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("Dada tu extraodinaria edad, ¿Qué opinas de esta herramienta?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 6 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).code("Q6").language(Language.EN).languageSettingsStart()
                .title("Which of these ads makes you want to find out more?").languageSettingsEnd().required(true)
                .build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Ad one").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Ad two").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Ad three").build());

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);

        // 7 Rating Scale (Agree-Disagree) Array Flexible
        question = QuestionDTO
                .with()
                .type(QuestionType.F)
                .code("Q7")
                .language(Language.EN)
                .languageSettingsStart()
                .title("Please have a good look at this ad, and then complete the questions below.<br /><img src='http://www.aptigence.com.au/images/lawyer1.jpg' border='1'>")
                .languageSettingsEnd().required(true).build();

        question.addSubquestion(SubquestionDTO.with().code("Q7.1").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad suggests the lawyer is on my side, not his own")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.2").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart()
                .title("This ad suggests that the lawyer is interested in a life of frugal community service")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.3").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad would be enough to get me to hire this lawyer")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.4").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad gives me confidence in the lawyers experience")
                .languageSettingsEnd().build());

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Agree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Neither agree nor disagree").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Disagree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN).title("Disagree strongly")
                .build());

        questionGroup3.addQuestion(question);
        questionGroup3 = questionnairDefinitionEditorFacade.save(questionGroup3);

        // 8. List checkbox - Multiple_Answers
        question = QuestionDTO.with().type(QuestionType.M).code("Q8").language(Language.EN).languageSettingsStart()
                .title("What flavors of ice cream do you like?. Choose all that apply.").languageSettingsEnd()
                .required(false).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Vanilla").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Chocolate").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Strawberry")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Pistachio").build());

        questionGroup3.addQuestion(question);
        questionGroup3 = questionnairDefinitionEditorFacade.save(questionGroup3);

        return survey;
    }
}
