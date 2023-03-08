package com.epam.learn.initial.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("QA")
public class QADatasourceConfig implements ProfileConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(QADatasourceConfig.class);

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        LOGGER.info("Setting up datasource for QA environment.");
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(9000);
        return factory;
    }
}
