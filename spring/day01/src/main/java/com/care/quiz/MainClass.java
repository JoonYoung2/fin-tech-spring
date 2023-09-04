package com.care.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationQUIZ.xml";
		GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);
		SaveClass save = ctx.getBean("save", SaveClass.class);
		save.operationClass();
		save.printClass();
	}
}
