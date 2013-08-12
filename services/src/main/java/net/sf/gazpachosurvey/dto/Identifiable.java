package net.sf.gazpachosurvey.dto;

import java.io.Serializable;

public interface Identifiable <ID extends Serializable> extends Serializable{

    ID getId();

}
