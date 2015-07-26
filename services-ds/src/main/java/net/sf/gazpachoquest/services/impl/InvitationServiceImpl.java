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
package net.sf.gazpachoquest.services.impl;

import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.repository.InvitationRepository;
import net.sf.gazpachoquest.services.InvitationService;
import net.sf.gazpachoquest.services.support.AbstractPersistenceService;

import org.everit.osgi.transaction.helper.api.TransactionHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class InvitationServiceImpl extends AbstractPersistenceService<Invitation> implements InvitationService {

    private TransactionHelper transactionHelper;

    /**
     * Set transaction helper.
     *
     * @param transactionHelper
     *            helper
     */
    @Reference
    public final void setTransactionHelper(final TransactionHelper transactionHelper) {
        this.transactionHelper = transactionHelper;
    }

    @Override
    public Invitation save(Invitation entity) {
        Invitation result = transactionHelper.required(() -> {
            Invitation fetched = null;
            if (entity.isNew()) {
                fetched = repository.save(entity);
            } else {
                fetched = repository.findOne(entity.getId());
                fetched.setToken(entity.getToken());
                fetched.setStatus(entity.getStatus());
            }
            return fetched;
        });
        return result;
    }

    @Reference
    public void setInvitationRepository(final InvitationRepository repository) {
        super.repository = repository;
    }

}
