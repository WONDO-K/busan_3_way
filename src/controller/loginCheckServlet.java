package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

@WebServlet("/logincheck")
public class loginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loginCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String   member_id  = request.getParameter("input_id");
		String   member_pwd = request.getParameter("input_pwd");
		String   url = "";
		
		System.out.println("로그인 id : " + member_id);
		System.out.println("로그인 pw : " + member_pwd);
		
		MemberVo member   = null;
				
		MemberDao memberDao = MemberDao.getInstance();
		int result = memberDao.idCheck(member_id, member_pwd);
		
		switch (result) {
		case 1: 
			member = memberDao.getMember(member_id);
			HttpSession session =  request.getSession();
			session.setAttribute("loginUser", member);
			System.out.println("로그인된 회원정보 : " + member);
			request.setAttribute("message", "로그인에 성공하였습니다.");
			url = "/busanway?cmd=USER";
			break;
		case 0:
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			url = "/start.jsp";
			break;
		case -1:
			request.setAttribute("message", "유저가 존재하지 않습니다.");
			url = "/start.jsp";
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
