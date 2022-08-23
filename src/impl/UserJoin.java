package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;

public class UserJoin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String   path         =   "/view/join.jsp";  
		request.getRequestDispatcher(path).forward(request, response);
	}

}
