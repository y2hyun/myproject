package com.yang.spring.mock;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.spring.service.BoardService;
import com.yang.spring.service.UserService;
import com.yang.spring.vo.board.BoardVO;
import com.yang.spring.vo.user.UserVO;

public class BoardServiceClient {

	AbstractApplicationContext context = null;
	
	public BoardServiceClient() {
		this.context = new ClassPathXmlApplicationContext("com/yang/spring/config/applicationContext.xml");
	}
	
	public void insertBoard() {
		BoardService boardService = (BoardService)context.getBean("boardService");
		
		BoardVO data = new BoardVO();
		data.setTitle("test title2");
		data.setContent("test content2");
		data.setCreator("Yang");
		
		boardService.insertBoard(data);
	}
	
	public void listBoard() {
		BoardService boardService = (BoardService)context.getBean("boardService");
		
		List<BoardVO> list = boardService.getBoardList();
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	public void getUser(String id, String password) {
		UserService userService = (UserService)context.getBean("userService");
		UserVO user = userService.getUser(id, password);
		if(user == null) {
			System.out.println("login failed");
		} else {
			System.out.println(user);
		}
	}
		
	@Override
	protected void finalize() throws Throwable {
		this.context.close();
		super.finalize();
	}

	public static void main(String[] args) {
		BoardServiceClient client = new BoardServiceClient();
		// client.insertBoard();
		// client.listBoard();
		client.getUser("admin", "admin");
		
	}
}
