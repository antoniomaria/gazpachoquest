package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Label;
import net.sf.gazpachoquest.domain.support.AbstractPersistable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(LabelSet.class)
public class LabelSet_ extends AbstractPersistable_ {

    public static volatile SingularAttribute<LabelSet, String> name;
    public static volatile SingularAttribute<LabelSet, Language> language;
    public static volatile ListAttribute<LabelSet, Label> labels;

}