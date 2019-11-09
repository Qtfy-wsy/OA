package com.oa.aop;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.oa.pojo.Param;
import com.oa.pojo.Role;
import com.oa.pojo.User;
import com.oa.pojo.vo.role_permission;


@Component
@Aspect
@Order(3)
public class permissionAop {
	@Around("execution(* com.oa.controller.*.delete*(..))||execution(* com.oa.controller.*.add*(..))||execution(* com.oa.controller.*.update*(..))")
	public Object permissionCheck(ProceedingJoinPoint joinPoint)throws Throwable {
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//拿到所有切入方法的参数
		Object[] obj=joinPoint.getArgs();
		for(int i=0;i<obj.length;i++) {
			if(Param.class.isInstance(obj[i])) {
				Param param=(Param)obj[i];
				//拿到权限操作所需权限id
				Integer permissionId=param.getPermissionId();
				if(permissionId!=null) {
					//获取session
					
					User loginUser=(User) request.getSession().getAttribute("loginUser");
					for(Role role:loginUser.getRoleList()) {
						for(role_permission rp:role.getRole_pid()) {
							if(rp.getPermissionId().equals(permissionId)) {
								return joinPoint.proceed();
							}
						}
					}
					throw new Exception("未授权操作！");
				}
			}
		}
		return null;
	}
	
}
