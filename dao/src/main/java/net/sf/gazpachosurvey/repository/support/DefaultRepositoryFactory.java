package net.sf.gazpachosurvey.repository.support;

/**
 * 
 * The purpose of this class is to override the default behaviour of the spring JpaRepositoryFactory class. It will
 * produce a GenericRepositoryImpl object instead of SimpleJpaRepository.
 * 
 */

import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.QueryExtractor;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.util.Assert;

public class DefaultRepositoryFactory extends JpaRepositoryFactory {

    private ByExampleSpecification byExampleSpecification;
    private final EntityManager entityManager;
    private final QueryExtractor extractor;
    private NamedQueryUtil namedQueryUtil;

    public DefaultRepositoryFactory(final EntityManager entityManager,
            final ByExampleSpecification byExampleSpecification, final NamedQueryUtil namedQueryUtil) {
        super(entityManager);
        Assert.notNull(entityManager);
        Assert.notNull(byExampleSpecification);
        Assert.notNull(namedQueryUtil);
        this.entityManager = entityManager;
        this.byExampleSpecification = byExampleSpecification;
        this.namedQueryUtil = namedQueryUtil;
        extractor = DefaultPersistenceProvider.fromEntityManager(entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(final RepositoryMetadata metadata) {

        if (isQueryDslExecutor(metadata.getRepositoryInterface())) {
            return QueryDslJpaRepository.class;
        } else {
            return GenericRepositoryImpl.class;
        }
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected <T, ID extends Serializable> JpaRepository<?, ?> getTargetRepository(final RepositoryMetadata metadata,
            final EntityManager entityManager) {

        Class<?> repositoryInterface = metadata.getRepositoryInterface();

        JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());

        if (isQueryDslExecutor(repositoryInterface)) {
            return new QueryDslJpaRepository(entityInformation, entityManager);
        } else {
            return new GenericRepositoryImpl(entityInformation, entityManager, byExampleSpecification, namedQueryUtil); // custom
        }
    }

    /**
     * Returns whether the given repository interface requires a QueryDsl specific implementation to be chosen.
     * 
     * @param repositoryInterface
     * @return
     */
    private boolean isQueryDslExecutor(final Class<?> repositoryInterface) {
        return QUERY_DSL_PRESENT && QueryDslPredicateExecutor.class.isAssignableFrom(repositoryInterface);
    }

}