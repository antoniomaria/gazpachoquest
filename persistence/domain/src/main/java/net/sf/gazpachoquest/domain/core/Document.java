package net.sf.gazpachoquest.domain.core;

import javax.persistence.Column;

/**
 * Prof of concept of liquibase diff
 * @author antoniomaria
 *
 */
@SuppressWarnings("serial")
// @Entity
// public class Document extends AbstractPersistable {
public class Document {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Document() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
