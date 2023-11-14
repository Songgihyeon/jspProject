package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bean.CreateDTO;
import com.java.bean.MemberDAO;
import com.java.bean.RegisterDTO;

@WebServlet("/Insert.do")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		MemberDAO rd = new MemberDAO();
		
		try {
			ArrayList<RegisterDTO> memL = rd.selectMemberList();
			session.setAttribute("userList", memL);
			RequestDispatcher dis = request.getRequestDispatcher("/manager.jsp");
			dis.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
