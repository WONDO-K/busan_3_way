package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import dao.ReviewBDao;
import vo.ReviewBVo;


public class UserReviewInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String member_id     = request.getParameter("member_id");
		String attraction_id = request.getParameter("attraction_id");
		String review_cont = request.getParameter("rtitle");
		int score  = Integer.parseInt(request.getParameter("rating"));
		System.out.println("insert id: " + member_id);
		System.out.println("insert id: " + attraction_id);
		System.out.println("insert ti: " + review_cont);
		System.out.println("insert co: " + score);
		
		int result = 0;
		
		ReviewBDao reviewBDao = new ReviewBDao();
		
		ReviewBVo reviewBVo = new ReviewBVo();
		reviewBVo.setMem_id(request.getParameter("member_id").toString());
		reviewBVo.setAttraction_id(request.getParameter("attraction_id").toString());
		reviewBVo.setR_cont(review_cont);
		reviewBVo.setScore(score);
		
		//QnaVo qnaVo = new QnaVo(member_id, qna_title, qna_cont); 
		
		result = reviewBDao.getReviewInsert(reviewBVo);
		System.out.println("qvo : " + member_id);
		System.out.println("qvo : " + attraction_id);
		System.out.println("qvo : " + review_cont);
		System.out.println("qvo : " + score);
		if(result == 1) {
			request.setAttribute("member_id", member_id);
			request.setAttribute("attraction_id", attraction_id);
			request.setAttribute("review_cont", review_cont);
			request.setAttribute("score", score);
			System.out.println("requestin :" +member_id);
			System.out.println("requestin :" +attraction_id);
			System.out.println("requestin :" +review_cont);
			System.out.println("requestin :" +score);
		} else {
			
		}
		request.getRequestDispatcher("/busanway?cmd=REVIEW&attraction_id="+attraction_id+"&member_id="+member_id).forward(request, response);
	}

}
