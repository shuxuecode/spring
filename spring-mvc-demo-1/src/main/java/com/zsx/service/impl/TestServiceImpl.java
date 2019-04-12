package com.zsx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zsx.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	private static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	@Override
	public String getName(String name) {
		
//		Integer.valueOf(name);
		try {
			LoggerFactory.getLogger(getClass()).debug("nihao");
			logger.info("123");
			Integer.valueOf(name);
		} catch (Exception e) {
//			System.out.println("出异常了，捕获到了");
//			System.out.println(e.toString());
			logger.error("日志打印出异常了");
			System.out.println(logger.getName());
			System.out.println(logger.getClass());
		}
		
		
		return name;
	}

}
