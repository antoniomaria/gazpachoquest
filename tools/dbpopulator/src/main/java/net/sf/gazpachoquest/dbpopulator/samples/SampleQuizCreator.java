package net.sf.gazpachoquest.dbpopulator.samples;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionGroupDTO;
import net.sf.gazpachoquest.dto.QuestionGroupLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.QuestionOptionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.facades.QuestionnairDefinitionEditorFacade;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;
import net.sf.gazpachoquest.types.RandomizationStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleQuizCreator {

    @Autowired
    private QuestionnairDefinitionEditorFacade questionnairDefinitionEditorFacade;

    public QuestionnairDefinitionDTO create() {
        QuestionnairDefinitionDTO questionnair = QuestionnairDefinitionDTO.with().language(Language.EN)
                .welcomeVisible(true).progressVisible(true).randomizationStrategy(RandomizationStrategy.NONE)
                .questionnairLanguageSettingsStart().title("European general knowledge quiz")
                .description("How much do you know about Europe? Answer to this questions and let's find out!")
                .welcomeText("Thank you for taking the time to participate in this questionnair.")
                .questionnairLanguageSettingsEnd().build();
        questionnair = questionnairDefinitionEditorFacade.save(questionnair);

        TranslationDTO<QuestionnairDefinitionDTO, QuestionnairDefinitionLanguageSettingsDTO> questionnairTranslation = new TranslationDTO<>();
        questionnairTranslation.setLanguage(Language.ES);
        questionnairTranslation.setLanguageSettings(QuestionnairDefinitionLanguageSettingsDTO.with()
                .title("Test de conocimiento general sobre Europa")
                .description("¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!")
                .welcomeText("Gracias por participar en este cuestionario").build());
        questionnairTranslation.setTranslatedEntity(questionnair);

        questionnairDefinitionEditorFacade.saveQuestionnairTranslation(questionnairTranslation);

        // Page 1
        QuestionGroupDTO questionGroup1 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("European Capitals").pageLanguageSettingsEnd().build();

        questionnair.addQuestionGroup(questionGroup1);
        questionnair = questionnairDefinitionEditorFacade.save(questionnair);

        questionGroup1 = questionnair.getLastQuestionGroupDTO();

        TranslationDTO<QuestionGroupDTO, QuestionGroupLanguageSettingsDTO> questionGroupTranslation = new TranslationDTO<>();
        questionGroupTranslation.setLanguage(Language.ES);
        questionGroupTranslation.setLanguageSettings(QuestionGroupLanguageSettingsDTO.with()
                .title("Capitales Europeas").build());
        questionGroupTranslation.setTranslatedEntity(questionGroup1);
        questionnairDefinitionEditorFacade.saveQuestionGroupTranslation(questionGroupTranslation);

        // Page 2
        QuestionGroupDTO questionGroup2 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("European Union").pageLanguageSettingsEnd().build();

        questionnair.addQuestionGroup(questionGroup2);
        questionnair = questionnairDefinitionEditorFacade.save(questionnair);
        questionGroup2 = questionnair.getLastQuestionGroupDTO();

        questionGroupTranslation = new TranslationDTO<>();
        questionGroupTranslation.setLanguage(Language.ES);
        questionGroupTranslation.setLanguageSettings(QuestionGroupLanguageSettingsDTO.with().title("Unión Europea")
                .build());
        questionGroupTranslation.setTranslatedEntity(questionGroup2);
        questionnairDefinitionEditorFacade.saveQuestionGroupTranslation(questionGroupTranslation);

        // Page 3
        QuestionGroupDTO questionGroup3 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("European History").pageLanguageSettingsEnd().build();

        questionnair.addQuestionGroup(questionGroup3);
        questionnair = questionnairDefinitionEditorFacade.save(questionnair);
        questionGroup3 = questionnair.getLastQuestionGroupDTO();

        questionGroupTranslation = new TranslationDTO<>();
        questionGroupTranslation.setLanguage(Language.ES);
        questionGroupTranslation.setLanguageSettings(QuestionGroupLanguageSettingsDTO.with().title("Sociedad").build());
        questionGroupTranslation.setTranslatedEntity(questionGroup3);
        questionnairDefinitionEditorFacade.saveQuestionGroupTranslation(questionGroupTranslation);

        // 1 Single Textbox
        QuestionDTO question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).code("Q1")
                .languageSettingsStart().title("What is the capital of Malta?").languageSettingsEnd().required(true)
                .build();
        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);
        question = questionGroup1.getLastQuestionDTO();

        TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Cuál es la capital de Malta?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 2 List (Radio) Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q2").languageSettingsStart()
                .title("Which the country has as capital Copenhague?").languageSettingsEnd().required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Norway").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Sweden").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Denmark").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Iceland").build());

        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);
        question = questionGroup1.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Qué pais tiene como capital Copenague?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation
                .setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Noruega").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Suecia").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Dinamarca")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Islandia")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        // 3 Numeric
        question = QuestionDTO.with().type(QuestionType.N).language(Language.EN).code("Q3").languageSettingsStart()
                .title("How many European capitals were founded by Romans?").languageSettingsEnd().required(true)
                .build();

        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);

        question = questionGroup1.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Cuantas capitales europeas fueron fundadas por los romanos?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 4. List checkbox - Multiple_Answers
        question = QuestionDTO.with().type(QuestionType.M).code("Q4").language(Language.EN).languageSettingsStart()
                .title("Which ones of these European capital are near by a river? Choose all that apply.")
                .languageSettingsEnd().required(false).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Vatican City")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Roma").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Helsinki").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Viena").build());

        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);

        question = questionGroup1.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Cuantas de estas capitales Europeas estan al pie de un río?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with()
                .title("Ciudad del Vaticano").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Roma").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Helsinki")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Viena").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        // 5 Single Textbox
        question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).code("Q5").languageSettingsStart()
                .title("What does EU stand for??").languageSettingsEnd().required(true).build();
        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);
        question = questionGroup2.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with().title("¿Que significa UE?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 6 List (Radio) Multiple Choice (Only One QuestionOption)
        question = QuestionDTO
                .with()
                .type(QuestionType.L)
                .language(Language.EN)
                .code("Q6")
                .languageSettingsStart()
                .title("Where was the treaty signed that created the European economic community - forerunner of the EU?")
                .languageSettingsEnd().required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Westphalia")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Rome").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Brussels").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Versailles")
                .build());

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);
        question = questionGroup1.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?")
                .build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Westphalia")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Roma").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Bruselas")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Islandia")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        // 7. List checkbox - Multiple_Answers
        question = QuestionDTO.with().type(QuestionType.M).code("Q7").language(Language.EN).languageSettingsStart()
                .title("Which ones of these European countries belongs to Euro Zone? Choose all that apply.")
                .languageSettingsEnd().required(false).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Norway").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Poland").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Macedonia").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Chipre").build());

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);

        question = questionGroup2.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Cuál de estos países europeos pertenecen a la zona euro?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation
                .setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Noruega").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation
                .setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Polonia").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Macedonia")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Chipre").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        // 8 Numeric
        question = QuestionDTO.with().type(QuestionType.N).language(Language.EN).code("Q8").languageSettingsStart()
                .title("How many finnish marc do you need to get an euro?").languageSettingsEnd().required(true)
                .build();

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);

        question = questionGroup2.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Cuantos marcos finlandeses necesitas para tener un euro?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 9 List (Radio) Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q9").languageSettingsStart()
                .title("Where was Christopher columbus was born?").languageSettingsEnd().required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Barcelona").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Lisboa").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Genoa").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Roma").build());

        questionGroup3.addQuestion(question);
        questionGroup3 = questionnairDefinitionEditorFacade.save(questionGroup3);
        question = questionGroup3.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Dónde nació Cristobal Colón?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Barcelona")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Lisboa").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Genova").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Roma").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        // 10 List (Radio) Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q10").languageSettingsStart()
                .title("What was the large Eurpean Empire in century 16th ?").languageSettingsEnd().required(true)
                .build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Portuguese Empire")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("British Empire")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Spanish Empire")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Dutch Empire")
                .build());

        questionGroup3.addQuestion(question);
        questionGroup3 = questionnairDefinitionEditorFacade.save(questionGroup3);
        question = questionGroup3.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Cuál fue el imperio más grande en el siglo XVI?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with()
                .title("Imperio Portugues").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with()
                .title("Imperio Británico").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Imperio Español")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with()
                .title("Imperio Holandés").build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        // 11 Single Textbox
        question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).code("Q11").languageSettingsStart()
                .title("Which nationality has the first european that to get Congo?").languageSettingsEnd()
                .required(true).build();
        questionGroup3.addQuestion(question);
        questionGroup3 = questionnairDefinitionEditorFacade.save(questionGroup3);
        question = questionGroup3.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 12 List (Radio) Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q12").languageSettingsStart()
                .title("Which of the men caused more casualities in Europe?").languageSettingsEnd().required(true)
                .build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Adolph Hitler")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Napoleon").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Philip 2th King of Spain").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Julius Caesar")
                .build());

        questionGroup3.addQuestion(question);
        questionGroup3 = questionnairDefinitionEditorFacade.save(questionGroup3);
        question = questionGroup3.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Cual de estos hombres causó más bajas en Europa?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnairDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Adolfo Hitler")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Napoleón")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Felipe II")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Julio Cesar")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnairDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        return questionnair;
    }

}
