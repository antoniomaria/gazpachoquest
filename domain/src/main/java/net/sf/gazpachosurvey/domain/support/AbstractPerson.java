package net.sf.gazpachosurvey.domain.support;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractPerson extends AbstractAuditable implements Person{

    private static final long serialVersionUID = 7209387649701141462L;

}
