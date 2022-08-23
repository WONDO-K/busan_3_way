package impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.QnaDao;
import vo.QnaVo;

public class UserQnaUdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int qna_idx = Integer.parseInt(request.getParameter("qna_idx"));
		System.out.println("updateview에서 넘어온 글 번호 : " + qna_idx);
		String member_id = request.getParameter("member_id");
		
		QnaVo qnaVo = new QnaVo();
		qnaVo.setQna_idx(qna_idx);
		qnaVo.setQna_title(request.getParameter("qna_jtile"));
		System.out.println("updateview에서 넘어온 글 제목 : " + request.getParameter("qna_jtile"));
		qnaVo.setQna_cont(request.getParameter("jcont"));
		System.out.println("updateview에서 넘어온 글 내용 : " + request.getParameter("jcont"));
		
		QnaDao qnaDao = new QnaDao();
		int result = qnaDao.boardUpdate(qnaVo);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>alert('수정되었습니다!');");
			out.println("location.href='/busanway?cmd=QNAVIEW&member_id=" + member_id +"&qna_idx=" + qna_idx + "';</script>");
			request.setAttribute("member_id", member_id);
		} else {
			out.println("<script>alert('수정 실패!');");
			out.println("location.href='/busanway?cmd=QNAVIEW&member_id=\" + member_id +\"&qna_idx=" + qna_idx + "';</script>");
		}
	}

}
