package com.oa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
@Component
@Aspect
@Order(4)
public class ServiceExceptionAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExceptionAspect.class);
	@Pointcut("@within(org.springframework.stereotype.Service) && execution(public * *(..))")
	private void servicePointCut() {}
	//抛异常切面方法
	@AfterThrowing(pointcut="servicePointCut()", throwing="e")
	public void handle(JoinPoint joinPoint,Exception e) {
		LOGGER.error(e.getStackTrace().toString());
		String signature = joinPoint.getSignature().toString();
        String errorMsg = getMessage(signature) == null ? (StringUtils.isEmpty(e.getMessage()) ? "服务异常" : e.getMessage()) : getMessage(signature);
			try {
				throw new Exception(errorMsg,e);
			} catch (Exception e1) {
				LOGGER.error(e.getStackTrace().toString());
			}
	}
	private String getMessage(String signature) {
		return null;
	}
	
}
