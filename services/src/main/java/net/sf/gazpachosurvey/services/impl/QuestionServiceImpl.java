package net.sf.gazpachosurvey.services.impl;

import javax.annotation.Resource;

import net.sf.gazpachosurvey.domain.core.Answer;
import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.AnswerDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.QuestionRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl extends AbstractPersistenceService<Question, QuestionDTO, Integer> implements
        QuestionService {

    @Resource
    private SurveyRepository surveyRepository;

    @Resource
    private PageRepository pageRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository) {
        super(repository, Question.class, QuestionDTO.class);
    }
    
    @Override
    public QuestionDTO save(QuestionDTO dto) {
        return super.save(dto);
    }
    
    @Override
    public Integer addQuestion(Integer pageId, QuestionDTO question) {
        Page page = pageRepository.findOne(pageId);
        Survey survey = page.getSurvey();
        Question questionEntity = mapper.map(question, Question.class);
        questionEntity.setSurvey(survey);
        questionEntity.setPage(page);
        questionEntity.setLanguage(survey.getLanguage());
        page.addQuestion(questionEntity);
        page = pageRepository.save(page);
        return page.getQuestions().get(page.getQuestions().size() - 1).getId();
    }

}
