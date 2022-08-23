package impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.GongiDao;
import vo.GongiVo;

public class AdminGongiUdateView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int notice_idx = Integer.parseInt(request.getParameter("notice_idx"));
		String member_id = request.getParameter("member_id");
		System.out.println("확인 : " + notice_idx);
		System.out.println("확인 : " + member_id);
		
		GongiDao gongiDao = new GongiDao();
		boolean result = gongiDao.inGongiWriter(notice_idx, member_id);	//작성자 확인
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == false) {
			out.println("<script>alert('수정 권한이 없습니다!');");
			out.println("history.go(-1);</script>");
		} else {
			GongiVo  gongiVo  = gongiDao.getGongiDetail(notice_idx);
			request.setAttribute("gongiVo", gongiVo);
		}
		request.getRequestDispatcher("/view/gongiupdate.jsp").forward(request, response);
	}
}