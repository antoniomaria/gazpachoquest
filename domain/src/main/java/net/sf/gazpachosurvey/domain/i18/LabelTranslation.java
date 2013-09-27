package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class LabelTranslation extends AbstractPersistable {

    @ManyToOne
    private Label label;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Language language;

    @Column(nullable = false)
    private String title;

    public LabelTranslation() {
        super();
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
