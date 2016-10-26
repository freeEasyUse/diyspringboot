package org.freeuse.spbt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//日志文件记录
	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	
	@RequestMapping("/")
	public String index(){
		logger.info("我是info级别的日志：开始请求/路径");
		logger.debug("我是debug级别的日志：开始请求/路径");
		return "Greetings from Spring Boot!";
	}
	
	
}
