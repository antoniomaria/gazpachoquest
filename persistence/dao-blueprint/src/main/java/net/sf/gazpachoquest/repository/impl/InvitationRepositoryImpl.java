package net.sf.gazpachoquest.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.qbe.Range;
import net.sf.gazpachoquest.qbe.SearchParameters;
import net.sf.gazpachoquest.repository.InvitationRepository;
import net.sf.gazpachoquest.repository.support.RepositoryTemplate;

import org.apache.aries.jpa.supplier.EmSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class InvitationRepositoryImpl implements InvitationRepository {

    /**
      * Logger.
      */
    private static final Logger logger = LoggerFactory.getLogger(InvitationRepositoryImpl.class);

    protected RepositoryTemplate<Invitation> template;

    @PersistenceContext(unitName = "gazpachoquest")
    protected EmSupplier em;

    // protected EntityManager em;

    public InvitationRepositoryImpl() {
        logger.debug("InvitationRepositoryImpl instance created");
    }

    @Override
    public long countByExample(final Invitation entity, final SearchParameters sp) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Page<Invitation> findByExample(final Invitation example, final List<Range<?, ?>> ranges, final Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Invitation> findByExample(final Invitation example, final Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Invitation> findByExample(final Invitation entity, final SearchParameters sp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Invitation> findOneByExample(final Invitation entity, final SearchParameters sp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    // @Transaction
            public
            <S extends Invitation> S save(final S entity) {
        /*-
        if (template == null) {
            System.out.println("Chungo template not injected in InvitationRepositoryImpl");
            return entity;
        }
        return template.save(entity);*/
        if (em == null) {
            System.out.println("Chungo entityManager not injected in InvitationRepositoryImpl ");
            return entity;
        }
        em.get().persist(entity);
        em.get().flush();
        return entity;
    }

    @Override
    public void deleteByExample(final Invitation entity, final SearchParameters sp) {
        // TODO Auto-generated method stub

    }

    public void setTemplate(final RepositoryTemplate<Invitation> template) {
        this.template = template;
    }

    public RepositoryTemplate<Invitation> getTemplate() {
        return template;
    }

}
