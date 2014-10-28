package net.sf.gazpachoquest.domain.core;

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
import org.joda.time.LocalDateTime;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-28T07:30:16")
@StaticMetamodel(Questionnaire.class)
public class Questionnaire_ extends AbstractSecurizable_ {

    public static volatile SingularAttribute<Questionnaire, User> respondent;
    public static volatile SingularAttribute<Questionnaire, QuestionnaireDefinition> questionnaireDefinition;
    public static volatile SingularAttribute<Questionnaire, EntityStatus> status;
    public static volatile SingularAttribute<Questionnaire, LocalDateTime> submitDate;
    public static volatile SingularAttribute<Questionnaire, Integer> answersId;
    public static volatile SingularAttribute<Questionnaire, Research> research;
    public static volatile ListAttribute<Questionnaire, Breadcrumb> breadcrumbs;

}