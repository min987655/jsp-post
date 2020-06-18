package com.cos.apple.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.action.Action;

public class MemberJoinFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정석은 이동할 때 sendRedirect
		// blog는 주소값 남기지 않기 위해서 Dispatcher 사용
		response.sendRedirect("member/joinForm.jsp");
	}
}
