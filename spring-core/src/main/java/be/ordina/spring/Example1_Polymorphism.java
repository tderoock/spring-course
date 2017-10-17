package be.ordina.spring;

import be.ordina.spring.components.SendApplication;
import be.ordina.spring.service.EmailService;
import be.ordina.spring.service.MessageService;
import be.ordina.spring.service.TextService;

/**
 * @author Ken Coenen
 */
public class Example1_Polymorphism {
    public static void main(String[] args) {
        // Without polymorphism
        new EmailService().sendMessage("Hi TVH with EmailService implementation!", "info@tvh.com");
        new TextService().sendMessage("Hi TVH with TextService implementation!", "0123456789");

        // With polymorphism but with knowledge of which service you're using (no inversion of control!)
        MessageService service = new EmailService();
        service.sendMessage("Hi TVH with MessageService interface!", "info@tvh.com");

        // Inversion of Control in the SendApplication class (it does not create the dependency itself)
        // This allows for loose coupling
        SendApplication app = new SendApplication();
        app.setMessageService(service);
        app.processMessage("Hi TVH through SendApplication!", "info@tvh.com");
    }
}
