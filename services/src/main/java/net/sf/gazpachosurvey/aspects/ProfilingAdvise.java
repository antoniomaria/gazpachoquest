package net.sf.gazpachosurvey.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ProfilingAdvise {

    private static final Logger logger = LoggerFactory
            .getLogger(ProfilingAdvise.class);

    private ProfilerThreadLocal profilerThreadLocal = new ProfilerThreadLocal();

    public Object doProfilingxx(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        // http://thoughtforge.net/713/creating-a-profiling-aspect-with-spring-aop-and-aspectj/
        StopWatch watch = new StopWatch();
        watch.start();
        Object obj = proceedingJoinPoint.proceed();
        watch.stop();

        String message = new StringBuffer(proceedingJoinPoint.getTarget()
                .getClass().getName()).append(".")
                .append(proceedingJoinPoint.getSignature().getName())
                .toString();
        logger.debug(message + " " + watch.getTotalTimeMillis());
        return obj;
    }

    public Object doProfiling(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {

        String taskName = createTaskName(proceedingJoinPoint);
        StopWatch taskTimer = profilerThreadLocal.get();
        try {
            taskTimer.start(taskName);

            return proceedingJoinPoint.proceed();
        } finally {
            taskTimer.stop();

            if (taskTimer.getTaskCount() == 0) {
                doLogging(proceedingJoinPoint.getTarget().getClass(),
                        taskTimer.prettyPrint());
                profilerThreadLocal.remove();
            }
        }
    }

    private String createTaskName(ProceedingJoinPoint proceedingJoinPoint) {
        return new StringBuffer(proceedingJoinPoint.getTarget().getClass()
                .getName()).append(".")
                .append(proceedingJoinPoint.getSignature().getName())
                .toString();
    }

    private void doLogging(Class<?> clazz, String prettyPrint) {
        logger.info("\n\n" + prettyPrint + "\n");
    }

    private class ProfilerThreadLocal extends ThreadLocal<StopWatch> {

        @Override
        protected StopWatch initialValue() {
            StopWatch stopWatch = new StopWatch(Thread.currentThread()
                    .getName());
            stopWatch.setKeepTaskList(false);
            return stopWatch;
        }
    }
}
