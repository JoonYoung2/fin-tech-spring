package com.care.root.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@GetMapping("boardAllList")
	public String boardAllList(Model model) {
		System.out.println("gdgd");
		model.addAttribute("list", bs.boardAllList());
		return "board/boardAllList";
	}
	
	
}











