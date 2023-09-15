package com.care.root.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("boardList")
	public String boardList(Model model) {
		return "board/boardAllList";
	}
	
	@GetMapping("writeForm")
	public String boardForm() {
		return "board/writeForm";
	}
	
	@PostMapping("boardWrite.do")
	public String boardWrite(BoardDTO dto, Model model) {	
		service.boardInsert(dto);
		return "redirect:boardList";
	}
}











