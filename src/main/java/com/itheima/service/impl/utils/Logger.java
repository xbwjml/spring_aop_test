package com.itheima.service.impl.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类
 */
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(public void com.itheima.service.impl.AccountServiceImpl.saveAccout())")
    private void pt1(){}

    /**
     * 用于打印日志，并且让其在切入点方法执行之前执行
     * 切入点方法就是业务层方法
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法执行");
    }

    //前置通知
//    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("Logger类中的beforePrintLog方法执行");
    }

    //后置通知
//    @AfterReturning("pt1()")
    public void afterRetPrintLog(){
        System.out.println("Logger类中的afterRetPrintLog方法执行");
    }

    //异常通知
//    @AfterThrowing("pt1()")
    public void afterThrowPrintLog(){
        System.out.println("Logger类中的afterThrowPrintLog执行");
    }

    //最终通知
//    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("Logger类中的afterPrintLog执行");
    }

    //环绕通知
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtVal = null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("Logger类中的aroundPrintLog执行,前置");
            rtVal = pjp.proceed();
            System.out.println("Logger类中的aroundPrintLog执行,后置");
            return rtVal;
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog执行,异常");
            throwable.printStackTrace();
        } finally {
            System.out.println("Logger类中的aroundPrintLog执行,最终");
        }
        return rtVal;
    }

}
