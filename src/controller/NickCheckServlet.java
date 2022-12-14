package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

@WebServlet("/nickcheckservlet")
public class NickCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NickCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String member_nick_name = request.getParameter("join_nickname");
		
		MemberDao memberDao = MemberDao.getInstance();
		
		int result = memberDao.confirmNickname(member_nick_name);
		
		request.setAttribute("member_nick_name", member_nick_name);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/view/nickCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
