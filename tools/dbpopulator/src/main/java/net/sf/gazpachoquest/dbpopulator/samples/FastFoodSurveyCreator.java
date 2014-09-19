package net.sf.gazpachoquest.dbpopulator.samples;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.SectionDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.SubquestionDTO;
import net.sf.gazpachoquest.facades.QuestionnaireDefinitionEditorFacade;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FastFoodSurveyCreator {

    @Autowired
    private QuestionnaireDefinitionEditorFacade questionnaireDefinitionEditorFacade;

    public QuestionnaireDefinitionDTO create() {
        QuestionnaireDefinitionDTO survey = QuestionnaireDefinitionDTO
                .with()
                .language(Language.EN)
                .questionnairLanguageSettingsStart()
                .title("Food Quality QuestionnaireDefinition")
                .description(
                        "We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.")
                .welcomeText(
                        "Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:")
                .questionnairLanguageSettingsEnd().build();
        survey = questionnaireDefinitionEditorFacade.save(survey);

        SectionDTO section = SectionDTO.with().language(Language.EN).randomizationEnabled(false)
                .pageLanguageSettingsStart().title("Fast Food QuestionnaireDefinition - Section")
                .pageLanguageSettingsEnd().build();

        survey.addSection(section);
        survey = questionnaireDefinitionEditorFacade.save(survey);
        section = survey.getLastSectionDTO();

        // Question 1: Rating Scale (1-5)
        QuestionDTO question = QuestionDTO.with().type(QuestionType.F).code("Q1").language(Language.EN)
                .languageSettingsStart().title("<b>Food Quality</b>").languageSettingsEnd().required(true).build();

        question.addSubquestion(SubquestionDTO.with().code("Q1.1").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The food is served hot and fresh").languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q1.2").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The menu has a good variety of items").languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q1.3").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The quality of food is excellent").languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q1.4").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The food is tasty and flavorful").languageSettingsEnd().build());

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

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        // Question 2: Rating Scale (Agree-Disagree)
        question = QuestionDTO.with().type(QuestionType.F).code("Q2").language(Language.EN).languageSettingsStart()
                .title("<b>Resturant</b>").languageSettingsEnd().required(true).build();

        question.addSubquestion(SubquestionDTO.with().code("Q2.1").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("My food order was correct and complete").languageSettingsEnd().build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.2").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("Employees are patient when taking my order").languageSettingsEnd()
                .build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.3").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("I was served promptly").languageSettingsEnd().build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.4").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("Availability of sauces, utensils, napkins, etc. was good")
                .languageSettingsEnd().build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.5").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The menu board was easy to read").languageSettingsEnd().build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.6").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The drive-thru sound system was cleara").languageSettingsEnd().build());

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

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        // Question 3: Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).code("Q3").language(Language.EN).languageSettingsStart()
                .title("Indicate total household income").languageSettingsEnd().required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O1").title("under 25,000€")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O2").title("25,000 - 29,999€")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O3").title("30,000 - 34,999€")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O4").title("35,000 - 39,999€")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O5").title("Over 85,000€")
                .build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        return survey;
    }

}
