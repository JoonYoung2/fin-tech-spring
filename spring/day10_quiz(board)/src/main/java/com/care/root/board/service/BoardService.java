package com.care.root.board.service;

import java.util.List;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardService {
	
	public String IMAGE_REPO = "D:\\fin_tech_spring\\spring_file_upload\\image_repo";
	
	public void boardInsert(BoardDTO dto);
	
	public List<BoardDTO> boardList();

	public BoardDTO getBoardInfo(BoardDTO dto);

	public String modify(BoardDTO dto);

	public void delete(int writeNo);

	public String replyInsert(BoardRepDTO dto);

	public List<BoardRepDTO> getReply(int writeNo);

}
