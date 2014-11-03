package net.sf.gazpachoquest.dbpopulator.samples;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.SectionDTO;
import net.sf.gazpachoquest.facades.QuestionnaireDefinitionEditorFacade;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;
import net.sf.gazpachoquest.types.RenderingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaPerformanceSurveyCreator {
    @Autowired
    private QuestionnaireDefinitionEditorFacade questionnaireDefinitionEditorFacade;

    public QuestionnaireDefinitionDTO create() {
        QuestionnaireDefinitionDTO questionnaireDefinition = QuestionnaireDefinitionDTO
                .with()
                .language(Language.EN)
                .questionnairLanguageSettingsStart()
                .title("Java Performance Tunning Survey")
                .description("Gathering insight into Java performance world to improve our product offering.")
                .welcomeText(
                        "<p>Each respondent will receive a subscription to use our performance monitoring solution and"
                                + " participates in a draw of 10 Amazon gift certificates worth $100 each. To top it off, "
                                + "we will also share the results of the survey with you.</p>"
                                + "<p>Answering to the 10 questions will take less than 3 minutes of your time.</p>")
                .questionnairLanguageSettingsEnd().sectionInfoVisible(true).welcomeVisible(true)
                .renderingMode(RenderingMode.SECTION_BY_SECTION).build();

        // Section 1
        SectionDTO section = SectionDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("Welcome to the survey").pageLanguageSettingsEnd().randomizationEnabled(false).build();
        questionnaireDefinition.addSection(section);
        questionnaireDefinition = questionnaireDefinitionEditorFacade.save(questionnaireDefinition);

        section = questionnaireDefinition.getLastSectionDTO();

        QuestionDTO question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q1")
                .languageSettingsStart()
                .title("Have you faced any Java performance issues during the past 12 months? ").languageSettingsEnd()
                .required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().code("yes").language(Language.EN).title("Yes").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("no").language(Language.EN).title("No").build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        // Section 2
        section = SectionDTO
                .with()
                .language(Language.EN)
                .randomizationEnabled(false)
                .pageLanguageSettingsStart()
                .title("In case you faced several performance issues during the past year, "
                        + "describe just one while answering the following questions.").pageLanguageSettingsEnd()
                .relevance("${q1=='yes'}").build();
        questionnaireDefinition.addSection(section);
        questionnaireDefinition = questionnaireDefinitionEditorFacade.save(questionnaireDefinition);

        // Section 3
        section = SectionDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("Tell us more about your performance issues").pageLanguageSettingsEnd()
                .relevance("${q1=='yes'}").randomizationEnabled(false).build();
        questionnaireDefinition.addSection(section);
        questionnaireDefinition = questionnaireDefinitionEditorFacade.save(questionnaireDefinition);
        section = questionnaireDefinition.getLastSectionDTO();

        question = QuestionDTO.with().type(QuestionType.M).code("Q2").language(Language.EN).languageSettingsStart()
                .title("What were the symptoms surfacing the performance issue?").languageSettingsEnd()
                .otherAllowed(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN)
                .title("Excessive usage of resources (such as CPU, memory, disk, network, etc)").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN)
                .title("Slow user transactions").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Failing user transactions").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN)
                .title("Complete service outage").build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO.with().type(QuestionType.M).code("Q3").language(Language.EN).languageSettingsStart()
                .title("How did you find out that your Java application is facing the issue?").languageSettingsEnd()
                .otherAllowed(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN)
                .title("Support calls / e-mails").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN)
                .title("Load / stress tests").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Monitoring software").build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q4").languageSettingsStart()
                .title("Was the performance issue affecting end users? ").languageSettingsEnd().build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Yes").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("No").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Don't know")
                .build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO.with().type(QuestionType.M).code("Q5").language(Language.EN).languageSettingsStart()
                .title("Which monitoring software were you using to monitor Java application in production?")
                .languageSettingsEnd().otherAllowed(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("None").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("AppDynamics")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("AppNeta").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("BMC Software APM")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("CA APM").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN).title("Compuware APM")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O7").language(Language.EN).title("DataDog").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O8").language(Language.EN).title("Nagios").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O9").language(Language.EN).title("NewRelic").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O10").language(Language.EN).title("Opsview").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O11").language(Language.EN)
                .title("Oracle Enterprise Manager").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O12").language(Language.EN).title("Pingdom").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O13").language(Language.EN).title("Plumbr").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O14").language(Language.EN).title("Zabbix").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O15").language(Language.EN).title("Don't know")
                .build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO
                .with()
                .type(QuestionType.M)
                .code("Q6")
                .language(Language.EN)
                .languageSettingsStart()
                .title("After understanding that your Java application has a performance issue, what tools / sources did you use to locate the root cause?")
                .languageSettingsEnd().otherAllowed(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN)
                .title("Application Performance Management (APM) tools").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Application Logs")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Database Logs")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Debuggers").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN)
                .title("Garbage Collection Logs").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN)
                .title("JVM built-in tooling (jconsole, jmc, jstat, jmap, etc)").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O7").language(Language.EN)
                .title("Memory Dump Analyzer").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O8").language(Language.EN)
                .title("OS command-line tooling (top, free, sar, etc)").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O9").language(Language.EN).title("Profilers").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O10").language(Language.EN)
                .title("Thread Dump Analyzer").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O11").language(Language.EN)
                .title("I asked for external help").build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q7").languageSettingsStart()
                .title("Were you able to reproduce the performance issue in the test/development environment?")
                .languageSettingsEnd().build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Yes").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("No").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Did not need to")
                .build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO.with().type(QuestionType.M).code("Q8").language(Language.EN).languageSettingsStart()
                .title("What was the root cause for the performance issue?").languageSettingsEnd().otherAllowed(true)
                .build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN)
                .title("Inefficient/missing Caching").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN)
                .title("Insufficient/missing Database Connection Pooling").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Slow Database Queries").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN)
                .title("Too many Database Queries").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("Excessive Disk IO")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN)
                .title("Inefficient Garbage Collection").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O7").language(Language.EN)
                .title("HTTP Session Bloat").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O8").language(Language.EN).title("Memory Leak")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O9").language(Language.EN)
                .title("Monolithic/Not Scalable Architecture").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O10").language(Language.EN)
                .title("Excessive Network IO").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O11").language(Language.EN)
                .title("Poor Transaction Configuration").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O12").language(Language.EN)
                .title("Synchronization Issues (Locks/Deadlocks)").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O13").language(Language.EN)
                .title("Insufficient/missing Thread Pooling").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O14").language(Language.EN)
                .title("I Do Not Have A Clue").build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q9").languageSettingsStart()
                .title("How long did it take you to detect and fix the root cause of the performance issue ? ")
                .languageSettingsEnd().build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Less than an hour")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Less than a day")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Less than a week")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Less than a month")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("More than a month")
                .build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        // 4 Comment/Essay Box
        question = QuestionDTO.with().type(QuestionType.T).language(Language.EN).code("Q10").languageSettingsStart()
                .title("What was the most time consuming part of the process? ").languageSettingsEnd().build();

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        section = SectionDTO
                .with()
                .language(Language.EN)
                .randomizationEnabled(false)
                .pageLanguageSettingsStart()
                .title("As you do not seem to have faced any performance issues with Java applications, the rest of the survey questions were not applicable."
                        + " But we are still happy to offer you the possibility to get access to 3-months license and participate in Amazon gift card raffle.")
                .pageLanguageSettingsEnd().relevance("${q1=='no'}").build();
        questionnaireDefinition.addSection(section);
        questionnaireDefinition = questionnaireDefinitionEditorFacade.save(questionnaireDefinition);

        section = SectionDTO
                .with()
                .language(Language.EN)
                .randomizationEnabled(false)
                .pageLanguageSettingsStart()
                .title("To finish the survey and submit results, please complete all fields below:")
                .description(
                        "This data will be used to contact the winners of the Amazon gift card raffle, hand out free licenses and publish the survey results.")
                .pageLanguageSettingsEnd().build();
        questionnaireDefinition.addSection(section);
        questionnaireDefinition = questionnaireDefinitionEditorFacade.save(questionnaireDefinition);
        section = questionnaireDefinition.getLastSectionDTO();

        question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).code("Q11").languageSettingsStart()
                .title("Name").languageSettingsEnd().required(true).build();
        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).code("Q12").languageSettingsStart()
                .title("Company").languageSettingsEnd().required(true).build();
        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q13").otherAllowed(true)
                .languageSettingsStart().title("Role").languageSettingsEnd().build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Java developer")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN)
                .title("System administrator").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN)
                .title("Application administrator").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN)
                .title("Operations manager").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN)
                .title("Development manager").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O7").language(Language.EN).title("Executive").build());

        section.addQuestion(question);
        section = questionnaireDefinitionEditorFacade.save(section);

        return questionnaireDefinition;
    }
}
