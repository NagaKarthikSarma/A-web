package org.karthik;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	String str1= request.getParameter("uname");
	String str2= request.getParameter("passw");
	// request.setAttribute("uname",str1);
	 //request.setAttribute("passw",str2);
	//RequestDispatcher rd= request.getRequestDispatcher("Connector");
	//rd.forward(request, response);
	HttpSession session= request.getSession();
	session.setAttribute("uname",str1);
	session.setAttribute("passw",str2);
	response.sendRedirect("Connector");

	
	
	
	}
	

}
