package com.tyss.instagram.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.userapp.dao.UsersDao;
@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersDao dao = new UsersDao();
		dao.deleteAllUsers();
		RequestDispatcher d = req.getRequestDispatcher("home.jsp");
		req.setAttribute("msg","All Users Deleted Successfully...");
		d.forward(req, resp);
	}
}
