package com.yang.spring.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.yang.spring.common.JDBCUtil;
import com.yang.spring.vo.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String GET_USER = "SELECT * FROM users WHERE id=? AND password=? AND del_flg='0'";
	public UserVO getUser(UserVO vo) {
		
		UserVO user = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(GET_USER);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				user.setCreator(rs.getString("creator"));
				user.setCreateDatetime(rs.getTimestamp("create_datetime"));
				user.setUpdater(rs.getString("updater"));
				user.setUpdateDatetime(rs.getTimestamp("update_datetime"));
				user.setVersion(rs.getInt("version"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return user;
	}
}
