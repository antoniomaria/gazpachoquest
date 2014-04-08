/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.core.impl;

import net.sf.gazpachoquest.domain.core.Label;
import net.sf.gazpachoquest.domain.core.LabelSet;
import net.sf.gazpachoquest.repository.LabelSetRepository;
import net.sf.gazpachoquest.services.LabelSetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LabelSetServiceImpl extends AbstractPersistenceService<LabelSet> implements LabelSetService {

    @Autowired
    public LabelSetServiceImpl(final LabelSetRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
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
