package com.jaksim.jsni.dao;

import java.util.List;

import com.jaksim.jsni.bean.Board;

public interface BoardDAO {
	public void insertArticle(Board article) throws Exception;
	public Board queryArticle(int board_no) throws Exception;
	public List<Board> queryArticles(int start, int end, String searchOption, String keyword) throws Exception;
	public int countArticle(String searchOption, String keyword) throws Exception;
	public void countHit(int board_no) throws Exception;
}
