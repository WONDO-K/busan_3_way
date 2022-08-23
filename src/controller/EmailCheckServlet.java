package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

@WebServlet("/emailcheckservlet")
public class EmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String member_email = request.getParameter("join_email");
		
		MemberDao memberDao = MemberDao.getInstance();
		
		int result = memberDao.confirmEmail(member_email);
		
		request.setAttribute("member_email", member_email);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/view/emailCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
