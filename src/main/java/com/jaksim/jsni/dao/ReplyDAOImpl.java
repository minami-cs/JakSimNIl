package com.jaksim.jsni.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.jaksim.jsni.bean.Reply;

public class ReplyDAOImpl implements ReplyDAO {
	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	@Override
	public void insertReply(Reply reply) throws Exception {
		sqlSession.insert("mapper.reply.insertReply", reply);
	}

	@Override
	public List<Reply> queryReplies(int board_no) throws Exception {
		return sqlSession.selectList("mapper.replay.queryReplies", board_no);
	}

}
