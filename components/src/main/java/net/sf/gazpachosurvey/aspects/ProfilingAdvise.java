package net.sf.gazpachosurvey.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

public class ProfilingAdvise {

    private static final Logger logger = LoggerFactory
            .getLogger(ProfilingAdvise.class);

    public Object doProfiling(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        String taskName = createTaskName(proceedingJoinPoint);
        StopWatch taskTimer = new StopWatch();
        try {
            taskTimer.start(taskName);
            return proceedingJoinPoint.proceed();
        } finally {
            taskTimer.stop();
            doLogging(taskTimer.getLastTaskInfo());
        }
    }

    private void doLogging(TaskInfo lastTaskInfo) {
        logger.debug("Method : {} took {} ms", lastTaskInfo.getTaskName(),
                lastTaskInfo.getTimeMillis());
    }

    private String createTaskName(ProceedingJoinPoint proceedingJoinPoint) {
        return new StringBuffer(proceedingJoinPoint.getTarget().getClass()
                .getSimpleName()).append(".")
                .append(proceedingJoinPoint.getSignature().getName())
                .toString();
    }

}
