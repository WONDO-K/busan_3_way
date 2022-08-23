package impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.MemberDao;
import dao.QnaDao;
import dao.ReviewBDao;
import vo.MemberVo;
import vo.QnaVo;
import vo.ReviewBVo;

public class UserGetMemberView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String member_id = request.getParameter("member_id");
		System.out.println("userLogin에서 넘어온 id : " + member_id);
		
		
		
		MemberDao memberDao = new MemberDao();
		MemberVo  memberVo  = memberDao.getMember(member_id);
		
		request.setAttribute("memberVo", memberVo);
		System.out.println("다음페이지에 넘어갈 개인회원정보 : " + memberVo);
		
		//----------------------------------------------------------------------
		
		QnaDao qnaDao = new QnaDao();
		ArrayList<QnaVo> getQList = new ArrayList<>();
		getQList = qnaDao.getQList();
		System.out.println("getQList : " + getQList);
		
		//----------------------------------------------------------------------
		
		ReviewBDao reviewBDao = new ReviewBDao();
		ArrayList<ReviewBVo> getRList = new ArrayList<>();
		getRList = reviewBDao.getRList();
		System.out.println("getRList : " + getRList);
		
		if(member_id.equals("admin")) {
			request.setAttribute("member_id", member_id);
			request.setAttribute("getQList", getQList);
			request.setAttribute("getRList", getRList);
			String   path         =   "/user/mypageadmin.jsp";  
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			request.setAttribute("member_id", member_id);
			request.setAttribute("getQList", getQList);
			request.setAttribute("getRList", getRList);
			
			String   path         =   "/user/mypageuser.jsp";  
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
