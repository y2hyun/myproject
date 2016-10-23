package com.yang.spring.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.spring.dao.user.UserDAO;
import com.yang.spring.service.UserService;
import com.yang.spring.vo.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	public UserVO getUser(String id, String password) {
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		return getUser(vo);
	}
}
