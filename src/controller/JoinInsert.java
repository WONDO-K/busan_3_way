package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

@WebServlet("/joininsert")
public class JoinInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        request.setCharacterEncoding("UTF-8");
		
		String member_id        =request.getParameter("join_id");
		String member_pwd       =request.getParameter("join_pw");
		String member_name      =request.getParameter("join_name");
		String member_birth     =request.getParameter("join_birth");
		String member_nick_name =request.getParameter("join_nickname");
		String member_email     =request.getParameter("join_email");
		String member_tel       =request.getParameter("join_tel");
		String member_addr      =request.getParameter("join_address");
		
		int result = 0;
		
		MemberDao memberDao = MemberDao.getInstance();
		
		MemberVo memberVo = new MemberVo();
		memberVo.setMember_id(member_id);
		memberVo.setMember_pwd(member_pwd);
		memberVo.setMember_name(member_name);
		memberVo.setMember_birth(member_birth);
		memberVo.setMember_nick_name(member_nick_name);
		memberVo.setMember_email(member_email);
		memberVo.setMember_tel(member_tel);
		memberVo.setMember_addr(member_addr);
		
		result = memberDao.insertMember(memberVo);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("member_id", member_id);
			request.setAttribute("message", "회원 가입 성공");
		}else {
			request.setAttribute("message", "회원 가입 실패");
		}
		request.getRequestDispatcher("/busanway?cmd=JOININSERT").forward(request, response);
	}

}
