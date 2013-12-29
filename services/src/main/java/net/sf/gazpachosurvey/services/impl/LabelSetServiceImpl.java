package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.repository.LabelSetRepository;
import net.sf.gazpachosurvey.services.LabelSetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelSetServiceImpl extends AbstractPersistenceService<LabelSet> implements LabelSetService {

    @Autowired
    public LabelSetServiceImpl(final LabelSetRepository repository) {
        super(repository);
    }

    @Override
    public LabelSet save(final LabelSet labelSet) {
        LabelSet existing = null;
        if (labelSet.isNew()) {
            existing = repository.save(labelSet);
        } else {
            existing = repository.findOne(labelSet.getId());

            for (Label label : labelSet.getLabels()) {
                if (!label.isNew()) {
                    continue;
                }
                existing.addLabel(label);
            }
        }
        return existing;
    }

}
