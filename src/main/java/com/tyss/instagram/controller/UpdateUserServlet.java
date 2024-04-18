package com.tyss.instagram.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.instagram.entity.Users;
import com.tyss.userapp.dao.UsersDao;
@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UsersDao dao = new UsersDao();
		
		int id = Integer.parseInt(req.getParameter("id"));
		Users u = dao.findUserById(id);
		u.setId(id);
		u.setName(req.getParameter("user_name"));
		u.setUsername(req.getParameter("user_username"));
		u.setPassword(Long.parseLong(req.getParameter("user_password")));
		u.setEmail(req.getParameter("user_email"));
		
		Users u1 = dao.updateUser(u);
	
		req.setAttribute("msg", "User Updated Successfully...");
		RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	}
	
}
