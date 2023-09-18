package com.care.root.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.board.service.BoardService;

@Controller
public class BoardRepController {
	
	@Autowired
	private BoardService service;
	
	@PostMapping("reply.do")
	public String replyDo(BoardRepDTO dto, Model model) {
		String msg = service.replyInsert(dto);
		if(msg.equals("¼º°ø")) {
			return "redirect:contentView?writeNo="+dto.getWrite_group();			
		}else {
			
			BoardDTO boardDto = new BoardDTO();
			boardDto.setWriteNo(dto.getWrite_group());
			BoardDTO board = service.getBoardInfo(boardDto);
			
			model.addAttribute("msg", msg);
			model.addAttribute("dto", board);
			return "board/contentView";
		}
	}
}
