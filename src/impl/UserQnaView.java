package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.QnaDao;
import vo.QnaVo;

public class UserQnaView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int qna_idx = Integer.parseInt(request.getParameter("qna_idx"));
		System.out.println("Q&A리스트에서 받아온 글번호 : " + qna_idx);
		String member_id = request.getParameter("member_id");
		System.out.println("Q&A리스트에서 넘어온 로그인 id : " + member_id);
		System.out.println(member_id);
		
		QnaDao qnaDao = new QnaDao();	
		QnaVo  qnaVo  = qnaDao.getQnaDetail(qna_idx);
		if(!member_id.equals(qnaVo.getQna_member_id())) {
			qnaDao.readCount(qna_idx);
		}
		System.out.println("Q&A vo에 저장된 id : " + qnaVo.getQna_member_id());
		qnaVo = qnaDao.getQnaDetail(qna_idx);
		request.setAttribute("member_id", member_id);
		request.setAttribute("qnaVo", qnaVo);
		
		String     path       =   "/view/qnaselect.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
