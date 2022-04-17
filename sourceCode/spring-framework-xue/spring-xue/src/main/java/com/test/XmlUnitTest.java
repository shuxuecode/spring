package com.test;

import com.zsx.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileUrlResource;

import java.util.ResourceBundle;

/**
 * @date 2022/4/7
 */
public class XmlUnitTest {

	public static void main(String[] args) {

		//ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();

		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//
		//context.scan("com.zsx");
		//
		//
		//context.refresh();
		//
		//
		//TestService bean = context.getBean(TestService.class);
		//
		//System.out.println(bean);



		//PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		//configurer.setLocations(new ClassPathResource("application.properties"));
		//PropertySources propertySources = configurer.getAppliedPropertySources();
		//System.out.println(propertySources.contains("name"));


		ResourceBundle bundle = ResourceBundle.getBundle("application.properties");
		System.out.println(bundle.containsKey("name"));
// todo zsx


	}



}
