/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
/*
 * Copyright 2012 JAXIO http://www.jaxio.com Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package net.sf.gazpachoquest.qbe;

import static net.sf.gazpachoquest.qbe.Ranges.RangeDate.rangeDate;
import static net.sf.gazpachoquest.qbe.Ranges.RangeLocalDate.rangeLocalDate;
import static net.sf.gazpachoquest.qbe.Ranges.RangeLocalDateTime.rangeLocalDateTime;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.JoinType;
import javax.persistence.metamodel.SingularAttribute;

import net.sf.gazpachoquest.domain.support.Persistable;
import net.sf.gazpachoquest.qbe.Ranges.RangeDate;
import net.sf.gazpachoquest.qbe.Ranges.RangeInteger;
import net.sf.gazpachoquest.qbe.Ranges.RangeLocalDate;
import net.sf.gazpachoquest.qbe.Ranges.RangeLocalDateTime;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The SearchParameters is used to pass search parameters to the DAO layer.
 * 
 * Its usage keeps 'find' method signatures in the DAO/Service layer simple.
 * 
 * A SearchParameters helps you drive your search in the following areas:
 * <ul>
 * <li>Configure the search mode (EQUALS, LIKE, ...)</li>
 * <li>Pagination: it allows you to limit your search results to a specific
 * range.</li>
 * <li>Allow you to specify ORDER BY and ASC/DESC</li>
 * <li>Enable/disable case sensitivity</li>
 * <li>Enable/disable 2d level cache</li>
 * <li>LIKE search against all string values: simply set the searchPattern
 * property</li>
 * <li>Named query: if you set a named query it will be executed. Named queries
 * can be defined in annotation or src/main/resources/META-INF/orm.xml</li>
 * </ul>
 * 
 * Note : All requests are limited to a maximum number of elements to prevent
 * resource exhaustion.
 * 
 * @see ByExampleSpecification
 * @see SearchMode
 * @see OrderBy
 * @see Range
 * @see NamedQueryUtil
 * @see PropertySelector
 * @see EntitySelector
 */
public class SearchParameters {

    private boolean andMode = true;

    private SearchMode searchMode = SearchMode.EQUALS;

    // cache
    private Boolean cacheable = true;

    private String cacheRegion;
    // technical parameters
    private boolean caseSensitive = false;

    // distinct
    private Boolean distinct = false;

    // entity selectors
    private final List<EntitySelector<?, ? extends Persistable, ?>> entities = new ArrayList<EntitySelector<?, ? extends Persistable, ?>>();

    private int firstResult = 0;
    // Joins
    private final Map<JoinType, List<SingularAttribute<?, ?>>> joinAttributes = new HashMap<JoinType, List<SingularAttribute<?, ?>>>();

    // Pagination
    private int maxResults = 500;

    // named query related
    private String namedQuery;

    private final List<OrderBy> orders = new ArrayList<OrderBy>();

    private Map<String, Object> parameters = new HashMap<String, Object>();

    // property selectors
    private final List<PropertySelector<?, ?>> properties = new ArrayList<PropertySelector<?, ?>>();
    // ranges
    private final List<Range<?, ?>> ranges = new ArrayList<Range<?, ?>>();

    // pattern to match against all strings.
    private String searchPattern;

    public SearchParameters() {

    }

    // -----------------------------------
    // Predicate mode
    // -----------------------------------
    public boolean isAndMode() {
        return andMode;
    }

    public void setAndMode(boolean andMode) {
        this.andMode = andMode;
    }

    // -----------------------------------
    // SearchMode
    // -----------------------------------

    public SearchParameters(final EntitySelector<?, ? extends Persistable, ?> entitySelector) {
        addEntity(entitySelector);
    }

    // -----------------------------------
    // Search by property selector support
    // -----------------------------------

    public List<PropertySelector<?, ?>> getProperties() {
        return properties;
    }

    public void addProperty(PropertySelector<?, ?> propertySelector) {
        properties.add(propertySelector);
    }

    public boolean hasProperties() {
        return !properties.isEmpty();
    }

