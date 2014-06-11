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
package net.sf.gazpachoquest.questionnair.resolver;

import net.sf.gazpachoquest.types.RenderingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ResolverSelectorImpl implements ResolverSelector {

    @Autowired
    @Qualifier("GroupByGroupResolver")
    private QuestionnairElementResolver groupByGroupResolver;

    @Autowired
    @Qualifier("QuestionByQuestionResolver")
    private QuestionnairElementResolver questionByQuestionResolver;

    @Override
    public QuestionnairElementResolver selectBy(RenderingMode mode) {
        QuestionnairElementResolver resolver = null;
        switch (mode) {
        case QUESTION_BY_QUESTION:
            resolver = questionByQuestionResolver;
            break;
        case GROUP_BY_GROUP:
            resolver = groupByGroupResolver;
            break;
        default:
            throw new IllegalArgumentException(String.format("Mode %s not supported", mode));
        }
        return resolver;
    }

}
