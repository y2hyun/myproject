package com.yang.spring.service;

import com.yang.spring.vo.user.UserVO;

public interface UserService {
	
	public UserVO getUser(String id, String password);
	
	public UserVO getUser(UserVO vo);
	
}
