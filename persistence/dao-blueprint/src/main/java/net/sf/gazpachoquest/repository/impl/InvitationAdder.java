/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIESOR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package net.sf.gazpachoquest.repository.impl;

import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.repository.InvitationRepository;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class InvitationAdder {

    private InvitationRepository invitationRepository;

    @Reference
    public void setInvitationRepository(final InvitationRepository taskService) {
        this.invitationRepository = taskService;
    }

    @Activate
    public void addDemoInvitation() {
        final Invitation invitation = Invitation.with().token("" + System.currentTimeMillis()).build();
        invitationRepository.save(invitation);
    }
}
