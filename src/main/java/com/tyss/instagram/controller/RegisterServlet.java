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

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersDao dao = new UsersDao();
		Users u = new Users();
		u.setName(req.getParameter("user_name"));
		u.setUsername(req.getParameter("user_username"));
		u.setPassword(Long.parseLong(req.getParameter("user_password")));
		u.setEmail(req.getParameter("user_email"));
		Users savedUser = dao.saveUsers(u);
		RequestDispatcher dispatcher = null;
		if (savedUser == null) {
			req.setAttribute("msg", "Unable To Save Users1...");
			dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.include(req, resp);
		} else {
			req.setAttribute("msg", "Users Saved Successfully...");
			dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.include(req, resp);
		}
	}
}
