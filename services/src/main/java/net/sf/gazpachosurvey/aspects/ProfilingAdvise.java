package net.sf.gazpachosurvey.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ProfilingAdvise {

    private static final Logger logger = LoggerFactory
            .getLogger(ProfilingAdvise.class);

    public Object doProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // http://thoughtforge.net/713/creating-a-profiling-aspect-with-spring-aop-and-aspectj/
        StopWatch watch = new StopWatch();
        watch.start();
        Object obj = proceedingJoinPoint.proceed();
        watch.stop();
        
        String message =  new StringBuffer(proceedingJoinPoint.getTarget().getClass().getName())
        .append(".")
        .append(proceedingJoinPoint.getSignature().getName())
        .toString();
        logger.debug(message + " "+ watch.getTotalTimeMillis());
        return obj;
    }
}
