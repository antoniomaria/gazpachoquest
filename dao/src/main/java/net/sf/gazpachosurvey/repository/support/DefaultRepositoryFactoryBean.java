package net.sf.gazpachosurvey.repository.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class DefaultRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends
        JpaRepositoryFactoryBean<T, S, ID> {

    @Autowired
    ByExampleSpecification byExampleSpecification;
    @Autowired
    NamedQueryUtil namedQueryUtil;

    /**
     * Returns a {@link RepositoryFactorySupport}.
     * 
     * @param entityManager
     * @return
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new DefaultRepositoryFactory(entityManager, byExampleSpecification, namedQueryUtil);
    }
}