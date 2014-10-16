package net.sf.gazpachoquest.codelab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELLab {
    
    private static Logger logger = LoggerFactory.getLogger(SpELLab.class);
    
    public static void main(String ...args){
        new SpELLab().execute();
    }
    
    public void execute(){
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("role", "manager");
       
        ExpressionParser parser = new SpelExpressionParser();
        String expression = "#role == 'employee'";
        
        Boolean isEmployee = parser.parseExpression(expression).getValue(context, Boolean.class);
       
        logger.debug("Is employee? {}", isEmployee);
        
    }
    
}
