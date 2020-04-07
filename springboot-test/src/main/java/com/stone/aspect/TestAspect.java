package com.stone.aspect;

import com.stone.annotation.TestAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author chen
 * @create 2020-02-17 13:54
 **/

@Aspect
@Component
public class TestAspect {

    @Pointcut("@annotation(com.stone.annotation.TestAnnotation)")
    public void first() {}


    @After("first()")
    public void handle(JoinPoint joinPoint) {

        TestAnnotation testAnnotation = getAnnatation(joinPoint);

        String content = testAnnotation.content();
        int status = testAnnotation.status();

        System.out.println("注解的内容content: " + content + "  状态值为: " + status);
    }

    /**
     * 获取类上的或者方法上的注解
     * @param joinPoint
     * @return
     */
    public TestAnnotation getAnnatation(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        TestAnnotation test = methodSignature.getMethod().getAnnotation(TestAnnotation.class);

        if (test == null) {
            Class<?> targetClass = joinPoint.getTarget().getClass();
            test = targetClass.getAnnotation(TestAnnotation.class);

            System.out.println("AOP反射获取注解失败，请检查~~~");
        }

        return test;
    }
}
