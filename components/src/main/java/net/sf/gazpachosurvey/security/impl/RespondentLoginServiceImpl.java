package net.sf.gazpachosurvey.security.impl;

import net.sf.gazpachosurvey.domain.core.PersonalInvitation;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.domain.support.Invitation;
import net.sf.gazpachosurvey.domain.support.Person;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.repository.RespondentRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.security.ServiceLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespondentLoginServiceImpl implements ServiceLogin {

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private RespondentRepository respondentRepository;

    public Person login(String userName, String password) {
        Invitation invitation = invitationRepository.findOneByExample(
                PersonalInvitation.with().token(password).build(),
                new SearchParameters().caseSensitive().equals());
        PersonalInvitation personalInvitation = null;
        if (invitation instanceof PersonalInvitation) {
            personalInvitation = (PersonalInvitation) invitation;
        } else {
            // TODO manage anonymous invitation
        }
        Respondent respondent = personalInvitation.getRespondent();
        if (respondent == null) {
            respondent = new Respondent();
            SurveyRunning surveyRunning = invitation.getSurveyRunning();
            Survey survey = surveyRunning.getSurvey();

            respondent.setSurvey(survey);
            respondent.setSurveyRunning(surveyRunning);
            respondent = respondentRepository.save(respondent);

            personalInvitation.setRespondent(respondent);
        }

        return respondent;
    }
}
