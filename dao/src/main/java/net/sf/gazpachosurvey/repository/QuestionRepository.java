package net.sf.gazpachosurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends GenericRepository<Question> {

    @Query("select q from Question q join q.questionGroup qg join qg.survey s where s.id = :survey")
    List<Question> findQuestionsBySurvey(@Param("survey") Integer survey);
}
