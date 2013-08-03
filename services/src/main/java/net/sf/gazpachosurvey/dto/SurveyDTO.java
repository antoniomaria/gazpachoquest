package net.sf.gazpachosurvey.dto;

public class SurveyDTO extends AbstractSerializableDTO<Integer>{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
