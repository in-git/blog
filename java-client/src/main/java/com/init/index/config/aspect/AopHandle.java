package com.init.index.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
//@Component
@Slf4j
//@Aspect
public class AopHandle {
    @Before("execution(* com.init.index.module..*(..))")
    public void before() throws Throwable { }
}
