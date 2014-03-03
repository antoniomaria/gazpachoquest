package net.sf.gazpachoquest.repository.support;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.repository.qbe.ByExampleEnhancedSpecification;
import net.sf.gazpachoquest.repository.qbe.SearchParameters;

import org.apache.commons.lang.Validate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@NoRepositoryBean
public class GenericRepositoryImpl<T extends Persistable> extends SimpleJpaRepository<T, Integer> implements
        GenericRepository<T> {

    private static final int MAX_VALUES_RETREIVED = 500;
    private ByExampleEnhancedSpecification byExampleEnhancedSpecification;
    private ByExampleSpecification byExampleSpecification;
    private final EntityManager em;
    private final JpaEntityInformation<T, ?> entityInformation;
    private NamedQueryUtil namedQueryUtil;

    private Class<T> type;

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given {@link JpaEntityInformation}.
     * 
     * @param entityInformation
     * @param entityManager
     */
    public GenericRepositoryImpl(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager,
            final ByExampleSpecification byExampleSpecification, final NamedQueryUtil namedQueryUtil) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
        // provider =
        // DefaultPersistenceProvider.fromEntityManager(entityManager);
        // this.springDataRepositoryInterface = springDataRepositoryInterface;
        this.type = entityInformation.getJavaType();
        this.byExampleSpecification = byExampleSpecification;
        this.namedQueryUtil = namedQueryUtil;
        this.byExampleEnhancedSpecification = new ByExampleEnhancedSpecification(entityManager);
    }

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given domain type.
     * 
     * @param domainClass
     * @param em
     */
    protected GenericRepositoryImpl(final Class<T> domainClass, final EntityManager em) {
        this(JpaEntityInformationSupport.getMetadata(domainClass, em), em, null, null);
    }

    @Override
    public long countByExample(final T entity, final SearchParameters sp) {
        Validate.notNull(entity, "The entity cannot be null");
        if (sp.hasNamedQuery()) {
            return getNamedQueryUtil().numberByNamedQuery(sp).intValue();
        }
        Specifications<T> spec = Specifications.where(byExampleEnhancedSpecification.byExampleOnEntity(entity, sp));

        return super.count(spec);
    }

    @Override
    public List<T> find() {
        return findAll(new PageRequest(0, MAX_VALUES_RETREIVED)).getContent();
    }

    @Override
    public List<T> find(final String pattern) {
        Specifications<T> spec = Specifications
                .where(byExampleSpecification.byPatternOnStringAttributes(pattern, type));
        return findAll(spec, new PageRequest(0, MAX_VALUES_RETREIVED)).getContent();
    }

    @Override
    public Page<T> findByExample(final T example, final List<Range<T, ?>> ranges, final Pageable pageable) {
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExample(example));
        spec = RangeSpecification.andRangeIfSet(spec, ranges);
        return findAll(spec, pageable);
    }

    @Override
    public Page<T> findByExample(final T example, final Pageable pageable) {
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExample(example));
        return findAll(spec, pageable);
    }

    @Override
    public List<T> findByExample(final T entity, final SearchParameters sp) {
        Assert.notNull(sp, "Search parameters required");
        if (sp.hasNamedQuery()) {
            return getNamedQueryUtil().findByNamedQuery(sp);
        }
        Specifications<T> spec = Specifications.where(byExampleEnhancedSpecification.byExampleOnEntity(entity, sp));
        return findAll(spec);
    }

    @Override
    public T findOneByExample(final T entity, final SearchParameters sp) {
        Assert.notNull(sp, "Search parameters required");
        Specifications<T> spec = Specifications.where(byExampleEnhancedSpecification.byExampleOnEntity(entity, sp));
        return super.findOne(spec);
    }

    public NamedQueryUtil getNamedQueryUtil() {
        return namedQueryUtil;
    }

    @Override
    @Transactional
    public <S extends T> S saveWithFlush(S entity) {
        if (this.entityInformation.isNew(entity)) {
            this.em.persist(entity);
            flush();
            return entity;
        }
        entity = this.em.merge(entity);
        flush();
        return entity;
    }

    public List<T> saveWithoutFlush(final Iterable<? extends T> entities) {
        List<T> result = new ArrayList<T>();
        if (entities == null) {
            return result;
        }

        for (T entity : entities) {
            result.add(save(entity));
        }
        return result;
    }

}