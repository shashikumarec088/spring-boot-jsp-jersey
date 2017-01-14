package com.example;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ApplicationPath("/services")
@Controller
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(HealthController.class);
      //  register(HomeController.class);
    }
}
