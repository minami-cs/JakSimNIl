package com.jaksim.jsni.bean;

public class BoardCriteria {
	private int page;
	private int pageNum;
	
	// 게시판 최초 진입 시 기본값
	public BoardCriteria() {
		this.page = 1;
		this.pageNum = 10;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		if(pageNum <= 0 || pageNum > 100) {
			this.pageNum = 10;
			return;
		}
		this.pageNum = pageNum;
	}
	// this.page가 1인 경우에는 0이 되어야 처음부터 10개씩 출력함
	public int getPageStart() {
		return (this.page - 1) * pageNum;
	}
	
	
}
