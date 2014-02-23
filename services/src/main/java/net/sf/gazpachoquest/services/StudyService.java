package net.sf.gazpachoquest.services;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.domain.core.Study;

public interface StudyService extends PersistenceService<Study> {

    Study save(Study study, Set<QuestionnairDefinition> questionnairDefinitions, Set<Participant> participants);

}
