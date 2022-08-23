package impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.MemberDao;
import vo.MemberVo;

public class UsersMemberList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String member_id = request.getParameter("member_id");
		System.out.println("관리자 마이페이지에 넘어온 id : " + member_id);
		MemberDao memberDao = new MemberDao();
		int listCount = memberDao.getListCount();
		System.out.println("회원 수 : " + listCount);
		
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ArrayList<MemberVo> memberList = new ArrayList<MemberVo>();
		memberList = memberDao.getMemberList(page, limit);
		
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
		request.setAttribute("memberList", memberList);
		
		String   path         =   "/user/userlist.jsp";  
		request.getRequestDispatcher(path).forward(request, response);
	}

}
