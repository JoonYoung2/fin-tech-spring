package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO ddd;
	
	public MemberService() {
		System.out.println("MemberService()");
	}
	
	public void test() {
		System.out.println("service test연동");
		ddd.test();
	}
}
