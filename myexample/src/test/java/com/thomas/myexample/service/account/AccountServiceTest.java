package com.thomas.myexample.service.account;

import java.lang.reflect.ParameterizedType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class AccountServiceTest {
	
	
	@InjectMocks
	private AccountService  service;
	
	
	
	@Before  
	public void initMocks() {  
	    MockitoAnnotations.initMocks(this);  
	} 
	
	@Test
	public void test(){
//		Class entityClass =(Class) ((ParameterizedType) service.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//		System.out.println(entityClass);
		service = new AccountService();
	}
	
}
