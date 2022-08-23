package impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.QnaDao;
import vo.QnaVo;

public class UserQnaDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int qna_idx = Integer.parseInt(request.getParameter("qna_idx"));
		System.out.println("조회하면에서 넘어온 삭제 글번호 : " + qna_idx);
		String member_id = request.getParameter("member_id");
		System.out.println("조회하면에서 넘어온 삭제 id : " + qna_idx);
		
		QnaDao qnaDao = new QnaDao();
		boolean result = qnaDao.inQnaWriter(qna_idx, member_id);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(member_id.equals("admin") || result == true) {
			int succ = qnaDao.boardDelete(qna_idx);
			if(succ > 0) {
				out.println("<script>alert('삭제되었습니다!');");
				out.println("location.href='/busanway?cmd=QNA&member_id=" + member_id + "';</script>");
			} else {
				out.println("<script>alert('삭제 실패!');");
				out.println("location.href='/busanway?cmd=QNA&member_id=" + member_id + "';</script>");
			}
		} else if(!member_id.equals("admin") && result == false) {
			out.println("<script>alert('삭제 권한이 없습니다!');");
			//out.println("location.href='boardDetailAction.bo?board_num=" + board_num + "';</script>"); 작동은 되지만 조회수가 올라가서 적절치 않다.
			out.println("history.go(-1);</script>");
		}		
	}

}
