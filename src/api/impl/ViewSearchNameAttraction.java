package api.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.dao.AttractionDao;
import api.vo.AttractionVo;
import base.Action;

public class ViewSearchNameAttraction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		String keyword = request.getParameter("keyword");
		System.out.println("keyword: " + keyword);
		
		AttractionDao attractionDao = new AttractionDao();
		int listAttractionNameCount = attractionDao.getAttractionNameCount(keyword);
		System.out.println("listAttractionNameCount : "+ listAttractionNameCount);
		int page = 1;
		int limit = 3000;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<AttractionVo> searchAttractionNameList = new ArrayList<>();
		searchAttractionNameList = attractionDao.getSearchAttractionNameList(page, limit, keyword);
		
		int maxPage = (int) ((float)listAttractionNameCount / 10 + 0.95);
		int startPage = (((int)((float) page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = maxPage;
		if(endPage > startPage + 10 - 1) {
			endPage = startPage + 10 - 1;
		}
		request.setAttribute("member_id", member_id);
		System.out.println("requestList : " + member_id);
		request.setAttribute("page", page); 			//현재 페이지 수
		request.setAttribute("maxPage", maxPage);		//최대 페이지 수
		request.setAttribute("startPage", startPage);	//현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("endPage", endPage);		//현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listAttractionNameCount", listAttractionNameCount);	//글의 개수
		request.setAttribute("searchAttractionNameList", searchAttractionNameList);
		
		String path = "/user/searchResult.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
