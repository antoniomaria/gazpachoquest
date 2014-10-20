package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.support.AbstractAuditable_;
import net.sf.gazpachoquest.types.RenderingMode;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-20T09:44:39")
@StaticMetamodel(Breadcrumb.class)
public class Breadcrumb_ extends AbstractAuditable_ {

    public static volatile SingularAttribute<Breadcrumb, Questionnaire> questionnaire;
    public static volatile SingularAttribute<Breadcrumb, Boolean> last;
    public static volatile SingularAttribute<Breadcrumb, RenderingMode> renderingMode;

}