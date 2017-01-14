package com.example;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/services")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(HealthController.class);
      //  register(HomeController.class); not required
    }
}
