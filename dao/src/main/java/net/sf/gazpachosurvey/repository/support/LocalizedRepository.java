package net.sf.gazpachosurvey.repository.support;

import java.io.Serializable;

import net.sf.gazpachosurvey.types.Language;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LocalizedRepository<L, ID extends Serializable> extends GenericRepository<L, ID> {
    /**
     * Find entity in a certain language
     * @param id
     * @param language
     * @return
     */
    L findOne(ID id, Language language);
}
