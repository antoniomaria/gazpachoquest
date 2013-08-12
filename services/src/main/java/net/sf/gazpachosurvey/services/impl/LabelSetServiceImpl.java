package net.sf.gazpachosurvey.services.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.dto.Identifiable;
import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.repository.LabelRepository;
import net.sf.gazpachosurvey.repository.LabelSetRepository;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.LabelSetService;

@Service
public class LabelSetServiceImpl extends AbstractPersistenceService<LabelSetRepository, LabelSet, LabelSetDTO, Integer>implements LabelSetService {

    @Autowired
    public LabelSetServiceImpl(LabelSetRepository repository) {
        super(repository, LabelSetDTO.class);
    }

    @Autowired
    private LabelSetRepository labelSetRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public Integer addLabelSet(LabelSetDTO labelSet) {
        LabelSet entity = mapper.map(labelSet, LabelSet.class);
        return labelSetRepository.save(entity).getId();
    }

    public Integer addLabel(Integer labelSetId, LabelDTO label) {
        LabelSet labelSet = labelSetRepository.findOne(labelSetId);

        Label entity = mapper.map(label, Label.class);
        entity.setLanguage(labelSet.getLanguage());

        labelSet.addLabel(entity);

        return labelSet.getLabels().get(labelSet.getLabels().size() - 1)
                .getId();
    }
}
