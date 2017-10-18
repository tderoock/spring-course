package be.ordina.spring.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IncrementServiceImpl implements IncrementService {

    private static final Logger logger = LoggerFactory.getLogger(IncrementServiceImpl.class);

    private int increment;

    @Override
    public void increment() {
        increment++;
    }

    @Override
    public void printValue() {
        logger.info("The value of the increment is {}", increment);
    }
}
