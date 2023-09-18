package com.care.root.board.service;

import java.util.List;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper dao;
	
	public void boardInsert(BoardDTO dto) {
		if(dto.getFile().isEmpty()) {
			dto.setImageFileName("nan");
		}else {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName=fo.format(new Date());
			sysFileName += dto.getFile().getOriginalFilename();
			File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
			try {
				dto.getFile().transferTo(saveFile);
				dto.setImageFileName(sysFileName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		dao.boardInsert(dto);
	}

	public List<BoardDTO> boardList() {
		return dao.boardList();
	}

	public BoardDTO getBoardInfo(BoardDTO dto) {
		dao.hitUpdate(dto.getWriteNo());
		return dao.getBoardInfo(dto);
	}

	public String modify(BoardDTO dto) {
		if(dto.getTitle() == null) {
			return "제목을 입력해주세요.";
		}else if(dto.getContent() == null) {
			return "내용을 입력해주세요.";
		}
		
		if(dto.getFile().isEmpty()) {
			dao.modifyNotImg(dto);
			return "성공";
		}else {
			BoardDTO img = dao.getBoardInfo(dto);
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName=fo.format(new Date());
			sysFileName += dto.getFile().getOriginalFilename();
			File deleteFile = new File(IMAGE_REPO+"/"+img.getImageFileName());
			File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
			try {
				deleteFile.delete();
				dto.getFile().transferTo(saveFile);
				dto.setImageFileName(sysFileName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		dao.modify(dto);
		return "성공";
	}

	public void delete(int writeNo) {
		BoardDTO dto = dao.getBoardInfoByWriteNo(writeNo);
		if(!dto.getImageFileName().equals("nan")) {
			File deleteFile = new File(IMAGE_REPO + "/" + dto.getImageFileName());
			deleteFile.delete();			
		}
		dao.delete(writeNo);
	}

	public String replyInsert(BoardRepDTO dto) {
		String msg = "";
		if(dto.getTitle() == null) {
			return "제목을 입력해주세요";
		}else if(dto.getContent() == null) {
			return "내용을 입력해주세요";
		}
		dao.replyInsert(dto);
		msg = "성공";
		return msg;
	}

	public List<BoardRepDTO> getReply(int writeNo) {
		return dao.getReply(writeNo);
	}

}
