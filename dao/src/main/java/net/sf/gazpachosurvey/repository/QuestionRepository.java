package net.sf.gazpachosurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends GenericRepository<Question> {
    @Query("select q from Survey s join s.questionGroups qg join qg.questions q where s.id = :survey order by index(qg),index(q)")
    List<Question> findQuestionsBySurvey(@Param("survey")
    Integer survey);

    @Query("select q from QuestionGroup qg join qg.questions q where qg.id = :questionGroupId order by index(q)")
    List<Question> findQuestionByQuestionGroup(@Param("questionGroupId")
    Integer questionGroupId);

}
