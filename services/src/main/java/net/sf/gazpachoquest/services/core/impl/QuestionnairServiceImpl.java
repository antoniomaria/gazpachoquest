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

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairAnswers;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.repository.user.PermissionRepository;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.types.EntityStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionnairServiceImpl extends AbstractPersistenceService<Questionnair> implements QuestionnairService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private QuestionnairAnswersRepository questionnairAnswersRepository;

    @Autowired
    public QuestionnairServiceImpl(final QuestionnairRepository questionnairRepository) {
        super(questionnairRepository);
    }

    @Override
    @Transactional(readOnly = false)
    public Questionnair save(final Questionnair questionnair) {
        Questionnair existing = null;
        if (questionnair.isNew()) {
            if (questionnair.getStatus() == null) {
                questionnair.setStatus(EntityStatus.DRAFT);
            } else if (questionnair.getStatus().equals(EntityStatus.CONFIRMED)) {
                // Create answers holder
                QuestionnairAnswers questionnairAnswers = new QuestionnairAnswers();
                questionnairAnswers = questionnairAnswersRepository.save(questionnair.getQuestionnairDefinition()
                        .getId(), questionnairAnswers);
                questionnair.setAnswersId(questionnairAnswers.getId());
            }
            existing = repository.save(questionnair);
        } else {
            existing = repository.findOne(questionnair.getId());
            if (questionnair.getStatus() != null) {
                existing.setStatus(questionnair.getStatus());
            }
            for (Breadcrumb breadcrumb : questionnair.getBreadcrumbs()) {
                if (!breadcrumb.isNew()) {
                    int pos = existing.getBreadcrumbs().indexOf(breadcrumb);
                    existing.getBreadcrumbs().get(pos).setLast(breadcrumb.isLast());
                    continue;
                }
                existing.getBreadcrumbs().add(breadcrumb);
                // existing.addBreadcrumb(breadcrumb);
            }
        }
        return existing;
    }
}
