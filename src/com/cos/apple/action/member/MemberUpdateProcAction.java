package com.cos.apple.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.apple.action.Action;
import com.cos.apple.dao.MemberDao;
import com.cos.apple.model.Member;

public class MemberUpdateProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.회원수정(id, username, password, email);
		
		// 회원수정은 그냥 업데이트만함. 
		// 업데이트 되면 다시 디비에 접근하여 회원정보를 찾음
		if (result ==1) {
			Member principal = memberDao.회원찾기(id);
				// 회원수정이 정상적으로 이루어지면 세션을 덮어쓰고 indxt로 돌아감.
				HttpSession session = request.getSession();
				session.setAttribute("principal", principal);
				response.sendRedirect("index.jsp");
	
		}else {
			response.sendRedirect("member/updateForm.jsp");
		}
		

	}
}
