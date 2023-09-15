package com.care.root.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper dao;
	
	public void boardInsert(BoardDTO dto) {
		if(dto.getFile().isEmpty()) {
			dto.setImageFileName("nan");
		}else {
			
		}
		dao.boardInsert(dto);
	}

}
