package net.sf.gazpachosurvey.repository.support;

import net.sf.gazpachosurvey.types.Language;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LocalizedRepository<L> extends GenericRepository<L> {
    /**
     * Find entity in a certain language
     * 
     * @param id
     * @param language
     * @return
     */
    L findOne(Integer id, Language language);
}
