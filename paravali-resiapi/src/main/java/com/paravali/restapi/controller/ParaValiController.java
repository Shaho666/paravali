package com.paravali.restapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paravali")
public class ParaValiController {
	
	@PostMapping("/validation")
	public Map<String, Object> validate(@RequestBody Map<String, Object> params) {
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("result", "success");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("result", "error");
			return result;
		}
	}
	
}
