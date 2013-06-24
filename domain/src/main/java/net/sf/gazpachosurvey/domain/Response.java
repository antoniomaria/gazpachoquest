package net.sf.gazpachosurvey.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

@MappedSuperclass
public abstract class Response<PK extends Serializable> extends
        AbstractPersistable<PK> {

    private SurveyRunning surveyRunning;

    private Question question;

}
