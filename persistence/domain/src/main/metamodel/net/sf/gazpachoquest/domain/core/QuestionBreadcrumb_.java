package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(QuestionBreadcrumb.class)
public class QuestionBreadcrumb_ extends Breadcrumb_ {

    public static volatile SingularAttribute<QuestionBreadcrumb, Breadcrumb> parent;
    public static volatile SingularAttribute<QuestionBreadcrumb, Question> question;
    public static volatile SingularAttribute<QuestionBreadcrumb, Integer> questionNumber;

}