package com.paravali.restapi.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.paravali.restapi.service.ParaValiService;

@Service
public class ParaValiServiceImpl implements ParaValiService {

	@Override
	public int validateParams(Map<String, Object> params) {
		return params.size();
	}

}
