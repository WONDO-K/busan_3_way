package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Action;
import dao.QnaDao;
import vo.QnaVo;

public class UserQnaInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String member_id = request.getParameter("member_id");
		String qna_title = request.getParameter("qtitle");
		String qna_cont  = request.getParameter("qcontent");
		System.out.println("insert id: " + member_id);
		System.out.println("insert ti: " + qna_title);
		System.out.println("insert co: " + qna_cont);
		
		int result = 0;
		
		QnaDao qnaDao = new QnaDao();
		
		QnaVo qnaVo = new QnaVo();
		qnaVo.setQna_member_id(request.getParameter("member_id").toString());
		qnaVo.setQna_title(qna_title);
		qnaVo.setQna_cont(qna_cont);
		
		//QnaVo qnaVo = new QnaVo(member_id, qna_title, qna_cont); 
		
		result = qnaDao.getQnaInsert(qnaVo);
		System.out.println("qvo : " + member_id);
		System.out.println("qvo : " + qna_title);
		System.out.println("qvo : " + qna_cont);
		if(result == 1) {
			request.setAttribute("member_id", member_id);
			request.setAttribute("qna_title", qna_title);
			request.setAttribute("qna_cont", qna_cont);
			System.out.println("requestin :" +member_id);
			System.out.println("requestin :" +qna_title);
			System.out.println("requestin :" +qna_cont);
		} else {
			
		}
		request.getRequestDispatcher("/busanway?cmd=QNA&member_id="+member_id).forward(request, response);
	}

}
