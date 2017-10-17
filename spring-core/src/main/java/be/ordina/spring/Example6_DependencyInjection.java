package be.ordina.spring;

import be.ordina.spring.components.SendApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example6_DependencyInjection {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-dependency-injection.xml");

        // We ask the bean created by Spring
        SendApplication app = (SendApplication) context.getBean("sendApplication");
        app.processMessage("Hi TVH with injected EmailServiceAlias!", "info@tvh.com");

        SendApplication app2 = (SendApplication) context.getBean("sendApplication2");
        app2.processMessage("Hi TVH with injected EmailService!", "info@tvh.com");

        context.registerShutdownHook();
    }
}
