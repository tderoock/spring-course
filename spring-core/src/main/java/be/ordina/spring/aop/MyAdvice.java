package be.ordina.spring.aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAdvice implements MethodBeforeAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MyAdvice.class);

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.info("This is executed before: " + method.getName());
    }
}
