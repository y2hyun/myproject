package com.yang.spring.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yang.spring.common.JDBCUtil;
import com.yang.spring.vo.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private int getNextSeq(String tableName, String seqColumnName) {
		Connection l_conn = null;
		PreparedStatement l_pstmt = null;
		ResultSet l_rs = null;
		try {
			final String sql = "SELECT ifnull(max(" + seqColumnName + "),0) +1 FROM " + tableName;
			l_conn = JDBCUtil.getConnection();
			l_pstmt = l_conn.prepareStatement(sql);
			l_rs = l_pstmt.executeQuery();
			while(l_rs.next()) {
				return l_rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(l_conn, l_pstmt, l_rs);
		}
		
		return 1;
	}
	
	
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, content, view_cnt, creator, create_datetime, updater, update_datetime)" +
	"VALUES(?, ?, ?, 0, ?, ?, ?, ?)";
	
	public int insertBoard(BoardVO vo) {
		
		System.out.println("===> JDBC insertBoard() Start");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setInt(1, getNextSeq("board", "seq"));
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getCreator());
			pstmt.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
			pstmt.setString(6, vo.getCreator());
			pstmt.setTimestamp(7, new java.sql.Timestamp(new Date().getTime()));
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return 0;
	}
	
	private final String BOARD_LIST = "SELECT * FROM board WHERE del_flg = '0' ORDER by seq desc";
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC getBoardList() Start");
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setSeq(rs.getInt("seq"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setViewCnt(rs.getInt("view_cnt"));
				data.setCreator(rs.getString("creator"));
				data.setCreateDatetime(rs.getTimestamp("create_datetime"));
				data.setUpdater(rs.getString("updater"));
				data.setUpdateDatetime(rs.getTimestamp("update_datetime"));
				data.setVersion(rs.getInt("version"));
				list.add(data);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
}
