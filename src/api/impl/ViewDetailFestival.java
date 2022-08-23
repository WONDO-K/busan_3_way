package api.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.dao.FestivalDao;
import api.vo.FestivalVo;
import base.Action;

public class ViewDetailFestival implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		String festival_id = request.getParameter("festival_id");
		System.out.println("userList: " + member_id);
		
		FestivalDao festivalDao = new FestivalDao();
		FestivalVo festivalVo = festivalDao.getDetailFestival(festival_id);
		
		request.setAttribute("member_id", member_id);
		request.setAttribute("festivalVo", festivalVo);
		
		/*
		 * request.setAttribute("festival_id", festivalVo.getFestival_id());
		 * request.setAttribute("festival_name", festivalVo.getFestival_name());
		 * request.setAttribute("festival_gugun", festivalVo.getFestival_gugun());
		 * request.setAttribute("festival_place", festivalVo.getFestival_place());
		 * request.setAttribute("festival_title", festivalVo.getFestival_title());
		 * request.setAttribute("festival_subtitle", festivalVo.getFestival_subtitle());
		 * request.setAttribute("festival_main_place",
		 * festivalVo.getFestival_main_place()); request.setAttribute("festival_addr1",
		 * festivalVo.getFestival_addr1()); request.setAttribute("festival_addr2",
		 * festivalVo.getFestival_addr2()); request.setAttribute("festival_tel",
		 * festivalVo.getFestival_tel()); request.setAttribute("festival_site",
		 * festivalVo.getFestival_site()); request.setAttribute("festival_trfc_info",
		 * festivalVo.getFestival_trfc_info());
		 * request.setAttribute("festival_usageday", festivalVo.getFestival_usageday());
		 * request.setAttribute("festival_time", festivalVo.getFestival_time());
		 * request.setAttribute("festival_usage_amount",
		 * festivalVo.getFestival_usage_amount()); request.setAttribute("festival_img",
		 * festivalVo.getFestival_img()); request.setAttribute("festival_thumb",
		 * festivalVo.getFestival_thumb()); request.setAttribute("festival_cont",
		 * festivalVo.getFestival_cont()); request.setAttribute("festival_convenient",
		 * festivalVo.getFesitval_convenient()); request.setAttribute("festival_good",
		 * festivalVo.getFestival_good()); request.setAttribute("festival_bad",
		 * festivalVo.getFestival_bad());
		 */
		
		String   path         =   "/user/detailnols.jsp";  
		request.getRequestDispatcher(path).forward(request, response);
	}

}
