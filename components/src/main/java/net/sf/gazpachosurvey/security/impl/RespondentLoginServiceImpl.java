package net.sf.gazpachosurvey.security.impl;

import net.sf.gazpachosurvey.domain.core.PersonalInvitation;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.RespondentAnswers;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.domain.support.AbstractInvitation;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.repository.RespondentRepository;
import net.sf.gazpachosurvey.repository.dynamic.RespondentAnswersRepository;
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
    
    @Autowired
    private RespondentAnswersRepository respodentAnswersRepository;

    public void login(String userName, String password) {
        AbstractInvitation invitation = invitationRepository.findOneByExample(
                PersonalInvitation.with().token(password).build(),
                new SearchParameters().caseSensitive().equals());
        PersonalInvitation personalInvitation = null;
        if (invitation instanceof PersonalInvitation) {
            personalInvitation = (PersonalInvitation) invitation;
        }else
        {
            // TODO manage anonymous invitation
        }
        Respondent respondent = personalInvitation.getRespondent();
        if (respondent == null){
            respondent = new Respondent();
            SurveyRunning surveyRunning = invitation.getSurveyRunning();
            Survey survey = surveyRunning.getSurvey();
            
            respondent.setSurvey(survey);
            respondent.setSurveyRunning(surveyRunning);
            respondent = respondentRepository.save(respondent);
            
            RespondentAnswers respondentAnswers = new RespondentAnswers();
            respondentAnswers.setRespondent(respondent);
            respodentAnswersRepository.save(respondentAnswers );
        }
        // System.out.println(abstractInvitation);
    }
}
