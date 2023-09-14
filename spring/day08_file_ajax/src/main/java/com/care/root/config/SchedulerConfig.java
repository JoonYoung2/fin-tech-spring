package com.care.root.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.care.root.service.FileService;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {
//	@Autowired
//	private FileService fs;
//	@Scheduled(cron="*/10 * * * * *")
//	public void test01() {
//		System.out.println("10초마다 실행 : " + fs);
//	}
//	
//	@Scheduled(cron="0-59 * * * * *")
//	public void test02() {
//		System.out.println("=== 매 초 실행 ===");
//	}
}
