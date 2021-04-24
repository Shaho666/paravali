package com.paravali.restapi.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Aspect
public class ParavaliAspect {
	
	@Around("execution(* com.paravali.restapi.controller.ParaValiController.validate(..))")
	@Validated
	public Map<String, Object> checkValidate(ProceedingJoinPoint joinPoint) {
		try {
			Object[] args = joinPoint.getArgs();
			if (args == null || args.length <= 0) {
				throw new Exception("args is null");
			}
			
			Map<?, ?> params = (Map<?, ?>) args[0];
			String id = (String) params.get("id");
			Integer value = (Integer) params.get("value");
			
			if (id == null || "".equals("")) {
				throw new Exception("id is null");
			}
			if (value == null || value < 0) {
				throw new Exception("value is invalid");
			}
			
			Map<String, Object> ret = new HashMap<String, Object>();
			Map<?, ?> result = (Map<?, ?>) joinPoint.proceed();
			for (Map.Entry<?, ?> entry : result.entrySet()) {
				ret.put((String) entry.getKey(), entry.getValue());
			}
			return ret;
		} catch (Throwable e) {
			e.printStackTrace();
			Map<String, Object> ret = new HashMap<String, Object>();
			ret.put("result", "error001");
			return ret;
		} 
	}
	
}
