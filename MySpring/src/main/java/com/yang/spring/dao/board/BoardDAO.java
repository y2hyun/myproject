package com.yang.spring.dao.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yang.spring.vo.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public class BoardRowMapper implements RowMapper<BoardVO> {

		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setCreator(rs.getString("creator"));
			board.setCreateDatetime(rs.getTimestamp("create_datetime"));
			board.setUpdater(rs.getString("updater"));
			board.setUpdateDatetime(rs.getTimestamp("update_datetime"));
			board.setVersion(rs.getInt("version"));
			
			return board;
		}
	}
	
	private int getNextSeq(String tableName, String seqColumnName) {
		final String sql = "SELECT ifnull(max(" + seqColumnName + "),0) +1 FROM " + tableName;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	
	public int insertBoard(BoardVO vo) {
		final String BOARD_INSERT = 
			"INSERT INTO board(seq, title, content, view_cnt, creator, create_datetime, updater, update_datetime)"
			+ "VALUES(?, ?, ?, 0, ?, ?, ?, ?)";
		
		Object[] args =	{
			this.getNextSeq("board", "seq"),
			vo.getTitle(),
			vo.getContent(),
			vo.getCreator(),
			new java.sql.Timestamp(new Date().getTime()),	
			vo.getUpdater(),
			new java.sql.Timestamp(new Date().getTime())
		};
		
		return jdbcTemplate.update(BOARD_INSERT, args);
	}
	
	public int updateBoard(BoardVO vo) {
		final String BOARD_UPDATE =
			"UPDATE board SET title=?, content=?, updater=?, update_datetime=?, version=version+1"
			+ "WHERE seq=?";
		
		Object[] args = {
			vo.getTitle(),
			vo.getContent(),
			vo.getUpdater(),
			new java.sql.Timestamp(new Date().getTime()),
			vo.getSeq()
		};
		
		return jdbcTemplate.update(BOARD_UPDATE, args);
	}
	
	public int deleteBoard(BoardVO vo) {
		final String BOARD_DELETE = 
			"DELETE FROM board WHERE seq=?";
		
		return jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO findBoardBySeq(int seq) {
		final String BOARD_GET = "SELECT * FROM board WHERE seq=?";
		
		return this.jdbcTemplate.queryForObject(BOARD_GET, new Object[] {seq}, new BoardRowMapper());
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		final String BOARD_LIST = "SELECT * FROM board WHERE del_flg = '0' ORDER by seq desc";	
		return this.jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

