package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bean.MemberDAO;
import com.java.bean.MemberDTO;
import com.java.bean.CreateDTO;

@WebServlet("/Create.do")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("ID");
		String pw = request.getParameter("passwd");
		
		CreateDTO rt = new CreateDTO();
		MemberDAO rd = new MemberDAO();
		
		rt.setCID(id);
		rt.setCPW(pw);
		
		int cnt = rd.insertProcess(rt);
		if(cnt == 1) {
			response.sendRedirect("project.jsp");
		}else {
			response.sendRedirect("signUp.jsp");
		}
	}

}
