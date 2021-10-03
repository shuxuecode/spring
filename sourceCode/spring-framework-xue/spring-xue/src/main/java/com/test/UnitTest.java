package com.test;

import com.AppConfig;
import com.zsx.service.DemoService;
import com.zsx.service.TestService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UnitTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		// 注册bean配置类
		ac.register(AppConfig.class);
		// 刷新上下文
		ac.refresh();

		// todo mark

		DemoService demoService = ac.getBean(DemoService.class);
		System.out.println(demoService);
		DemoService demoService2 = ac.getBean(DemoService.class);
		System.out.println(demoService2);

//		System.out.println(ac.getBean(String.class));
		System.out.println(ac.getBean(TestService.class));
	}



}
