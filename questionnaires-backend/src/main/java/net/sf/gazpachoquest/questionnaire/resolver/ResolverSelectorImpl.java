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
package net.sf.gazpachoquest.questionnaire.resolver;

import net.sf.gazpachoquest.types.RenderingMode;
import net.sf.gazpachoquest.types.Topology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ResolverSelectorImpl implements ResolverSelector {

    @Autowired
    @Qualifier("SectionBySectionResolver")
    private PageResolver sectionBySectionResolver;

    @Autowired
    @Qualifier("QuestionByQuestionResolver")
    private PageResolver questionByQuestionResolver;

    @Autowired
    @Qualifier("AllInOneResolver")
    private PageResolver allInOneResolver;

    @Autowired
    @Qualifier("SectionBySectionRelevanceAwareResolver")
    private PageResolver sectionBySectionRelevanceAwareResolver;

    @Override
    public PageResolver selectBy(RenderingMode mode, Topology topology) {
        PageResolver resolver = null;

        switch (topology) {
        case LINEAR:
            switch (mode) {
            case QUESTION_BY_QUESTION:
                resolver = questionByQuestionResolver;
                break;
            case SECTION_BY_SECTION:
                resolver = sectionBySectionResolver;
                break;
            case ALL_IN_ONE:
                resolver = allInOneResolver;
                break;
            default:
                throw new IllegalArgumentException(String.format("Mode %s not supported for topology %s ", mode, topology));
            }
            break;
        case SKIP_PATTERN:
            switch (mode) {
            case SECTION_BY_SECTION:
                resolver = sectionBySectionRelevanceAwareResolver;
                break;
            default:
                throw new IllegalArgumentException(String.format("Mode %s not supported for topology %s ", mode, topology));
            }
            break;
        case BRANCH_PATTERN:
            throw new IllegalArgumentException(String.format("Topology %s not supported", topology));
        }

        return resolver;
    }

}
