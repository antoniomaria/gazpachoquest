package net.sf.gazpachosurvey.security.impl;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.PersonalInvitation;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.Study;
import net.sf.gazpachosurvey.domain.support.Invitation;
import net.sf.gazpachosurvey.domain.support.Person;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.repository.QuestionnairRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.security.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("respondentLoginService")
public class RespondentLoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(RespondentLoginServiceImpl.class);

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Override
    public Person login(final String userName, final String password) {
        Invitation invitation = invitationRepository.findOneByExample(Invitation.with().token(password).build(),
                new SearchParameters().caseSensitive().equals());
        if (invitation == null) {
            return null; // TODO Throw authentication exception
        }
        Participant participant = null;
        Questionnair questionnair = null;
        if (invitation instanceof PersonalInvitation) {
            PersonalInvitation personalInvitation = (PersonalInvitation) invitation;
            participant = personalInvitation.getParticipant();

            // respondent = personalInvitation.getParticipant()
        }

        if (questionnair == null) {
            questionnair = new Questionnair();
            Study study = invitation.getSurveyInstance();
            questionnair.setStudy(study);
            questionnair = questionnairRepository.save(questionnair);

            if (invitation instanceof PersonalInvitation) {
                PersonalInvitation personalInvitation = (PersonalInvitation) invitation;
                // personalInvitation.setRespondent(respondent);
            }
        }
        logger.info("Access granted to Respondent {}", questionnair.getId());
        return null;
    }
}
