package net.sf.gazpachoquest.repository.i18;

import java.util.List;

import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachoquest.repository.support.GenericRepository;
import net.sf.gazpachoquest.types.Language;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionnairDefinitionTranslationRepository extends GenericRepository<QuestionnairDefinitionTranslation> {

    @Query("select t from QuestionnairDefinitionTranslation t where t.language = :language")
    List<QuestionnairDefinitionTranslation> findByLanguage(@Param("language")
    Language language);
}
