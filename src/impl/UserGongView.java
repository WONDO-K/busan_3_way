package impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Action;
import dao.GongiDao;
import vo.GongiVo;

public class UserGongView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int notice_idx = Integer.parseInt(request.getParameter("notice_idx"));
		System.out.println("공지리스트에서 넘어온 글번호 : " + notice_idx);
		String member_id = request.getParameter("member_id");
		System.out.println("공지리스트에서 넘어온 로그인 id : " + member_id);
		
		GongiDao gongiDao = new GongiDao();
		GongiVo  gongiVo  = gongiDao.getGongiDetail(notice_idx);
		if(!member_id.equals(gongiVo.getNotice_member_id())) {
			gongiDao.readCount(notice_idx);
		}
		System.out.println("공지 vo에 저장된 id : " + gongiVo.getNotice_member_id());
		gongiVo = gongiDao.getGongiDetail(notice_idx);
		request.setAttribute("member_id", member_id);
		request.setAttribute("gongiVo", gongiVo);
		
		if(member_id.equals("admin")) {
			String     path       =   "/view/gongiadminselect.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			String     path       =   "/view/gongiselect.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
