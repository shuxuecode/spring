package com.zsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
@Scope(value = "prototype") // 非单例，每次都会创建一个新对象
public class DemoService {

	@Autowired
	private TestService testService;

	public DemoService() {
		System.out.println("DemoService Constructor success");
	}


}
