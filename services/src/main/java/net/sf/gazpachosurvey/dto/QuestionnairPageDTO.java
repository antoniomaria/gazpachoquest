package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;

public class QuestionnairPageDTO extends AbstractIdentifiableDTO {

    public static class Builder {
        private QuestionGroupDTO questionGroup;

        public QuestionnairPageDTO build() {
            QuestionnairPageDTO questionnairViewModelDTO = new QuestionnairPageDTO();
            questionnairViewModelDTO.questionGroup = questionGroup;
            return questionnairViewModelDTO;
        }

        public Builder questionGroup(final QuestionGroupDTO questionGroup) {
            this.questionGroup = questionGroup;
            return this;
        }
    }

    private static final long serialVersionUID = -3093554311817776556L;

    public static Builder with() {
        return new Builder();
    }

    private QuestionGroupDTO questionGroup;

    public QuestionnairPageDTO() {
        super();
    }

    public QuestionGroupDTO getQuestionGroup() {
        return questionGroup;
    }

    public void setQuestionGroup(final QuestionGroupDTO questionGroup) {
        this.questionGroup = questionGroup;
    }
}
