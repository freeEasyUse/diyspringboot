package org.freeuse.spbt.controller.webCommon;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@Configuration
public class WebConfigUtil extends WebMvcConfigurerAdapter {
	@Bean  
    public ServerEndpointExporter serverEndpointExporter (){  
        return new ServerEndpointExporter();  
    } 
}
