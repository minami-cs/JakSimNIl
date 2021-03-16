package com.jaksim.jsni.bean;

public class BoardPageMaker {
	private int totalCount;

	private int startPage;
	private int endPage;

	private boolean prev;
	private boolean next;

	private int displayPageNum = 10;

	private BoardCriteria bc;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		CalcData();
	}

	private void CalcData() {
		endPage = (int) (Math.ceil(bc.getPage() / (double) displayPageNum) * displayPageNum); // Math.ceil()함수는 소수점 이하
																								// 올림 함수
		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalCount / (double) bc.getPageNum()));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;
		next = endPage * bc.getPageNum() >= totalCount ? false : true;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public BoardCriteria getBc() {
		return bc;
	}

	public void setBc(BoardCriteria bc) {
		this.bc = bc;
	}
}
