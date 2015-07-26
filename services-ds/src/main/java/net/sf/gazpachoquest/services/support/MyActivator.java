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
package net.sf.gazpachoquest.services.support;

import net.sf.gazpachoquest.domain.core.AnonymousInvitation;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.services.InvitationService;
import net.sf.gazpachoquest.types.InvitationStatus;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class MyActivator {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(MyActivator.class);

    private InvitationService invitationService;

    @Reference
    public void setInvitationService(final InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @Activate
    public void addDemoInvitation() {
        logger.info("Adding Invitation...");
        AnonymousInvitation invitation = AnonymousInvitation.with().status(InvitationStatus.ACTIVE)
                .token( "" +System.currentTimeMillis()).research(Research.with().id(668).build()).build();
        Invitation saved = invitationService.save(invitation);
        logger.info("Iujuu created with Id = {}", saved.getId());
    }
}
