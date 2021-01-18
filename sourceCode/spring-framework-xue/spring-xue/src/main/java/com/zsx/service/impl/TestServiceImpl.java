package com.zsx.service.impl;

import com.zsx.service.TestService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TestServiceImpl implements TestService {
	@Override
	public void test() {
		System.out.println("TestServiceImpl test : " + UUID.randomUUID().toString());
	}
}
