package be.ordina.spring;

import be.ordina.spring.service.EmailService;
import be.ordina.spring.service.MessageService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example3_ApplicationContext {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        // We ask the bean created by Spring
        MessageService emailService = (MessageService) context.getBean("emailService");
        emailService.sendMessage("Hi TVH with EmailService managed by Spring!", "info@tvh.com");

        context.registerShutdownHook();
    }
}
