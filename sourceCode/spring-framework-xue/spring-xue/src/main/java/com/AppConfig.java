package com;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 */

@Configuration
@ComponentScan("com.zsx")

// 开启事务
@EnableTransactionManagement
public class AppConfig {
}
