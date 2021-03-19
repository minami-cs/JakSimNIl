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
	
	//게시글 작성
	@Override
	public void insertArticle(Board article) throws Exception {
		sqlSession.insert("mapper.board.insertArticle", article);
	}

	//게시글 1개 가져오기
	@Override
	public Board queryArticle(int board_no) throws Exception {
		return sqlSession.selectOne("mapper.board.selectArticle", board_no);
	}

	//게시판 목록
	@Override
	public List<Board> queryArticles(int start, int end, String searchOption, String keyword) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mapper.board.selectAllArticles", map);
	}

	//게시물 검색
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("mapper.board.countArticles", map);
	}

	//게시글 조회수
	@Override
	public void countHit(int board_no) throws Exception {
		sqlSession.update("mapper.board.updateHit", board_no);
	}

	//게시글 수정
	@Override
	public void modifyArticle(Board article) throws Exception {
		//System.out.println(article.getTitle());
		sqlSession.update("mapper.board.updateArticle", article);
	}

	//게시글 삭제
	@Override
	public void deleteArticle(int board_no) throws Exception {
		sqlSession.delete("mapper.board.deleteArticle", board_no);
	}

}
