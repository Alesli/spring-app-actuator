package com.epam.learn.initial.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CustomDataSourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomDataSourceConfig.class);

    @Value("${custom.datasource.url}")
    private String customUrl;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;


    @Bean
    public DataSource customDataSource() {
        var customDSBuilder = DataSourceBuilder.create();
        customDSBuilder.driverClassName(driver);
        customDSBuilder.url(customUrl);
        customDSBuilder.username(username);
        customDSBuilder.password(password);
        LOGGER.info("Initialing customDataSource bean!");
        return customDSBuilder.build();
    }

    @Bean
    @ConditionalOnMissingBean(name = "customDataSource")
    public DataSource dataSource() {
        var dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        LOGGER.info("Initialing default dataSource bean!");
        return dataSourceBuilder.build();
    }

}
