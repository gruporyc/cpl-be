package co.cpl.service.impl;

import co.cpl.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Service to retrieve orchestrate all process related with searching feature
 *
 * @author jmunoz
 * @since 27/09/2018
 * @version 1.0
 */
@Component
public class HelloServiceImpl implements HelloService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(String name) {
        LOGGER.debug("Starting hello service");
        return "Hello " + name + " from orchestrator!";
    }
}
