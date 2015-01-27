package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;

@SuppressWarnings("serial")
public class AuditorDTO extends AbstractIdentifiableDTO {

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
