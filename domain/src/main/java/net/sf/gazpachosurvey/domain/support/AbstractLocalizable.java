package net.sf.gazpachosurvey.domain.support;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractLocalizable<TR extends Translation<LS>, LS extends LanguageSettings>
        extends AbstractAuditable implements Localizable<LS, TR> {

    private static final long serialVersionUID = 7865009425435975791L;

    protected AbstractLocalizable() {
        super();
    }

}
