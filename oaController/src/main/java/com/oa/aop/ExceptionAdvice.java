package com.oa.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ResponseBody
public class ExceptionAdvice {
	private static final Logger LOGGER=LoggerFactory.getLogger(ExceptionAdvice.class);
	/**
	 * 拦截web异常
	 * 目前只拦截exception
	 * @param e
	 * 异常对象
	 * @return 
	 * 异常提示
	 * */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		LOGGER.error(e.getStackTrace().toString());
		HttpHeaders headers=new HttpHeaders();
		headers.set("Content-type", "text/plain;charset=UTF-8");
		headers.add("icop-content-type", "exception");
		String message=StringUtils.isEmpty(e.getMessage()) ? "系统异常!" : e.getMessage();
		return new ResponseEntity<>(message,headers,HttpStatus.OK);
	}
}
