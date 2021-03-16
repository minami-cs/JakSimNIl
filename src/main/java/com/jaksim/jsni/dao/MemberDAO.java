package com.jaksim.jsni.dao;

import com.jaksim.jsni.bean.Member;

public interface MemberDAO {
	public void insertMember(Member mem) throws Exception;
	public Member queryMember(String id) throws Exception;
}
