package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.GongiDao;
import vo.GongiVo;


public class AdminGongiInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String member_id = request.getParameter("member_id");
		String gongi_title = request.getParameter("gtitle");
		String gongi_cont  = request.getParameter("gcontent");
		System.out.println("insert id: " + member_id);
		System.out.println("insert ti: " + gongi_title);
		System.out.println("insert co: " + gongi_cont);
		
		int result = 0;
		
		GongiDao GongiDao = new GongiDao();
		
		GongiVo gongiVo = new GongiVo();
		gongiVo.setNotice_member_id(request.getParameter("member_id").toString());
		gongiVo.setNotice_title(gongi_title);
		gongiVo.setNotice_cont(gongi_cont);
		
		//QnaVo qnaVo = new QnaVo(member_id, qna_title, qna_cont); 
		
		result = GongiDao.getGongiInsert(gongiVo);
		System.out.println("gvo : " + member_id);
		System.out.println("gvo : " + gongi_title);
		System.out.println("gvo : " + gongi_cont);
		if(result == 1) {
			request.setAttribute("member_id", member_id);
			request.setAttribute("gongi_title", gongi_title);
			request.setAttribute("gongi_cont", gongi_cont);
			System.out.println("requestin :" +member_id);
			System.out.println("requestin :" +gongi_title);
			System.out.println("requestin :" +gongi_cont);
		} else {
			
		}
		request.getRequestDispatcher("/busanway?cmd=GONGI&member_id="+member_id).forward(request, response);

	}

}
