package com.cos.apple.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.apple.action.Action;
import com.cos.apple.dao.PostDao;

public class PostSaveProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 세션값이 있으면 인증된 사용자
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			response.sendRedirect("member/loginForm.jsp");
			// 리턴 안해주면 두번 실행되어 오류남. 
			return;
		}		
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostDao postDao = new PostDao();
		int result = postDao.글쓰기(memberId, title, content);
		
		if (result == 1) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("post/saveForm.jsp");
		}
		
	}
}