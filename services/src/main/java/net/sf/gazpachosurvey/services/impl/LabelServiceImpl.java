package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.repository.LabelRepository;
import net.sf.gazpachosurvey.services.LabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class LabelServiceImpl extends AbstractPersistenceService<Label> implements LabelService {

    @Autowired
    public LabelServiceImpl(LabelRepository repository) {
        super(repository);
    }

    @Override
    public Label save(Label entity) {
        Assert.state(!entity.isNew(), "Label must be already persisted. Try by adding to labelSet first.");
        Label existing = repository.save(entity);
        existing.setLanguage(entity.getLanguage());
        existing.setTitle(entity.getTitle());
   
        return existing;
    }

}
