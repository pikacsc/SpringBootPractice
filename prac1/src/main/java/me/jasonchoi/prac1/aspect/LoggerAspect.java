package me.jasonchoi.prac1.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    private static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("execution(* me.jasonchoi.prac1.*.*.*(..))")
    private void generalPointCut() {

    }

    @AfterThrowing(pointcut="generalPointCut() throws Exception", throwing="ex")
    public void exceptionLog(JoinPoint joinPoint, Exception ex) throws Exception{
        logger.error(joinPoint.getTarget().getClass().getSimpleName()+" : "+joinPoint.getSignature().getName()
                +" : "+ex.getMessage());
    }


    @Before("generalPointCut()")
    public void infoLog(JoinPoint joinPoint) {
        logger.info(joinPoint.getTarget().getClass().getSimpleName()+" : "+joinPoint.getSignature().getName());
    }
}
