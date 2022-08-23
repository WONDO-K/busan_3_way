package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Action;
import dao.MemberDao;
import vo.MemberVo;

public class UserLogin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String   path         =   "/user/userlogin.jsp";  
		request.getRequestDispatcher(path).forward(request, response);
	}

}
