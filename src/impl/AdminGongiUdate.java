package impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.GongiDao;
import dao.QnaDao;
import vo.GongiVo;
import vo.QnaVo;

public class AdminGongiUdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int notice_idx = Integer.parseInt(request.getParameter("notice_idx"));
		System.out.println("updateview에서 넘어온 글 번호 : " + notice_idx);
		String member_id = request.getParameter("member_id");
		
		GongiVo gongivo = new GongiVo();
		gongivo.setNotice_idx(notice_idx);
		gongivo.setNotice_title(request.getParameter("n_jtile"));
		System.out.println("updateview에서 넘어온 글 제목 : " + request.getParameter("n_jtile"));
		gongivo.setNotice_cont(request.getParameter("ncont"));
		System.out.println("updateview에서 넘어온 글 내용 : " + request.getParameter("ncont"));
		
		GongiDao gongiDao = new GongiDao();
		int result = gongiDao.boardUpdate(gongivo);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>alert('수정되었습니다!');");
			out.println("location.href='/busanway?cmd=GONGIVIEW&member_id=" + member_id +"&notice_idx=" + notice_idx + "';</script>");
			request.setAttribute("member_id", member_id);
		} else {
			out.println("<script>alert('수정 실패!');");
			out.println("location.href='/busanway?cmd=GONGIVIEW&member_id=" + member_id +"&notice_idx=" + notice_idx + "';</script>");
		}
	}

}
