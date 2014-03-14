package net.sf.gazpachoquest.repository;

import java.util.List;

import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionGroupRepository extends GenericRepository<QuestionGroup> {
    @Query("select qg from QuestionnairDefinition s join s.questionGroups qg where s.id = :questionnairDefinition order by index(qg)")
    List<QuestionGroup> findByQuestionnairDefinitionId(@Param("questionnairDefinition")
    Integer questionnairDefinitionId);

    @Query("select qg from QuestionnairDefinition s join s.questionGroups qg where s.id = :questionnairDefinition and index(qg) = :position")
    QuestionGroup findOneByPositionInQuestionnairDefinition(@Param("questionnairDefinition")
    Integer questionnairDefinitionId, @Param("position")
    Integer position);

    @Query("select index(qg) from QuestionnairDefinition s join s.questionGroups qg where qg.id = :questionGroupId")
    Integer findPositionInQuestionnairDefinition(@Param("questionGroupId")
    Integer questionGroupId);
}
