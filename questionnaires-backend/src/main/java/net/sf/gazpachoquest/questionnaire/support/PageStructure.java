package net.sf.gazpachoquest.questionnaire.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.sf.gazpachoquest.domain.core.Section;

public class PageStructure {

    private PageMetadataStructure metadata;

    private final List<Section> sections = new ArrayList<>();

    private boolean sectionInfoAvailable;

    private Map<String, Object> answers;
    
    public PageStructure() {
        super();
    }

    public List<Integer> getQuestionsId() {
        List<Integer> allQuestionsId = new ArrayList<>();
        for (Section section : sections) {
            List<Integer> questionIds = section.getQuestionsId();
            allQuestionsId.addAll(questionIds);
        }
        return Collections.unmodifiableList(allQuestionsId);
    }

    public void addSection(Section section) {
        if (!section.isNew()) {
            sectionInfoAvailable = true;
        }
        sections.add(section);
    }

    public PageMetadataStructure getMetadata() {
        return metadata;
    }

    public void setMetadata(PageMetadataStructure metadata) {
        this.metadata = metadata;
    }

    public List<Section> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public boolean isSectionInfoAvailable() {
        return sectionInfoAvailable;
    }

    public Map<String, Object> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Object> answers) {
        this.answers = answers;
    }
    
}
