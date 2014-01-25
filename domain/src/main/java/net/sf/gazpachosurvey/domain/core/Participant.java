package net.sf.gazpachosurvey.domain.core;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import net.sf.gazpachosurvey.domain.support.AbstractAuditable;
import net.sf.gazpachosurvey.domain.support.Person;
import net.sf.gazpachosurvey.types.Gender;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class Participant extends AbstractAuditable implements Person {

    private static final long serialVersionUID = 6716148852807992302L;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private String email;

    private Language preferedLanguage;

    private Gender gender;

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY)
    private Set<Questionnair> questionnairs;

    public Participant() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public Gender getGender() {
        return gender;
    }

    public String getLastname() {
        return lastname;
    }

    public Language getPreferedLanguage() {
        return preferedLanguage;
    }

    public Set<Questionnair> getQuestionnairs() {
        return questionnairs;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPreferedLanguage(Language preferedLanguage) {
        this.preferedLanguage = preferedLanguage;
    }

    public void setQuestionnairs(Set<Questionnair> questionnairs) {
        this.questionnairs = questionnairs;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String firstname;
        private String lastname;
        private String email;
        private Language preferedLanguage;
        private Gender gender;
        private Set<Questionnair> questionnairs;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder preferedLanguage(Language preferedLanguage) {
            this.preferedLanguage = preferedLanguage;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder questionnairs(Set<Questionnair> questionnairs) {
            this.questionnairs = questionnairs;
            return this;
        }

        public Participant build() {
            Participant participant = new Participant();
            participant.setId(id);
            participant.firstname = firstname;
            participant.lastname = lastname;
            participant.email = email;
            participant.preferedLanguage = preferedLanguage;
            participant.gender = gender;
            participant.questionnairs = questionnairs;
            return participant;
        }
    }

    @Override
    public String getName() {
        return getFirstname();
    }

    @Override
    public Set<String> getRoles() {
        Set<String> rolesSet = new TreeSet<>();
        rolesSet.add("respondent");
        return rolesSet;
    }
}
