package net.sf.gazpachosurvey.repository.support;

import java.util.List;

import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {

    long countByExample(T entity, SearchParameters sp);

    List<T> find();

    List<T> find(String pattern);

    Page<T> findByExample(T example, List<Range<T, ?>> ranges, Pageable pageable);

    Page<T> findByExample(T example, Pageable pageable);

    List<T> findByExample(T entity, SearchParameters sp);

    T findOneByExample(T entity, SearchParameters sp);

    <S extends T> S saveWithFlush(S entity);
}