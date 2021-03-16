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
		endPage = (int) (Math.ceil(bc.getPage() / (double) displayPageNum) * displayPageNum);  // Math.ceil()함수는 소수점 이하 올림 함수
	}

}
