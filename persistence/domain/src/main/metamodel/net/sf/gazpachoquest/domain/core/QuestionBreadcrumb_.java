package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-20T09:44:39")
@StaticMetamodel(QuestionBreadcrumb.class)
public class QuestionBreadcrumb_ extends Breadcrumb_ {

    public static volatile SingularAttribute<QuestionBreadcrumb, Integer> questionNumber;
    public static volatile SingularAttribute<QuestionBreadcrumb, Breadcrumb> parent;
    public static volatile SingularAttribute<QuestionBreadcrumb, Question> question;

}