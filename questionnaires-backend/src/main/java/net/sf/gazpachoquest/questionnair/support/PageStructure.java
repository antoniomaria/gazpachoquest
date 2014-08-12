package net.sf.gazpachoquest.questionnair.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.gazpachoquest.domain.core.QuestionGroup;

public class PageStructure {

    private PageMetadataStructure metadata;

    private final List<Integer> questionsId = new ArrayList<>();

    private final List<QuestionGroup> questionGroups = new ArrayList<>();

    public PageStructure() {
        super();
    }

    public List<Integer> getQuestionsId() {
        return Collections.unmodifiableList(questionsId);
    }

    public void addQuestionsId(Integer questionId) {
        questionsId.add(questionId);
    }

    public void addQuestionGroup(QuestionGroup questionGroup) {
        questionGroups.add(questionGroup);
    }

    public PageMetadataStructure getMetadata() {
        return metadata;
    }

    public void setMetadata(PageMetadataStructure metadata) {
        this.metadata = metadata;
    }

    public List<QuestionGroup> getQuestionGroups() {
        return Collections.unmodifiableList(questionGroups);
    }

}
