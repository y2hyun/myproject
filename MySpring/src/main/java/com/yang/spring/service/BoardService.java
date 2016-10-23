package com.yang.spring.service;

import java.util.List;

import com.yang.spring.vo.board.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO vo);
	
	void updateBoard(BoardVO vo);
	
	void deleteBoard(BoardVO vo);
	
	BoardVO getBoard(BoardVO vo);
	
	List<BoardVO> getBoardList();
}
