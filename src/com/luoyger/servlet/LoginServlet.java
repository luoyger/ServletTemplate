package com.luoyger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luoyger.entity.Admin;
import com.luoyger.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		LoginService loginService = new LoginService();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ((!username.trim().equals("")) && (!password.trim().equals(""))) {
			loginService.insertAdmin(username, password);
			List<Admin> adminList = loginService.displayAdminList();
			request.setAttribute("adminList", adminList);
			result = "Insert sucessfully.\n";
		}else{
			result = "Username or password is empty.\n";
		}
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("result", result);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		//response.sendRedirect("result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