    // -----------------------------------
    // Search by range support
    // -----------------------------------
    public SearchParameters(final Range<?, ?> range) {
        addRange(range);
    }

    public SearchParameters(final SearchMode searchMode) {
        setSearchMode(searchMode);
    }

    public void addEntity(final EntitySelector<?, ? extends Persistable, ?> entitySelector) {
        entities.add(entitySelector);
    }

    public void addNamedQueryParameter(final String name, final Object value) {
        Validate.notNull(name, "name must not be null");
        Validate.notNull(value, "value must not be null");
        parameters.put(name, value);
    }

    public void addOrderBy(final OrderBy orderBy) {
        Validate.notNull(orderBy, "orderBy must not be null");
        orders.add(orderBy);
    }

    public void addOrderBy(final SingularAttribute<? extends Persistable, ? extends Serializable> attribute) {
        Validate.notNull(attribute, "attribute must not be null");
        orders.add(new OrderBy(attribute));
    }

    // -----------------------------------
    // Named query support
    // -----------------------------------

    public void addOrderBy(final SingularAttribute<? extends Persistable, ? extends Serializable> attribute,
            final OrderByDirection direction) {
        Validate.notNull(attribute, "fieldName must not be null");
        Validate.notNull(direction, "direction must not be null");
        orders.add(new OrderBy(attribute, direction));
    }

    public void addOrderBy(final String fieldName) {
        Validate.notNull(fieldName, "fieldName must not be null");
        orders.add(new OrderBy(fieldName));
    }

    public void addOrderBy(final String fieldName, final OrderByDirection direction) {
        Validate.notNull(fieldName, "fieldName must not be null");
        Validate.notNull(direction, "direction must not be null");
        orders.add(new OrderBy(fieldName, direction));
    }

    public void addRange(final Range<?, ?> range) {
        ranges.add(range);
    }

    public SearchParameters after(final SingularAttribute<?, Date> field, final Date from) {
        RangeDate<?> rangeDate = rangeDate(field);
        rangeDate.setFrom(from);
        addRange(rangeDate);
        return this;
    }

    public SearchParameters after(final SingularAttribute<?, LocalDate> field, final LocalDate from) {
        RangeLocalDate<?> rangeLocalDate = rangeLocalDate(field);
        rangeLocalDate.setFrom(from);
        addRange(rangeLocalDate);
        return this;
    }

    public SearchParameters after(final SingularAttribute<?, LocalDateTime> field, final LocalDateTime from) {
        RangeLocalDateTime<?> rangeLocalDateTime = rangeLocalDateTime(field);
        rangeLocalDateTime.setFrom(from);
        addRange(rangeLocalDateTime);
        return this;
    }

    public SearchParameters anywhere() {
        return searchMode(SearchMode.ANYWHERE);
    }

    public SearchParameters before(final SingularAttribute<?, Date> field, final Date setToto) {
        RangeDate<?> rangeDate = rangeDate(field);
        rangeDate.setTo(setToto);
        addRange(rangeDate);
        return this;
    }

    // -----------------------------------
    // Search pattern support
    // -----------------------------------

    public SearchParameters before(final SingularAttribute<?, LocalDate> field, final LocalDate setToto) {
        RangeLocalDate<?> rangeLocalDate = rangeLocalDate(field);
        rangeLocalDate.setTo(setToto);
        addRange(rangeLocalDate);
        return this;
    }

    public SearchParameters before(final SingularAttribute<?, LocalDateTime> field, final LocalDateTime setToto) {
        RangeLocalDateTime<?> rangeLocalDateTime = rangeLocalDateTime(field);
        rangeLocalDateTime.setTo(setToto);
        addRange(rangeLocalDateTime);
        return this;
    }

    public SearchParameters cacheable(final boolean cacheable) {
        setCacheable(cacheable);
        return this;
    }

    public SearchParameters cacheRegion(final String cacheRegion) {
        setCacheRegion(cacheRegion);
        return this;
    }

    // -----------------------------------
    // Case sensitiveness support
    // -----------------------------------

