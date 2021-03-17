package com.jaksim.jsni.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.jaksim.jsni.bean.Board;

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
	public List<Board> queryArticles(int start, int end, String searchOption, String keyword) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mapper.board.selectAllArticles", map);
	}

	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("mapper.board.countArticles", map);
	}

}
