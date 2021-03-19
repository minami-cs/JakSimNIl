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
import com.jaksim.jsni.bean.Member;
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
		//System.out.println(writerid);

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

	@RequestMapping(value = "/boarddetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView articledetail(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");
		try {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			int curPage = Integer.parseInt(request.getParameter("curPage"));
			// System.out.println(board_no);
			Board article = boardDao.queryArticle(board_no);
			if (article == null)
				throw new Exception();
			modelAndView.addObject("board_no", board_no);
			modelAndView.addObject("curPage", curPage);
			modelAndView.addObject("userId", userId);
			modelAndView.addObject("article", article);
			modelAndView.addObject("page", "board_detail");
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
			/*
			 * System.out.println(start); System.out.println(end);
			 * System.out.println(searchOption); System.out.println(keyword);
			 */
			List<Board> articles = boardDao.queryArticles(start, end, searchOption, keyword);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("articles", articles);
			map.put("count", count);
			map.put("searchOption", searchOption);
			map.put("keyword", keyword);
			map.put("boardPageMaker", boardPageMaker);
			modelAndView.addObject("map", map);
			//System.out.println(curPage);
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "게시판 오류");
			modelAndView.addObject("page", "err");
		}
		modelAndView.addObject("page", "board_list");
		modelAndView.setViewName("template");
		return modelAndView;
	}

	@RequestMapping(value = "/boardmodify", method = RequestMethod.GET)
	public String boardmodify(HttpServletRequest request, Model model) throws Exception {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		HttpSession session = request.getSession();
		session.setAttribute("board_no", board_no);
		Board article = boardDao.queryArticle(board_no);
		model.addAttribute("writer", article.getWriter());
		model.addAttribute("title", article.getTitle());
		model.addAttribute("category", article.getCategory());
		model.addAttribute("content", article.getContent());
		model.addAttribute("board_no", board_no);
		model.addAttribute("curPage", curPage);
		model.addAttribute("page", "board_modify_form");
		return "template";
	}
	
	@RequestMapping(value = "/boardmodify", method = RequestMethod.POST)
	public ModelAndView boardmodify(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		try {
			Board article = new Board();
			article.setCategory(request.getParameter("category"));
			article.setWriter(request.getParameter("writer"));
			article.setTitle(request.getParameter("title"));
			article.setContent(request.getParameter("content"));
			article.setJ_days(Integer.parseInt(request.getParameter("j_days")));
			article.setBoard_no(board_no);
			
			boardDao.modifyArticle(article);
			//System.out.println(curPage);
			modelAndView.addObject("board_no", board_no);
			modelAndView.addObject("curPage", curPage);
			modelAndView.setViewName("redirect:./boardlist");
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "수정 오류");
			modelAndView.addObject("page", "err");
			modelAndView.setViewName("template");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/boarddelete", method = RequestMethod.GET)
	public String boarddelete(HttpServletRequest request, Model model) throws Exception {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		System.out.println(board_no);
		boardDao.deleteArticle(board_no);
		return "redirect:./boardlist";
	}
}
