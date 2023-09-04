package com.care.di04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationCAR.xml";
		GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);
		
		Car car = ctx.getBean("car", Car.class);
		System.out.println("main 실행");
		car.speed();
		System.out.println("--------------------");
		
		SubClass sc = new SubClass();
		sc.print();
	}
}
