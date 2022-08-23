package api.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.dao.StoreDao;
import api.vo.StoreVo;
import base.Action;

public class ViewDetailStore implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		String store_id = request.getParameter("store_id");
		System.out.println("userList: " + member_id);
		
		StoreDao storelDao = new StoreDao();
		StoreVo storeVo = storelDao.getDetailStore(store_id);
		
		request.setAttribute("member_id", member_id);
		request.setAttribute("storeVo", storeVo);
		
		String   path         =   "/user/detailmuks.jsp";  
		request.getRequestDispatcher(path).forward(request, response);
	}

}
