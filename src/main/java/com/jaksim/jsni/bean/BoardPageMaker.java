package com.jaksim.jsni.bean;

public class BoardPageMaker {
	// 1페이지당 게시물 수
	public static final int numPerPage = 20;
	// 화면당 페이지 수
	public static final int pagePerView = 5;

	private int curPage;
	private int prev;
	private int next;
	private int totalPage;
	private int totalView;
	private int curView;
	private int prevView;
	private int nextView;

	private int pageStart;  //#{start}
	private int pageEnd;  //#{end}
	private int viewStart;
	private int viewEnd;

	public BoardPageMaker(int count, int curPage) {
		// 현재 페이지 번호
		curView = 1;
		this.curPage = curPage;
		// 전체 페이지 갯수
		setTotalPage(count);
		setPageRange();
		// 전체 페이지 블록 갯수
		setTotalView();
		// 블록 시작 페이지, 끝 페이지
		setViewRange();
	}

	public void setViewRange() {
		// 현재 페이지가 속한 블록, Math.ceil()함수는 소숫점 올림 계산 함수
		curView = (int) Math.ceil((curPage - 1) / pagePerView) + 1;
		// 현재 페이지가 속한 블록의 시작과 끝
		viewStart = (curView - 1) * pagePerView + 1;
		viewEnd = viewStart + pagePerView - 1;
		// 마지막 블록 범위 한정
		if (viewEnd > totalPage) viewEnd = totalPage;
		// 이전페이지, 다음페이지
		prev = (curPage == 1) ? 1 : (curView - 1) *  pagePerView;
		next = curView > totalView ? (curView * pagePerView) : (curView * pagePerView) + 1;
		// 마지막 페이지 범위 한정
		if (next >= totalPage) next = totalPage;
	}

	public void setPageRange() {
		// 시작페이지, 끝페이지
		pageStart = (curPage - 1) * numPerPage + 1;
		pageEnd = pageStart + numPerPage - 1;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int count) {
		totalPage = (int) Math.ceil(count * 1.0 / numPerPage);
	}

	public int getTotalView() {
		return totalView;
	}

	public void setTotalView() {
		// 페이지 번호 정수로 맞춰주기
		totalView = (int) Math.ceil(totalPage / pagePerView);
	}

	public int getCurView() {
		return curView;
	}

	public void setCurView(int curView) {
		this.curView = curView;
	}

	public int getPrevView() {
		return prevView;
	}

	public void setPrevView(int prevView) {
		this.prevView = prevView;
	}

	public int getNextView() {
		return nextView;
	}

	public void setNextView(int nextView) {
		this.nextView = nextView;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getViewStart() {
		return viewStart;
	}

	public void setViewStart(int viewStart) {
		this.viewStart = viewStart;
	}

	public int getViewEnd() {
		return viewEnd;
	}

	public void setViewEnd(int viewEnd) {
		this.viewEnd = viewEnd;
	}
}
