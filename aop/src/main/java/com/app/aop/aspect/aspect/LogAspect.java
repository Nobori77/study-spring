package com.app.aop.aspect.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Configuration
@Slf4j
public class LogAspect {

//    @Before("@annotation(com.app.aop.aspect.annotation.LogStatus)")
//    public void beforeStart(JoinPoint joinPoint){
//        log.info("join point : " + joinPoint); // 조인포인트 객체
//        log.info("join point args : " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", "))); // 파라미터
//        log.info("join point signature : " + joinPoint.getSignature().getName()); // 메서드 이름
//        log.info("join point target : " + joinPoint.getTarget()); // 타겟
//    }
//
//    @After("@annotation(com.app.aop.aspect.annotation.LogStatus)")
//    public void beforeStart(JoinPoint joinPoint){
//        log.info("join point : " + joinPoint); // 조인포인트 객체
//        log.info("join point args : " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", "))); // 파라미터
//        log.info("join point signature : " + joinPoint.getSignature().getName()); // 메서드 이름
//        log.info("join point target : " + joinPoint.getTarget()); // 타겟
//    }


//    AfterReturning: return이 된 이후에 실행되는 시점
//    @AfterReturning(value = "@annotation(com.app.aop.aspect.annotation.LogStatus)", returning = "returnValue")
//    public void afterReturning(JoinPoint joinPoint, Integer returnValue){
//        log.info("join point : " + joinPoint); // 조인포인트 객체
//        log.info("join point args : " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", "))); // 파라미터
//        log.info("join point signature : " + joinPoint.getSignature().getName()); // 메서드 이름
//        log.info("join point target : " + joinPoint.getTarget()); // 타겟
//        log.info("return value : " + returnValue);
//    }
//

//    예외를 잡아서 처리해주는 것이 아니다.
//    예외가 발생하고 나면 어떻게 처리할 것인가.
//    @AfterThrowing(value = "@annotation(com.app.aop.aspect.annotation.LogStatus)", throwing = "e")
//    public void afterReturning(JoinPoint joinPoint, Exception e){
//        log.info(e.getMessage());
//    }
//

    //    메인 관점을 다시 재정의해야되는 경우
    @Around(value = "@annotation(com.app.aop.aspect.annotation.LogStatus)")
    public Integer around(ProceedingJoinPoint proceedingJoinPoint){
        log.info("point cut", proceedingJoinPoint);
        Integer result = 0;

        try {
            result = (Integer) proceedingJoinPoint.proceed();
        } catch (NumberFormatException e) {
            log.info("NumberFormatException");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return result;
    }






}
