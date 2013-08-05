package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.SurveyDTO;

import org.junit.Test;

public class BuilderPatternTest {

    @Test
    public final void test() {
        SurveyDTO survey = SurveyDTO.with().surveyLanguageSettingsStart().description("description").title("title")
                .surveyLanguageSettingsEnd().build();

        // surveyCreatorService.save(survey);

        System.out.println("fin");
    }

}
