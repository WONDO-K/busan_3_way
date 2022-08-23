package impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.QnaDao;
import vo.QnaVo;

public class UserQnaList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String member_id = request.getParameter("member_id");
		System.out.println("user메인에서 넘어온 id : " + member_id);
		QnaDao qnaDao = new QnaDao();
		int listCount = qnaDao.getListCount();
		System.out.println("Q&A 게시글 수 : " + listCount);
		
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ArrayList<QnaVo> qnaList = new ArrayList<>();
		qnaList = qnaDao.getQnaList(page, limit);
		
		int maxPage = (int) ((float)listCount / 10 + 0.95);
		int startPage = (((int)((float) page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = maxPage;
		if(endPage > startPage + 10 - 1) {
			endPage = startPage + 10 - 1;
		}
		
		request.setAttribute("member_id", member_id);
		System.out.println("Q&A리스트에 넘겨질 id : " + member_id);
		request.setAttribute("page", page); 			//현재 페이지 수
		request.setAttribute("maxPage", maxPage);		//최대 페이지 수
		request.setAttribute("startPage", startPage);	//현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("endPage", endPage);		//현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listCount", listCount);	//글의 개수
		request.setAttribute("qnaList", qnaList);
		
		if(member_id.equals("admin")) {
			String   path         =   "/user/qnaadmin.jsp";  
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			String   path         =   "/user/qnauser.jsp";  
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
