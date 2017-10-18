package be.ordina.spring;

import be.ordina.spring.scope.ScopeApp;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example_SpringAOP {
    public static void main(String... args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-advice.xml");

        // We ask the bean created by Spring
        ScopeApp app = (ScopeApp) context.getBean("scopeApp");
        app.increment();
        app.increment();
        app.print();

        ScopeApp app2 = (ScopeApp) context.getBean("scopeApp2");
        app2.print();

        context.registerShutdownHook();
    }
}
