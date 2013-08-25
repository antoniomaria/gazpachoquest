import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.dto.QuestionDTO;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dozer/dozer-context.xml"})
public class DozerExamples {
    @Autowired
    private Mapper mapper;
    
    @Test
    public void dozer(){
        
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // print logback's internal status
        StatusPrinter.print(lc);

        
       QuestionDTO questionDTO = new QuestionDTO();
       List<QuestionDTO> subquestions = new ArrayList<>();
       subquestions.add(QuestionDTO.with().title("subquestion 1").build());
       subquestions.add(QuestionDTO.with().title("subquestion 2").build());
       subquestions.add(QuestionDTO.with().title("subquestion 3").build());
       questionDTO.setSubquestions(subquestions);
       
       Question question = mapper.map(questionDTO, Question.class);
       List<Question> subQuestionsCopy = question.getSubquestions();
       
       for (Question subquestion : subQuestionsCopy) {
           System.out.println(subquestion.getTitle() + " parent:  " + subquestion.getParent());
       }
       
       
    }

}
