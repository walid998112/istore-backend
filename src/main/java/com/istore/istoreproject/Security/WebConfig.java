package com.istore.istoreproject.Security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig implements WebMvcConfigurer {

    @SuppressWarnings("null")
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/content/**")
                .addResourceLocations(
                        "file:///C:/Users/Aymen%20Omri/Desktop/Fiverr/isotre/istore-project/target/classes/uploads/")
                .setCachePeriod(3600) // Cache static resources for one hour
                .resourceChain(true);

    }

}