package net.sf.gazpachosurvey.repository.support;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.repository.qbe.ByExampleEnhancedSpecification;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

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

    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;
    private Class<T> type;
    private ByExampleSpecification byExampleSpecification;
    private NamedQueryUtil namedQueryUtil;
    private ByExampleEnhancedSpecification byExampleEnhancedSpecification;

    private static final int MAX_VALUES_RETREIVED = 500;

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given {@link JpaEntityInformation}.
     * 
     * @param entityInformation
     * @param entityManager
     */
    public GenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager,
            ByExampleSpecification byExampleSpecification, NamedQueryUtil namedQueryUtil) {
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
    protected GenericRepositoryImpl(Class<T> domainClass, EntityManager em) {
        this(JpaEntityInformationSupport.getMetadata(domainClass, em), em, null, null);
    }

    @Override
    public Page<T> findByExample(T example, Pageable pageable) {
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExample(example));
        return findAll(spec, pageable);
    }

    @Override
    public Page<T> findByExample(T example, List<Range<T, ?>> ranges, Pageable pageable) {
        Specifications<T> spec = Specifications.where(byExampleSpecification.byExample(example));
        spec = RangeSpecification.andRangeIfSet(spec, ranges);
        return findAll(spec, pageable);
    }

    @Override
    public List<T> find() {
        return findAll(new PageRequest(0, MAX_VALUES_RETREIVED)).getContent();
    }

    @Override
    public List<T> find(String pattern) {
        Specifications<T> spec = Specifications
                .where(byExampleSpecification.byPatternOnStringAttributes(pattern, type));
        return findAll(spec, new PageRequest(0, MAX_VALUES_RETREIVED)).getContent();
    }

    @Override
    public List<T> findByExample(T entity, SearchParameters sp) {
        Assert.notNull(sp, "Search parameters required");
        if (sp.hasNamedQuery()) {
            return getNamedQueryUtil().findByNamedQuery(sp);
        }
        Specifications<T> spec = Specifications.where(byExampleEnhancedSpecification.byExampleOnEntity(entity, sp));
        return findAll(spec);
    }

    @Override
    public T findOneByExample(T entity, SearchParameters sp) {
        Assert.notNull(sp, "Search parameters required");
        Specifications<T> spec = Specifications.where(byExampleEnhancedSpecification.byExampleOnEntity(entity, sp));
        return super.findOne(spec);
    }

    @Override
    public long countByExample(T entity, SearchParameters sp) {
        Validate.notNull(entity, "The entity cannot be null");
        if (sp.hasNamedQuery()) {
            return getNamedQueryUtil().numberByNamedQuery(sp).intValue();
        }
        Specifications<T> spec = Specifications.where(byExampleEnhancedSpecification.byExampleOnEntity(entity, sp));

        return super.count(spec);
    }

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

    public List<T> saveWithoutFlush(Iterable<? extends T> entities) {
        List<T> result = new ArrayList<T>();
        if (entities == null) {
            return result;
        }

        for (T entity : entities) {
            result.add(save(entity));
        }
        return result;
    }

    public NamedQueryUtil getNamedQueryUtil() {
        return namedQueryUtil;
    }

}