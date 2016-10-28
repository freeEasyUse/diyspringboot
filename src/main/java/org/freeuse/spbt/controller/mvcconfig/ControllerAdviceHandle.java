package org.freeuse.spbt.controller.mvcconfig;

import javax.servlet.http.HttpServletRequest;

import org.freeuse.spbt.model.ExceptionModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(value = { "org.freeuse.spbt.controller" })
public class ControllerAdviceHandle {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	ExceptionModel handleControllerException(HttpServletRequest request,Throwable ex) {
		ExceptionModel emodel = new ExceptionModel();
		emodel.setMessage(ex.getMessage());
		emodel.setStatusCode(500);
		return emodel;
	}
}
