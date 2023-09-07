package com.care.root;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;

/*
 * junit : test�� �����ϱ� ���� �����ӿ�ũ(��ɵ��� ����)
 * �׽�Ʈ �ֵ� ����. 
 * �׽�Ʈ�� �ְ� �Ǹ� �⺻ �ڵ带 �ۼ��� �� ��ġ�� ������ �����ϰ� ����� ���� ����. 
 * �ڵ� �ۼ� �� �׽�Ʈ �ϱ� ���ؼ��� ������ �����ؾ� ��. �ڵ尡 Ŀ�� ���� �������� ó���� ���� �������� ��������. 
 * �̰� ������ �����ϴ� ���� �ƴ϶� ó�� �ӵ��� ����.
 * 
 * �׽�Ʈ ���� (����, ����)
 * ���� = �������� ��� ���� Ȯ��.
 * ���� = �����׽�Ʈ �� ����� ����������, ���������� �׽�Ʈ �ϴ� ��.
 * 
 * �׽�Ʈ ������ ���ؼ��� ���̺귯���� �ʿ���.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration( locations = {"classpath:testMember.xml"} )
public class TestMember {
	@Autowired
	MemberController mc;
	@Test
	public void testMc() {
		System.out.println(mc);
		assertNotNull(mc);
	}
}
