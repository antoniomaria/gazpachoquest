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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.i18.QuestionnaireDefinitionTranslation;
import net.sf.gazpachoquest.domain.permission.QuestionnaireDefinitionPermission;
import net.sf.gazpachoquest.repository.QuestionnaireDefinitionRepository;
import net.sf.gazpachoquest.services.QuestionnaireDefinitionService;
import net.sf.gazpachoquest.types.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireDefinitionPermissionsAwareServiceImpl extends
        AbstractPermissionsAwarePersistenceService<QuestionnaireDefinition, QuestionnaireDefinitionPermission>
        implements QuestionnaireDefinitionService {
    @Autowired
    public QuestionnaireDefinitionPermissionsAwareServiceImpl(QuestionnaireDefinitionRepository repository) {
        super(repository);
    }

    @Override
    public QuestionnaireDefinition findOne(Integer id, Language language) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public QuestionnaireDefinitionTranslation saveTranslation(QuestionnaireDefinitionTranslation translation) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public Set<Language> translationsSupported(Integer entityId) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public QuestionnaireDefinition confirm(QuestionnaireDefinition questionnaireDefinition) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public int sectionsCount(Integer questionnairDefinitionId) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public Integer questionsCount(Integer questionnairDefinitionId) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public List<Object[]> questionsCountGroupBySections(Integer questionnairDefinitionId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Question> getQuestions(Integer questionnairDefinitionId) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public void exportQuestionnaireDefinition(Integer questionnairDefinitionId, OutputStream outputStream)
            throws XmlMappingException, IOException {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public QuestionnaireDefinition importQuestionnaireDefinition(InputStream inputStream) throws XmlMappingException,
            IOException {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }
    
    @Override
    public boolean isLinear(int questionnaireDefinitionId) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

}
