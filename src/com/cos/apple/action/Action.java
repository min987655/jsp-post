package com.cos.apple.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 인터페이스(추상메서드)
// execute 사용 편의
// 
public interface Action {
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}