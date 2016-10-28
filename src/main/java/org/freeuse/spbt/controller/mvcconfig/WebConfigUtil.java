package org.freeuse.spbt.controller.mvcconfig;


import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.Ssl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfigUtil extends WebMvcConfigurerAdapter {
	
	
/*	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	    return new EmbeddedServletContainerCustomizer() {
	        @Override
	        public void customize(ConfigurableEmbeddedServletContainer container) {
	            Ssl ssl = new Ssl();
	            ssl.setKeyStore("classpath:keystore.jks");
	            ssl.setKeyStorePassword("123456");
	            container.setSsl(ssl);
	            container.setPort(8443);
	        }
	    };
	}*/
	
}
