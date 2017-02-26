package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
@Path("/health")
public class HealthController {
	
	@Autowired
	DAOClass daoClass;
    @GET
    @Produces("application/json")
    public String health() {
    	daoClass.saveProduct();
        return "test";
    }
    
}