    /**
     * Fluently set the case sensitiveness to false.
     * @return SearchParameters
     */
    public SearchParameters caseInsensitive() {
        setCaseSensitive(false);
        return this;
    }

    /**
     * Fluently set the case sensitiveness to true.
     * 
     * @return SearchParameters
     */
    public SearchParameters caseSensitive() {
        setCaseSensitive(true);
        return this;
    }

    /**
     * Fluently set the case sensitiveness. Defaults to false.
     * 
     * @param caseSensitive
     * @return SearchParameters
     */
    public SearchParameters caseSensitive(final boolean caseSensitive) {
        setCaseSensitive(caseSensitive);
        return this;
    }

    public void clearEntity() {
        entities.clear();
    }

    public void clearOrders() {
        orders.clear();
    }

    public void clearProperties() {
        properties.clear();
    }

    // -----------------------------------
    // Order by support
    // -----------------------------------

    public void clearRanges() {
        ranges.clear();
    }

    public SearchParameters disableCache() {
        setCacheable(false);
        return this;
    }

    public SearchParameters distinct() {
        distinct = true;
        return this;
    }

    public SearchParameters distinct(final boolean value) {
        distinct = value;
        return this;
    }

    public SearchParameters enableCache() {
        setCacheable(true);
        return this;
    }

    /**
     * Use the ENDING_LIKE
     * 
     * @return SearchParameters
     */
    public SearchParameters endingLike() {
        return searchMode(SearchMode.ENDING_LIKE);
    }

