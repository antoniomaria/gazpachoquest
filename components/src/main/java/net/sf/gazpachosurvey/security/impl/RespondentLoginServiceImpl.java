package net.sf.gazpachosurvey.security.impl;

import net.sf.gazpachosurvey.domain.core.PersonalInvitation;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyInstance;
import net.sf.gazpachosurvey.domain.support.Invitation;
import net.sf.gazpachosurvey.domain.support.Person;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.repository.RespondentRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.security.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("respondentLoginService")
public class RespondentLoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory
            .getLogger(RespondentLoginServiceImpl.class);

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private RespondentRepository respondentRepository;

    public Person login(String userName, String password) {
        Invitation invitation = invitationRepository.findOneByExample(
                Invitation.with().token(password).build(),
                new SearchParameters().caseSensitive().equals());
        if (invitation == null) {
            return null; // TODO Throw authentication exception
        }
        Respondent respondent = null;
        if (invitation instanceof PersonalInvitation) {
            PersonalInvitation personalInvitation = (PersonalInvitation) invitation;
            respondent = personalInvitation.getRespondent();
            logger.info("Access granted to Respondent {}", respondent.getId());
        }

        if (respondent == null) {
            respondent = new Respondent();
            SurveyInstance surveyInstance = invitation.getSurveyInstance();
            Survey survey = surveyInstance.getSurvey();

            respondent.setSurvey(survey);
            respondent.setSurveyInstance(surveyInstance);
            respondent = respondentRepository.save(respondent);

            if (invitation instanceof PersonalInvitation) {
                PersonalInvitation personalInvitation = (PersonalInvitation) invitation;
                personalInvitation.setRespondent(respondent);
            }
        }

        return respondent;
    }
}
