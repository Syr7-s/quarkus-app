package com.syrisa.quarkus.util;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingUtil {
    @ConfigProperty(name = "greeting.name",defaultValue = "Students")
    String greetingName;

    public String getGreetingName(){
        return "Hello "+ greetingName;
    }
}
