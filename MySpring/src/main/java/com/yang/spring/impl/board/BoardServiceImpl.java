package com.yang.spring.impl.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.spring.dao.board.BoardDAO;
import com.yang.spring.service.BoardService;
import com.yang.spring.vo.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
		
	}

	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList(null);
	}
	

}
