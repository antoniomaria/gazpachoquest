package net.sf.gazpachosurvey.repository.support;

import java.io.Serializable;

import net.sf.gazpachosurvey.types.Language;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LocalizedRepository<ID extends Serializable, L> extends GenericRepository<L, ID> {

    public L findOne(ID id, Language language);
}
