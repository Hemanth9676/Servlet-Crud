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

@WebServlet(value = "/up")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         UsersDao dao = new UsersDao();
         Users u = dao.findUserById(Integer.parseInt(req.getParameter("id")));
        
         RequestDispatcher dispatcher = null;
         if(u==null) {
        	 req.setAttribute("msg", "Invalid User ID");
        	 dispatcher = req.getRequestDispatcher("index.jsp");
        	 dispatcher.forward(req, resp);
         }
         req.setAttribute("user", u);
         dispatcher = req.getRequestDispatcher("update.jsp");
         dispatcher.forward(req, resp);
	}

}