    /**
     * Add the passed {@link EntitySelector} in order to construct an OR
     * predicate for the underlying foreign key.
     * 
     * @return SearchParameters
     */
    public SearchParameters entity(final EntitySelector<?, ? extends Persistable, ?> entitySelector) {
        addEntity(entitySelector);
        return this;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public SearchParameters entity(final SingularAttribute<?, ?> field, final Persistable... values) {
        return entity(new EntitySelector(field, values));
    }

    /**
     * Use the EQUALS @{link SearchMode}.
     * 
     * @see SearchMode#EQUALS
     * 
     * @return SearchParameters
     */
    public SearchParameters equals() {
        return searchMode(SearchMode.EQUALS);
    }

    public SearchParameters firstResult(final int firstResult) {
        setFirstResult(firstResult);
        return this;
    }

    public String getCacheRegion() {
        return cacheRegion;
    }

    public List<EntitySelector<?, ? extends Persistable, ?>> getEntities() {
        return entities;
    }

    public int getFirstResult() {
        return firstResult;
    }

    /**
     * Returns the attribute (x-to-one association) which must be fetched with
     * an inner join.
     * @return List
     */
    public List<SingularAttribute<?, ?>> getInnerJoinAttributes() {
        return getJoinAttributes(JoinType.INNER);
    }

    public Map<JoinType, List<SingularAttribute<?, ?>>> getJoinAttributes() {
        return joinAttributes;
    }

    /**
     * Returns the attribute (x-to-one association) which must be fetched with a
     * left join.
     * @return List
     */
    public List<SingularAttribute<?, ?>> getLeftJoinAttributes() {
        return getJoinAttributes(JoinType.LEFT);
    }

    public int getMaxResults() {
        return maxResults;
    }

    /**
     * Return the name of the named query to be used by the DAO layer.
     * @return String
     */
    public String getNamedQuery() {
        return namedQuery;
    }

    /**
     * Return the value of the passed parameter name.
     * @return value
     */
    public Object getNamedQueryParameter(final String parameterName) {
        return parameters.get(parameterName);
    }

    /**
     * The parameters associated with the named query, if any.
     * @return Map
     */
    public Map<String, Object> getNamedQueryParameters() {
        return parameters;
    }

    public List<OrderBy> getOrders() {
        return orders;
    }

    public List<Range<?, ?>> getRanges() {
        return ranges;
    }

    /**
     * Return the @{link SearchMode}. It defaults to EQUALS.
     * 
     * @see SearchMode#EQUALS
     * @return SearchMode
     */
    public SearchMode getSearchMode() {
        return searchMode;
    }

    /**
     * Returns the search pattern to be used by the DAO layer.
     * @return String
     */
    public String getSearchPattern() {
        return searchPattern;
    }

    public SearchParameters greather(final SingularAttribute<?, Integer> field, final Integer value) {
        RangeInteger<?> rangeInteger = RangeInteger.rangeInteger(field);
        rangeInteger.setFrom(value);
        addRange(rangeInteger);
        return this;
    }

    public boolean hasCacheRegion() {
        return isNotBlank(cacheRegion);
    }

    /**
     * Returns true if a named query has been set, false otherwise. When it
     * returns true, the DAO layer will call the
     * namedQuery.
     * @return boolean
     */
    public boolean hasNamedQuery() {
        return isNotBlank(namedQuery);
    }

    public boolean hasOrders() {
        return !orders.isEmpty();
    }

    /**
     * When it returns true, it indicates to the DAO layer to use the passed
     * searchPattern on all string properties.
     * @return boolean
     */
    public boolean hasSearchPattern() {
        return isNotBlank(searchPattern);
    }

    /**
     * The passed attribute (x-to-one association) will be fetched with a inner
     * join.
     * @return SearchParameters
     */
    public SearchParameters innerJoin(final SingularAttribute<?, ?> xToOneAttribute) {
        getInnerJoinAttributes().add(xToOneAttribute);
        return this;
    }

    public boolean isCacheable() {
        return cacheable;
    }

    public boolean isCaseInsensitive() {
        return !caseSensitive;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public boolean isDistinct() {
        return distinct;
    }

    /**
     * The passed attribute (x-to-one association) will be fetched with a left
     * join.
     * @return SearchParameters
     */
    public SearchParameters leftJoin(final SingularAttribute<?, ?> xToOneAttribute) {
        getLeftJoinAttributes().add(xToOneAttribute);
        return this;
    }

    // -----------------------------------
    // Search by entity selector support
    // -----------------------------------

    /**
     * Use the LIKE @{link SearchMode}.
     * 
     * @see SearchMode#LIKE
     * @return SearchParameters
     */
    public SearchParameters like() {
        return searchMode(SearchMode.LIKE);
    }

    public SearchParameters lower(final SingularAttribute<?, Integer> field, final Integer value) {
        RangeInteger<?> rangeInteger = RangeInteger.rangeInteger(field);
        rangeInteger.setTo(value);
        addRange(rangeInteger);
        return this;
    }

    public SearchParameters maxResults(final int maxResults) {
        setMaxResults(maxResults);
        return this;
    }

    /**
     * Fluently set the named query to be used by the DAO layer. Null by
     * default.
     * @return SearchParameters
     */
    public SearchParameters namedQuery(final String namedQuery) {
        setNamedQuery(namedQuery);
        return this;
    }

    /**
     * Fluently set the parameters for the named query.
     * @return SearchParameters
     */
    public SearchParameters namedQueryParameter(final String name, final Object value) {
        addNamedQueryParameter(name, value);
        return this;
    }

    /**
     * Fluently set the parameters for the named query.
     * @return SearchParameters
     */
    public SearchParameters namedQueryParameters(final Map<String, Object> parameters) {
        setNamedQueryParameters(parameters);
        return this;
    }

    // -----------------------------------
    // Pagination support
    // -----------------------------------

    public SearchParameters noLimit() {
        setMaxResults(-1);
        return this;
    }

    public SearchParameters orderBy(final OrderBy orderBy) {
        addOrderBy(orderBy);
        return this;
    }

    public SearchParameters orderBy(final SingularAttribute<? extends Persistable, ? extends Serializable> attribute) {
        addOrderBy(attribute);
        return this;
    }

    public SearchParameters orderBy(final SingularAttribute<? extends Persistable, ? extends Serializable> attribute,
            final OrderByDirection direction) {
        addOrderBy(attribute, direction);
        return this;
    }

    public SearchParameters orderBy(final String fieldName) {
        addOrderBy(fieldName);
        return this;
    }

    public SearchParameters orderBy(final String fieldName, final OrderByDirection direction) {
        addOrderBy(fieldName, direction);
        return this;
    }

    /**
     * Add the passed {@link PropertySelector} in order to construct an OR
     * predicate for the corresponding property.
     * @return SearchParameters
     */
    public SearchParameters property(final PropertySelector<?, ?> propertySelector) {
        addProperty(propertySelector);
        return this;
    }

    /**
     * Add the passed {@link Range} in order to create a 'range' predicate on
     * the corresponding property.
     * @return SearchParameters
     */
    public SearchParameters range(final Range<?, ?> range) {
        addRange(range);
        return this;
    }

    public SearchParameters range(final SingularAttribute<?, Date> field, final Date from, final Date to) {
        addRange(rangeDate(field, from, to));
        return this;
    }

    public SearchParameters range(final SingularAttribute<?, LocalDate> field, final LocalDate from, final LocalDate to) {
        addRange(rangeLocalDate(field, from, to));
        return this;
    }

    public SearchParameters range(final SingularAttribute<?, LocalDateTime> field, final LocalDateTime from,
            final LocalDateTime to) {
        addRange(rangeLocalDateTime(field, from, to));
        return this;
    }

    /**
     * Fluently set the @{link SearchMode}. It defaults to EQUALS.
     * 
     * @see SearchMode#EQUALS
     * @return SearchParameters
     */
    public SearchParameters searchMode(final SearchMode searchMode) {
        setSearchMode(searchMode);
        return this;
    }

    // -----------------------------------
    // Caching support
    // -----------------------------------

    /**
     * Fluently set the pattern which may contains wildcards (ex: "e%r%ka" ).
     * The passed searchPattern is used by the
     * DAO layer on all string properties. Null by default.
     * @return SearchParameters
     */
    public SearchParameters searchPattern(final String searchPattern) {
        setSearchPattern(searchPattern);
        return this;
    }

    /**
     * Default to true.
     */
    public void setCacheable(final boolean cacheable) {
        this.cacheable = cacheable;
    }

    public void setCacheRegion(final String cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

    /**
     * Set the case sensitiveness. Defaults to false.
     * 
     * @param caseSensitive
     */
    public void setCaseSensitive(final boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public void setFirstResult(final int firstResult) {
        this.firstResult = firstResult;
    }

    /**
     * Set the maximum number of results to retrieve. Pass -1 for no limits.
     */
    public void setMaxResults(final int maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * Set the named query to be used by the DAO layer. Null by default.
     */
    public void setNamedQuery(final String namedQuery) {
        this.namedQuery = namedQuery;
    }

    /**
     * Set the parameters for the named query.
     */
    public void setNamedQueryParameters(final Map<String, Object> parameters) {
        Validate.notNull(parameters, "parameters must not be null");
        this.parameters = parameters;
    }

    /**
     * Fluently set the @{link SearchMode}. It defaults to EQUALS.
     * 
     * @see SearchMode#EQUALS
     */
    public void setSearchMode(final SearchMode searchMode) {
        Validate.notNull(searchMode, "searchMode must not be null");
        this.searchMode = searchMode;
    }

    // -----------------------------------
    // Distinct
    // -----------------------------------

    /**
     * Set the pattern which may contains wildcards (ex: "e%r%ka" ). The passed
     * searchPattern is used by the DAO layer
     * on all string properties. Null by default.
     */
    public void setSearchPattern(final String searchPattern) {
        this.searchPattern = searchPattern;
    }

    /**
     * Use the STARTING_LIKE @{link SearchMode}.
     * 
     * @see SearchMode#STARTING_LIKE
     * @return SearchParameters
     */
    public SearchParameters startingLike() {
        return searchMode(SearchMode.STARTING_LIKE);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private List<SingularAttribute<?, ?>> getJoinAttributes(final JoinType inner) {
        List<SingularAttribute<?, ?>> left = joinAttributes.get(inner);
        if (left == null) {
            left = new ArrayList<SingularAttribute<?, ?>>();
            joinAttributes.put(inner, left);
        }
        return left;
    }
}
