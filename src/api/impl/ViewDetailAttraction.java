package api.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.dao.AttractionDao;
import api.vo.AttractionVo;
import base.Action;

public class ViewDetailAttraction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		String attraction_id = request.getParameter("attraction_id");
		System.out.println("userList: " + member_id);
		
		AttractionDao attractionDao = new AttractionDao();
		AttractionVo attractionVo = attractionDao.getDetailAttraction(attraction_id);
		
		request.setAttribute("member_id", member_id);
		request.setAttribute("attractionVo", attractionVo);

		String   path         =   "/user/detailbols.jsp";  
		request.getRequestDispatcher(path).forward(request, response);
	}

}
