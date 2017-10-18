package be.ordina.spring;

import be.ordina.spring.scope.ScopeApp;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example_Scope {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-scope.xml");

        // We ask the bean created by Spring
        ScopeApp app = (ScopeApp) context.getBean("scopeApp1");
        app.increment();
        app.increment();
        app.print();

        ScopeApp app2 = (ScopeApp) context.getBean("scopeApp2");
        app2.print();

        context.registerShutdownHook();
    }
}
