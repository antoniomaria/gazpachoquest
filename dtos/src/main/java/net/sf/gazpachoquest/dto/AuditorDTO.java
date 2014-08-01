package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;

public class AuditorDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = 5708252721653763420L;

    private String givenNames;

    private String surname;

    public AuditorDTO() {
        super();
    }

    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
