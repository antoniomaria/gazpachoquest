/*
 *  Copyright 2012 JAXIO http://www.jaxio.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.gazpachosurvey.repository.qbe;

import static net.sf.gazpachosurvey.repository.qbe.OrderByDirection.ASC;
import static net.sf.gazpachosurvey.repository.qbe.OrderByDirection.DESC;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import net.sf.gazpachosurvey.domain.support.Persistable;
import net.sf.gazpachosurvey.repository.support.NamedQueryUtil;

import org.apache.commons.lang.Validate;

/**
 * Holder class for search ordering used by the {@link SearchParameters}. When
 * used with {@link NamedQueryUtil}, you pass column name. For other usage, pass
 * the property name.
 */
public class OrderBy implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String columnOrProperty;
    private OrderByDirection direction = ASC;

    public OrderBy(String columnOrProperty, OrderByDirection direction) {
        Validate.notNull(columnOrProperty);
        Validate.notNull(direction);
        this.columnOrProperty = columnOrProperty;
        this.direction = direction;
    }

    public OrderBy(String columnOrProperty) {
        this(columnOrProperty, ASC);
    }

    public OrderBy(
            SingularAttribute<? extends Persistable, ? extends Serializable> attribute,
            OrderByDirection direction) {
        Validate.notNull(attribute);
        Validate.notNull(direction);
        columnOrProperty = attribute.getName();
        this.direction = direction;
    }

    public OrderBy(
            SingularAttribute<? extends Persistable, ? extends Serializable> attribute) {
        this(attribute, ASC);
    }

    public String getColumn() {
        return columnOrProperty;
    }

    public String getProperty() {
        return columnOrProperty;
    }

    public OrderByDirection getDirection() {
        return direction;
    }

    public boolean isOrderDesc() {
        return DESC == direction;
    }
}