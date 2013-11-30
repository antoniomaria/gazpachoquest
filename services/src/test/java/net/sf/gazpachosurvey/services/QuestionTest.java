package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupDTO;

public class QuestionTest {

    public static void main(String[] args) {
        
        QuestionGroupDTO group = new QuestionGroupDTO();
        
        QuestionDTO q1 = new QuestionDTO();
        q1.setId(1);
    
        QuestionDTO q2 = new QuestionDTO();
        q2.setId(2);
        
        QuestionDTO q3 = new QuestionDTO();
        q3.setId(2);
        
        group.addQuestion(q1);

        group.addQuestion(q3);

        group.addQuestion(q2);
        
        System.out.println(group.getQuestions());
    }

}
