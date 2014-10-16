package net.sf.gazpachoquest.codelab;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.el.VariableMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import de.odysseus.el.tree.Tree;
import de.odysseus.el.tree.TreeBuilder;
import de.odysseus.el.tree.impl.Builder;

public class JUELLab {

    private static Logger logger = LoggerFactory.getLogger(JUELLab.class);

    public static void main(String... args) {
        new JUELLab().execute();
    }

    private void execute() {
        // TODO Auto-generated method stub

        ExpressionFactory factory = new de.odysseus.el.ExpressionFactoryImpl();

        de.odysseus.el.util.SimpleContext context = new de.odysseus.el.util.SimpleContext();

        // map variable foo to 0
        // context.setVariable("Q1", factory.createValueExpression("yes", String.class));
        context.setVariable("xQ1", factory.createValueExpression(null, String.class));
        
        String expression = "${Q1 == 'yes'}";

        // parse our expression
        ValueExpression e = factory.createValueExpression(context, expression, Boolean.class);
        
        logger.debug("Is Section visible? {}", e.getValue(context));
        
        Map<String, Object> answers = new HashMap<String, Object>();
        answers.put("Q1", "yes");
        answers.put("Q2", 1);
        
        for (Entry<String, Object> answer : answers.entrySet()) {
            String code = answer.getKey();
            Object value = answer.getValue();
            
            System.out.println(value.getClass());
        }
    }

    public void helloJUEL() {
        // http://mvel.codehaus.org/Getting+Started+for+2.0
        // the ExpressionFactory implementation is
        // de.odysseus.el.ExpressionFactoryImpl
        ExpressionFactory factory = new de.odysseus.el.ExpressionFactoryImpl();

        // package de.odysseus.el.util provides a ready-to-use subclass of
        // ELContext
        de.odysseus.el.util.SimpleContext context = new de.odysseus.el.util.SimpleContext();

        // map variable foo to 0
        context.setVariable("role", factory.createValueExpression("manager", String.class));

        String expression = "${role == 'manager'}";

        // parse our expression
        ValueExpression e = factory.createValueExpression(context, expression, Boolean.class);

        logger.debug("Is employee? {}", e.getValue(context));

        TreeBuilder builder = new Builder();

        Tree tree = builder.build(expression);

        System.out.println(tree.getRoot().getChild(0));

        VariableMapper mapper = context.getVariableMapper();
        System.out.println(mapper);
    }

}
