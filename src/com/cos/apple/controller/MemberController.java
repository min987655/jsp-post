package com.cos.apple.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.action.Action;
import com.cos.apple.action.member.MemberJoinFormAction;
import com.cos.apple.action.member.MemberJoinProcAction;
import com.cos.apple.action.member.MemberLoginFormAction;
import com.cos.apple.action.member.MemberLoginProcAction;
import com.cos.apple.action.member.MemberLogoutAction;
import com.cos.apple.action.member.MemberUpdateFormAction;
import com.cos.apple.action.member.MemberUpdateProcAction;
import com.cos.apple.action.post.PostListAction;

// http://localhost:8000/apple/member
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. request utf-8 셋팅 : web.xml 필터 등록 함
		// 2. response utf-8 셋팅 : 받을 때 무조건 utf-8 (blog는 인코딩 분기를 위해 Script에 등록)
		//    - setContentType(text/html) : 디폴트값, 바디에 들고가는 데이터 타입을 설명해주는 코드
		//    - setContentType 다른 타입 설명해 줄 때는 추가로 작성해주면 그만임.
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		
		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	private Action router(String cmd) {
		if(cmd.equals("joinForm")) {
			return new MemberJoinFormAction();
		} else if(cmd.equals("joinProc")) {
			return new MemberJoinProcAction();
		} else if(cmd.equals("loginForm")) {
			return new MemberLoginFormAction();
		} else if(cmd.equals("loginProc")) {
			return new MemberLoginProcAction();
		} else if(cmd.equals("updateForm")) {
			return new MemberUpdateFormAction();
		}  else if(cmd.equals("updateProc")) {
			return new MemberUpdateProcAction();
		}  else if(cmd.equals("logout")) {
			return new MemberLogoutAction();
		}
		return null;
	}
	
}
