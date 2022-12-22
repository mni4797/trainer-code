package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//instead of listing all our beans, we're telling spring to look for them
// the @componentscan tells spring the root package where it can begin looking
// for classes with the @component annotation
@Configuration
@ComponentScan("com.revature")
@PropertySource("classpath:app.properties")
public class AppConfig {
    // @PropertySource tells spring to look into the app.properties file in case it
    // wants to
    // inject a property
}
