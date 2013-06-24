package net.sf.gazpachosurvey.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.support.NamedEntity;

@Entity
public class Survey extends NamedEntity<Integer> {

    private String description;

    private Set<SurveyRunning> surveysRunning;

    public Survey() {
        super();
    }

    public Survey(String name) {
        super();
        super.setName(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "survey")
    public Set<SurveyRunning> getSurveysRunning() {
        if (surveysRunning == null) {
            surveysRunning = new HashSet<>();
        }
        return surveysRunning;
    }

    public void setSurveysRunning(Set<SurveyRunning> surveysRunning) {
        this.surveysRunning = surveysRunning;
    }

    public void addSurveyRunning(SurveyRunning surveyRunning) {
        getSurveysRunning().add(surveyRunning);
        surveyRunning.setSurvey(this);
    }

    public void removeSurveyRunning(SurveyRunning surveyRunning) {
        getSurveysRunning().remove(surveyRunning);
        surveyRunning.setSurvey(null);
    }

    @Override
    public String toString() {
        return "Survey [getId()=" + getId() + ", description=" + description
                + ", name=" + getName() + "]";
    }

}
