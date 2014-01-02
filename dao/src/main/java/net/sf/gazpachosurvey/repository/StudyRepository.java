package net.sf.gazpachosurvey.repository;

import net.sf.gazpachosurvey.domain.core.Study;
import net.sf.gazpachosurvey.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudyRepository extends GenericRepository<Study> {

    @Query("select distinct s from Study s join s.questionnairs q join q.questionnairDefinition qd where qd.id = :questionnairDefinitionId")
    Study findOneByquestionnairDefinition(@Param("questionnairDefinitionId")
    Integer questionnairDefinitionId);

}
