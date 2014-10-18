package net.sf.gazpachoquest.domain.i18;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.embeddables.SectionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-18T16:48:29")
@StaticMetamodel(SectionTranslation.class)
public class SectionTranslation_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<SectionTranslation, SectionLanguageSettings> languageSettings;
    public static volatile SingularAttribute<SectionTranslation, Language> language;
    public static volatile SingularAttribute<SectionTranslation, Section> section;

}