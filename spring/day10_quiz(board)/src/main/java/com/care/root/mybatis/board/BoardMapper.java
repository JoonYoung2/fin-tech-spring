package com.care.root.mybatis.board;

import java.util.List;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardMapper {

	public void boardInsert(BoardDTO dto);
	
	public List<BoardDTO> boardList();

	public BoardDTO getBoardInfo(BoardDTO dto);

	public void hitUpdate(int writeNo);

	public void modifyNotImg(BoardDTO dto);

	public void modify(BoardDTO dto);

	public void delete(int writeNo);

	public BoardDTO getBoardInfoByWriteNo(int writeNo);

	public void replyInsert(BoardRepDTO dto);

	public List<BoardRepDTO> getReply(int writeNo);
}
