package be.ordina.spring;

import be.ordina.spring.service.EmailService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * @author Ken Coenen
 */
public class Example2_BeanFactory {
    public static void main(String[] args) {
        // We have to construct a {@link BeanFactory} based on a configuration file
        ClassPathResource resource = new ClassPathResource("/context.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        // We ask the bean created by Spring
        EmailService emailService = (EmailService) factory.getBean("emailService");
        emailService.sendMessage("Hi TVH with EmailService managed by Spring!", "info@tvh.com");
    }
}
