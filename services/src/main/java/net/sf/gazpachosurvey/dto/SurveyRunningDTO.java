package net.sf.gazpachosurvey.dto;

public class SurveyRunningDTO extends AbstractIdentifiableDTO<Integer> {
    
    private static final long serialVersionUID = -8624509103476946501L;

    private String name;

    public SurveyRunningDTO() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
