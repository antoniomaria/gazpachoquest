package net.sf.gazpachoquest.repository.impl;

import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.core.LabelSet;
import net.sf.gazpachoquest.repository.LabelSetRepository;
import net.sf.gazpachoquest.repository.support.AbstractJPARepository;

import org.apache.aries.jpa.supplier.EmSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelSetRepositoryImpl extends AbstractJPARepository<LabelSet> implements LabelSetRepository {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(LabelSetRepositoryImpl.class);

    @PersistenceContext(unitName = "gazpachoquest")
    protected EmSupplier em;

    public LabelSetRepositoryImpl() {
        super(LabelSet.class);
        logger.debug("Instance created");
    }

    public void setEm(EmSupplier em) {
        this.em = em;
    }

    @Override
    protected EmSupplier getEm() {
        return this.em;
    }

}
