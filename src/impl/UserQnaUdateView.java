package impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.QnaDao;
import vo.QnaVo;

public class UserQnaUdateView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int qna_idx = Integer.parseInt(request.getParameter("qna_idx"));
		String member_id = request.getParameter("member_id");
		System.out.println("확인 : " + qna_idx);
		System.out.println("확인 : " + member_id);
		
		QnaDao qnaDao = new QnaDao();
		boolean result = qnaDao.inQnaWriter(qna_idx, member_id);	//작성자 확인
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == false) {
			out.println("<script>alert('수정 권한이 없습니다!');");
			out.println("history.go(-1);</script>");
		} else {
			QnaVo  qnaVo  = qnaDao.getQnaDetail(qna_idx);
			request.setAttribute("qnaVo", qnaVo);
		}
		request.getRequestDispatcher("/view/qnaupdate.jsp").forward(request, response);
	}
}