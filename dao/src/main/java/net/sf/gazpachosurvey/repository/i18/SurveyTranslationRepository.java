package net.sf.gazpachosurvey.repository.i18;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.types.Language;

public interface SurveyTranslationRepository extends
        GenericRepository<SurveyTranslation, Integer> {

    @Query("select t from SurveyTranslation t where t.language = :language")
    List<SurveyTranslation> findByLanguage(@Param("language") Language language);
}
