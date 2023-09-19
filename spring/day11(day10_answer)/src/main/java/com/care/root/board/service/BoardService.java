package com.care.root.board.service;

import java.util.List;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardService {
	
	public String IMAGE_REPO = "D:\\fin_tech_spring\\spring_file_upload\\image_repo";

	public List<BoardDTO> boardAllList();

}
