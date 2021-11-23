package com.julio.oliveira.controleDiabetes.controlador;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ControladorBase {
	//TODO COLOCAR ISSO NUM CONTROLADOR GERAL
	@Configuration
	public class WebConfiguration implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("*");
	    }  
	}
}
