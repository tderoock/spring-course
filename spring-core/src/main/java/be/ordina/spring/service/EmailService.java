package be.ordina.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Default Spring bean name is <code>emailService</code>.
 *
 * @author Ken Coenen
 */
@Service
public class EmailService implements MessageService, ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private String footer;

    private String defaultRecipient;

    public EmailService() {
    }

    /**
     * @param footer Set with constructor injection (see {@link }
     */
    public EmailService(String footer) {
        this.footer = footer;
    }

    /**
     * @param footer See constructor injection
     * @param names  Collection injection
     */
    public EmailService(String footer, List<String> names) {
        StringBuilder fullFooter = new StringBuilder(footer);
        this.footer = fullFooter.append(StringUtils.arrayToCommaDelimitedString(names.toArray())).toString();
    }

    @Override
    public boolean sendMessage(String msg, String receiver) {
        logger.error("Email message sent to {} with Message '{} {}'", receiver != null ? receiver : defaultRecipient, msg, footer);
        return true;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getFooter() {
        return footer;
    }

    public void setDefaultRecipient(String defaultRecipient) {
        this.defaultRecipient = defaultRecipient;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("Application context is being set!");
    }
}