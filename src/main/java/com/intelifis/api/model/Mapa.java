package com.intelifis.api.model;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = { "classpath:mapeamento.properties" }, ignoreResourceNotFound = false)
public class Mapa implements EnvironmentAware {

private static Environment env;

public static int getProperty(String key) {
    return Integer.valueOf(env.getProperty(key));
}

@Override
public void setEnvironment(Environment env) {
    Mapa.env = env;
}

}


/*
 * Aqui eu tento usar o Singleton */
 