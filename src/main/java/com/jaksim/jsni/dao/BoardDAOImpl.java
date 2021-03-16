package com.jaksim.jsni.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.jaksim.jsni.bean.Board;
import com.jaksim.jsni.bean.BoardCriteria;

public class BoardDAOImpl implements BoardDAO {
	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertArticle(Board article) throws Exception {
		sqlSession.insert("mapper.board.insertArticle", article);
	}

	@Override
	public Board queryArticle(int board_no) throws Exception {
		return sqlSession.selectOne("mapper.board.selectArticle", board_no);
	}

	@Override
	public List<Board> queryArticles() throws Exception {
		return sqlSession.selectList("mapper.board.selectAllArticles");
	}

	@Override
	public int listPaging(BoardCriteria bc) throws Exception {
		return sqlSession.selectOne("mapper.board.selectListPage");
	}

}
