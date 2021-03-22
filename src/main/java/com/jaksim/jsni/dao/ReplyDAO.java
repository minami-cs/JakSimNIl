package com.jaksim.jsni.dao;

import java.util.List;

import com.jaksim.jsni.bean.Reply;

public interface ReplyDAO {
	public void insertReply(Reply reply) throws Exception;
	public List<Reply> queryReplies(int board_no) throws Exception;
}
