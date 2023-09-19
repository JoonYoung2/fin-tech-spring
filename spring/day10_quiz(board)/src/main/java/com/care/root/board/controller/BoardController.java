package com.care.root.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("boardList/{num}")
	public String boardList(@PathVariable int num, Model model) {
		PageDTO page = new PageDTO();
		page.setStart(1);
		page.setEnd(3);

		model.addAttribute("list", service.boardList());
		model.addAttribute("start", page.getStart());
		model.addAttribute("end", page.getEnd());
		return "board/boardAllList";
	}
	
	@GetMapping("writeForm")
	public String boardForm() {
		return "board/writeForm";
	}
	
	@PostMapping("boardWrite.do")
	public String boardWrite(BoardDTO dto, Model model) {	
		service.boardInsert(dto);
		return "redirect:boardList/0";
	}
	
	@GetMapping("contentView")
	public String contentView(BoardDTO dto, Model model) {
		BoardDTO board = service.getBoardInfo(dto);
		List<BoardRepDTO> boardRep = service.getReply(dto.getWriteNo());
		
		model.addAttribute("rep", boardRep);
		model.addAttribute("dto", board);
		return "board/contentView";
	}
	
	@GetMapping("modify_form")
	public String modifyForm(BoardDTO dto, Model model) {
		BoardDTO board = service.getBoardInfo(dto);
		model.addAttribute("dto", board);
		return "board/modify_form";
	}
	
	@PostMapping("modify.do")
	public String modify(BoardDTO dto, Model model) {
		String msg = service.modify(dto);
		
		if(msg.equals("¼º°ø")) {
			return "redirect:contentView?writeNo="+dto.getWriteNo();			
		}
		
		model.addAttribute("msg", msg);
		return "redirect:modify_form?writeNo="+dto.getWriteNo();
	}
	
	@GetMapping("delete.do")
	public String delete(@RequestParam int writeNo) {
		service.delete(writeNo);
		return "redirect:boardList";
	}
	
	class PageDTO{
		private int start;
		private int end;
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
	}
}











