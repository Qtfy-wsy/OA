package com.oa.aop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Component
@Aspect
@Order(2)
public class WebExceptionAspect {
	private static final Logger LOGGER=LoggerFactory.getLogger(WebExceptionAspect.class);
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void webPointCut() {}
	//抛出异常
	@AfterThrowing(pointcut="webPointCut()",throwing="e")
	public void handleThrowing(Exception e) {
		LOGGER.error(e.getStackTrace().toString());
		String errorMsg=StringUtils.isEmpty(e.getMessage()) ? "系统异常！" : e.getMessage();
		writeContent(errorMsg.trim().split("['\r''\n']")[0]);
	}
	//错误信息输出到浏览器
	private void writeContent(String content) {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setHeader("icop-content-type", "exception");
        PrintWriter writer=null;
        try {
        	writer=response.getWriter();
			writer.print(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
