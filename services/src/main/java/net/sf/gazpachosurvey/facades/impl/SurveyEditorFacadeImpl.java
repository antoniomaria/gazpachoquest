package net.sf.gazpachosurvey.facades.impl;

import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.facades.SurveyEditorFacade;
import net.sf.gazpachosurvey.services.LabelSetService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class SurveyEditorFacadeImpl implements SurveyEditorFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private LabelSetService labelSetService;

    public SurveyEditorFacadeImpl() {
        super();
    }

    public LabelSetDTO save(LabelSetDTO labelSet) {
        LabelSet entity = mapper.map(labelSet, LabelSet.class);
        entity = labelSetService.save(entity);
        return mapper.map(entity, LabelSetDTO.class);
    }
}
