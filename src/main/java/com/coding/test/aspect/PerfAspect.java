package com.coding.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    // Advice 정의 (Around 사용)
    // Point Cut 표현식
    // (com.example.demo 밑에 있는 모든 클래스 중 EventService 안에 들어있는 모든 메쏘드에 이 행위를 적용하라.)
    @Around("@annotation(PerfLogging)")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }
}