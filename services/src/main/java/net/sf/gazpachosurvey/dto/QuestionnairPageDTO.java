package net.sf.gazpachosurvey.dto;

import java.util.List;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;

public class QuestionnairPageDTO extends AbstractIdentifiableDTO {

    private static final long serialVersionUID = -3093554311817776556L;

    private QuestionGroupDTO questionGroup;

    public QuestionnairPageDTO() {
        super();
    }

    public QuestionGroupDTO getQuestionGroup() {
        return questionGroup;
    }

    public void setQuestionGroup(QuestionGroupDTO questionGroup) {
        this.questionGroup = questionGroup;
    }
    public static Builder with() {
        return new Builder();
    }
    public static class Builder {
        private QuestionGroupDTO questionGroup;

        public Builder questionGroup(QuestionGroupDTO questionGroup) {
            this.questionGroup = questionGroup;
            return this;
        }

        public QuestionnairPageDTO build() {
            QuestionnairPageDTO questionnairViewModelDTO = new QuestionnairPageDTO();
            questionnairViewModelDTO.questionGroup = questionGroup;
            return questionnairViewModelDTO;
        }
    }
}
