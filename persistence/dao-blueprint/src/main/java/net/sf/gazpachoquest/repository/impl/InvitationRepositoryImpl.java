package net.sf.gazpachoquest.repository.impl;

import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.repository.InvitationRepository;
import net.sf.gazpachoquest.repository.support.AbstractJPARepository;

import org.apache.aries.jpa.supplier.EmSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvitationRepositoryImpl extends AbstractJPARepository<Invitation> implements InvitationRepository {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(InvitationRepositoryImpl.class);

    @PersistenceContext(unitName = "gazpachoquest")
    protected EmSupplier em;

    public InvitationRepositoryImpl() {
        logger.debug("InvitationRepositoryImpl instance created");
    }

    public void setEm(EmSupplier em) {
        this.em = em;
    }

    @Override
    protected EmSupplier getEm() {
        return this.em;
    }

}
