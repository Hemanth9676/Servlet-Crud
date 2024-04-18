package com.tyss.instagram.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.instagram.entity.Users;
import com.tyss.userapp.dao.UsersDao;

@WebServlet(value = "/fetchall")
public class FetchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		      UsersDao dao = new UsersDao();
		      List<Users> users = dao.findAllUsers();
		      
		      RequestDispatcher dispatcher = null;
		      if(users.isEmpty()) {
		    	  dispatcher = req.getRequestDispatcher("index.jsp");
		    	  req.setAttribute("msg", "No Users Present In Database...");
		    	  dispatcher.forward(req, resp);
		      }
		      req.setAttribute("users", users);
		      dispatcher = req.getRequestDispatcher("allusers.jsp");
		      dispatcher.forward(req, resp);
	}

}
