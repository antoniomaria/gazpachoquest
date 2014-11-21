package net.sf.gazpachoquest.domain.i18;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Label;
import net.sf.gazpachoquest.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(LabelTranslation.class)
public class LabelTranslation_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<LabelTranslation, LabelLanguageSettings> languageSettings;
    public static volatile SingularAttribute<LabelTranslation, Language> language;
    public static volatile SingularAttribute<LabelTranslation, Label> label;

}