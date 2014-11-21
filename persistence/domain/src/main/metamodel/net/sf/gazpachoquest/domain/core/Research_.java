package net.sf.gazpachoquest.domain.core;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.support.AbstractSecurizable_;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.ResearchAccessType;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(Research.class)
public class Research_ extends AbstractSecurizable_ {

    public static volatile SetAttribute<Research, Questionnaire> questionnaires;
    public static volatile SingularAttribute<Research, String> name;
    public static volatile SingularAttribute<Research, QuestionnaireDefinition> questionnaireDefinition;
    public static volatile SingularAttribute<Research, ResearchAccessType> type;
    public static volatile SingularAttribute<Research, LocalDateTime> startDate;
    public static volatile SingularAttribute<Research, EntityStatus> status;
    public static volatile SingularAttribute<Research, LocalDateTime> expirationDate;

}