package com.jaksim.jsni.dao;

import java.util.List;

import com.jaksim.jsni.bean.Board;
import com.jaksim.jsni.bean.BoardCriteria;

public interface BoardDAO {
	public void insertArticle(Board article) throws Exception;
	public Board queryArticle(int board_no) throws Exception;
	public List<Board> queryArticles() throws Exception;
	public int listPaging(BoardCriteria bc) throws Exception;
}
