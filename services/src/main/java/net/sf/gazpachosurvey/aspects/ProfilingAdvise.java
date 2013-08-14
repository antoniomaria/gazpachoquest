package net.sf.gazpachosurvey.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

/**
 * 
 * @author antonio
 * @see http
 *      ://thoughtforge.net/713/creating-a-profiling-aspect-with-spring-aop-and
 *      -aspectj/
 * 
 */
public class ProfilingAdvise {

    private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvise.class);

    private final ProfilerThreadLocal profilerThreadLocal = new ProfilerThreadLocal();

    public Object doProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String taskName = createTaskName(proceedingJoinPoint);
        StopWatch taskTimer = profilerThreadLocal.get();
        try {
            taskTimer.start(taskName);
            return proceedingJoinPoint.proceed();
        } finally {
            taskTimer.stop();
            doLogging(taskTimer.getLastTaskInfo());
            profilerThreadLocal.remove();
        }
    }

    private void doLogging(TaskInfo lastTaskInfo) {
        logger.debug("Method : {} took {} ms", lastTaskInfo.getTaskName(), lastTaskInfo.getTimeMillis());
    }

    private String createTaskName(ProceedingJoinPoint proceedingJoinPoint) {
        return new StringBuffer(proceedingJoinPoint.getTarget().getClass().getSimpleName()).append(".")
                .append(proceedingJoinPoint.getSignature().getName()).toString();
    }

    private class ProfilerThreadLocal extends ThreadLocal<StopWatch> {

        @Override
        protected StopWatch initialValue() {
            StopWatch stopWatch = new StopWatch(Thread.currentThread().getName());
            stopWatch.setKeepTaskList(false);
            return stopWatch;
        }

    }
}
