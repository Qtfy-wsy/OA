package com.oa.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class testAop {
//	@After("execution(* com.oa.controller.User*.getUser(..))")
//	public void test() {
//		System.out.println("获取用户controller执行了");
//	}
}
