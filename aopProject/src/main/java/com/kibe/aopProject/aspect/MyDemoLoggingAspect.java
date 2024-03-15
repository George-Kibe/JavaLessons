package com.kibe.aopProject.aspect;

import com.kibe.aopProject.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // add all related advisors
    // start with @Before advice
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======>>> Executing @Before advice on add account");
    }
//    // new advice for @AfterReturning on findAccounts()
//    @AfterReturning(
//            pointcut = "execution(* com.kibe.aopProject.dao.AccountDAO.findAccounts(..))",
//            returning = "result"
//    )
//    public void afterReturningAdvice(JoinPoint joinPoint, List<Account> result){
//        // print out which method we are advising on
//        String method = joinPoint.getSignature().toShortString();
//        System.out.println("\n======>> Executing @AfterReturning on method "+ method);
//        // print out the results of the method
//        System.out.println("\n====>> result is " + result);
//    }
    @AfterThrowing(
            pointcut = "execution(* com.kibe.aopProject.dao.AccountDAO.findAccounts(..))",
            throwing = "theException"
    )
    public void afterReturningAdvice(JoinPoint joinPoint,Throwable  theException){
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>> Executing @AfterThrowing on method "+ method);
        // print out the results of the method
        System.out.println("\n====>> Encountered this exception " + theException);
    }
    @Around("execution(* com.kibe.aopProject.dao.AccountDAO.findAccounts(..))")
    public Object afterFindAccounts(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("\n======>> Executing @Around on method ");
        // get timestamp at the beginning
        long begin = System.currentTimeMillis();
        // execute the method
        Object result = proceedingJoinPoint.proceed();
        // get timestamp at the end
        long end  = System.currentTimeMillis();
        // compute duration and print it out on console
        long duration = end - begin;
        System.out.println("\n======= Duration to find accounts: " + duration);
        return result;
    }

}
