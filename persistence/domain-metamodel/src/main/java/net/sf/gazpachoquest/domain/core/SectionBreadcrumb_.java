package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.Section;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-18T16:48:29")
@StaticMetamodel(SectionBreadcrumb.class)
public class SectionBreadcrumb_ extends Breadcrumb_ {

    public static volatile SingularAttribute<SectionBreadcrumb, Integer> questionsDisplayedCount;
    public static volatile SingularAttribute<SectionBreadcrumb, Section> section;
    public static volatile ListAttribute<SectionBreadcrumb, QuestionBreadcrumb> breadcrumbs;

}