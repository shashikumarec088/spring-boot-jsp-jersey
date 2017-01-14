package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;

@Controller
@Path("/health")
public class HealthController {
    @GET
    @Produces("application/json")
    public String health() {
        return "test";
    }
    
}