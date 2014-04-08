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
package net.sf.gazpachoquest.repository.dynamic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairAnswersActivator implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuestionnairAnswersRepository repository;

    @PostConstruct
    public void active() {
        // repository.activeAllAnswers();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // TODO Auto-generated method stub
        repository.activeAllAnswers();
    }
}
