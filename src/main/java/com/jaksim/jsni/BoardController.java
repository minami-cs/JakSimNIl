package com.jaksim.jsni;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaksim.jsni.bean.Board;
import com.jaksim.jsni.bean.BoardPageMaker;
import com.jaksim.jsni.dao.BoardDAO;

@Controller
public class BoardController {
	BoardDAO boardDao;

	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
	public String boardwrite(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("writer", id);
		model.addAttribute("writer", id);
		model.addAttribute("page", "board_write_form");
		return "template";
	}

	@RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
	public ModelAndView boardwrite(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("writer", id);
		String writerid = (String) session.getAttribute("writer");
		System.out.println(writerid);

		try {
			Board article = new Board();
			article.setCategory(request.getParameter("category"));
			article.setWriter(writerid);
			article.setTitle(request.getParameter("title"));
			article.setContent(request.getParameter("content"));
			article.setJ_days(Integer.parseInt(request.getParameter("j_days")));
			boardDao.insertArticle(article);
			modelAndView.setViewName("redirect:./boardlist");
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "글쓰기 오류");
			modelAndView.addObject("page", "err");
			modelAndView.setViewName("template");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/articledetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView articledetail(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			int curPage = Integer.parseInt(request.getParameter("curPage"));
			// System.out.println(board_no);
			Board article = boardDao.queryArticle(board_no);
			if (article == null)
				throw new Exception();
			modelAndView.addObject("curPage", curPage);
			modelAndView.addObject("article", article);
			modelAndView.addObject("page", "article_view");
			boardDao.countHit(board_no);
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "오류");
			modelAndView.addObject("page", "err");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}

	@RequestMapping(value = "/boardlist", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView boardlist(@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		try {
			// 게시글 수 계산
			int count = boardDao.countArticle(searchOption, keyword);

			// 페이징
			BoardPageMaker boardPageMaker = new BoardPageMaker(count, curPage);
			int start = boardPageMaker.getPageStart();
			int end = boardPageMaker.getPageEnd();

			List<Board> articles = boardDao.queryArticles(start, end, searchOption, keyword);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("articles", articles);
			map.put("count", count);
			map.put("searchOption", searchOption);
			map.put("keyword", keyword);
			map.put("boardPageMaker", boardPageMaker);
			modelAndView.addObject("map", map);

		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "게시판 오류");
			modelAndView.addObject("page", "err");
		}
		modelAndView.addObject("page", "board_list");
		modelAndView.setViewName("template");
		return modelAndView;
	}
}
