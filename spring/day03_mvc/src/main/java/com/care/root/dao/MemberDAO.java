package com.care.root.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.root.dto.MemberDTO;

@Repository
public class MemberDAO {
	public static ArrayList<MemberDTO> DB = new ArrayList<>();
	
	public void register(MemberDTO dto) {
		DB.add(dto);
	}
	
	public ArrayList<MemberDTO> getDb(){
		return DB;
	}
}
