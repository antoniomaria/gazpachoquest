package net.sf.gazpachoquest.domain.core;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.support.AbstractSecurizable_;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.types.EntityStatus;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(Questionnaire.class)
public class Questionnaire_ extends AbstractSecurizable_ {

    public static volatile SingularAttribute<Questionnaire, Integer> answersId;
    public static volatile SingularAttribute<Questionnaire, LocalDateTime> submitDate;
    public static volatile SingularAttribute<Questionnaire, User> respondent;
    public static volatile SingularAttribute<Questionnaire, QuestionnaireDefinition> questionnaireDefinition;
    public static volatile ListAttribute<Questionnaire, Breadcrumb> breadcrumbs;
    public static volatile SingularAttribute<Questionnaire, Research> research;
    public static volatile SingularAttribute<Questionnaire, EntityStatus> status;

}