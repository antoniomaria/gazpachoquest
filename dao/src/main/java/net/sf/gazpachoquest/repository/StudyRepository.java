package net.sf.gazpachoquest.repository;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Study;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudyRepository extends GenericRepository<Study> {

    @Query("select distinct s from Study s join s.questionnairs q join q.questionnairDefinition qd where qd.id = :questionnairDefinitionId")
    List<Study> findOneByQuestionnairDefinition(@Param("questionnairDefinitionId")
    Integer questionnairDefinitionId);

}
