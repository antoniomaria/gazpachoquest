package net.sf.gazpachoquest.questionnair.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageStructure {

    private PageMetadataStructure metadata;

    private final List<Integer> questionsId = new ArrayList<>();

    public PageStructure() {
        super();
    }

    public List<Integer> getQuestionsId() {
        return Collections.unmodifiableList(questionsId);
    }

    public void addQuestionsId(Integer questionId) {
        questionsId.add(questionId);
    }

    public PageMetadataStructure getMetadata() {
        return metadata;
    }

    public void setMetadata(PageMetadataStructure metadata) {
        this.metadata = metadata;
    }

}
