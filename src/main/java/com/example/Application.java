package com.example;

import java.util.concurrent.TimeUnit;

import org.apache.catalina.connector.Connector;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication

public class Application extends SpringBootServletInitializer{
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	
	private static final Logger LOGGER = Logger.getLogger(Application.class); 

    public static void main(String[] args) {  
        try{
        ApplicationContext ctx = SpringApplication.run(Application.class, args); 
        System.out.println(ctx);
        LOGGER.info("Spring Boot Beans:");
        LOGGER.info("Spring boot is ready");
        }catch(Exception e){
            LOGGER.error(e);
        }
    }
	    
    @Bean
    public EmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();

        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("maxKeepAliveRequests", "1");
                connector.setProperty("connectionTimeout", "20000");
                connector.setProperty("keepAliveTimeout", "1");
                connector.setProperty("maxThreads", "250");
                connector.setURIEncoding("UTF-8");
            }
        });
        // Set timeout for tomcat and custom error pages.
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        factory.setContextPath("/spring-boot");
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));
        return factory;
    }
}
