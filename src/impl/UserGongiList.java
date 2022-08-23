package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Action;
import dao.GongiDao;
import dao.MemberDao;
import vo.GongiVo;
import vo.MemberVo;

public class UserGongiList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String member_id = request.getParameter("member_id");
		System.out.println("user메인에서 넘어온 id : " + member_id);
		GongiDao gongiDao = new GongiDao();
		int listCount = gongiDao.getListCount(); // 글의 총 개수
		System.out.println("공지게시글 수 : " + listCount);
		
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ArrayList<GongiVo> gongiList = new ArrayList<>();
		gongiList = gongiDao.getGongiList(page, limit); 
		
		int maxPage = (int) ((float)listCount / 10 + 0.95);
		int startPage = (((int)((float) page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = maxPage;
		if(endPage > startPage + 10 - 1) {
			endPage = startPage + 10 - 1;
		}
		
		request.setAttribute("member_id", member_id);
		System.out.println("공지리스트에 넘겨질 id : " + member_id);
		request.setAttribute("page", page); 			//현재 페이지 수
		request.setAttribute("maxPage", maxPage);		//최대 페이지 수
		request.setAttribute("startPage", startPage);	//현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("endPage", endPage);		//현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listCount", listCount);	//글의 개수
		request.setAttribute("gongiList", gongiList);	
		
		if(member_id.equals("admin")) {
			String   path         =   "/user/gongiadmin.jsp";  
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			String   path         =   "/user/gongiuser.jsp";  
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		/*
		 * MemberDao memberDao = new MemberDao(); MemberVo memberVo =
		 * memberDao.getMember(member_id); request.setAttribute("memberVo", memberVo);
		 */
		
		
	}

}
