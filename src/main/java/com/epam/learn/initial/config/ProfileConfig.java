package com.epam.learn.initial.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

public interface ProfileConfig {

    TomcatServletWebServerFactory tomcatFactory();
}
