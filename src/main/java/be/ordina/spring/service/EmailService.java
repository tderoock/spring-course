package be.ordina.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default Spring bean name is <code>emailService</code>.
 *
 * @author Ken Coenen
 */
@Service
public class EmailService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private String footer;

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
        if (names != null) {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (i == names.size() - 1) {
                    fullFooter.append(" and ");
                } else if (i < names.size() && i != 0) {
                    fullFooter.append(", ");
                }
                fullFooter.append(name);
            }
        }
        this.footer = fullFooter.toString();
    }

    @Override
    public boolean sendMessage(String msg, String receiver) {
        logger.info("Email message sent to {} with Message '{} {}'", receiver, msg, footer);
        return true;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getFooter() {
        return footer;
    }
}