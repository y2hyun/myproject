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
		boardDAO.updateBoard(vo);
		
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.findBoardBySeq(vo.getSeq());
	}

	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList(null);
	}
	

}
