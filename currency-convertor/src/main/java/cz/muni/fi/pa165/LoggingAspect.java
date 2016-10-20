package cz.muni.fi.pa165;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author rba on 13.10.2016.
 */

@Aspect
public class LoggingAspect {

    @Before("execution(* cz.muni.fi.pa165.currency.CurrencyConvertor.convert(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("before " + System.currentTimeMillis());
    }

    @After("execution(* cz.muni.fi.pa165.currency.CurrencyConvertor.convert(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("after " + System.currentTimeMillis());
    }

}
