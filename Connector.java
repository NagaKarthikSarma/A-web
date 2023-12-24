package org.karthik;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Connector
 */
@WebServlet("/Connector")
public class Connector extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//String str1= (String) request.getAttribute("uname");
		//String str2=(String) request.getAttribute("passw");
		
		
		HttpSession session= request.getSession();
		String unames = (String) session.getAttribute("uname");
		String passwo= (String) session.getAttribute("passw");
		 out.println("<html><body>");
		String url="jdbc:mysql://localhost:3306/karthiksarma?useSSL=false";
		String uname="root";
		String pass="D@ngereag1e";
	   
		String query1 = "select * from login" ;
		Connection con=null;
		Statement st=null;
		ResultSet rs1=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);
            st = con.createStatement();
            rs1 = st.executeQuery(query1);

         

		while (rs1.next()) {
		    String password = rs1.getString("pass");
		    
		    String username=rs1.getString("uname");
		    out.println(username +":"  + password);
		}
		    
   
		}
		catch(Exception e){
			out.println("hee");
		}

		finally {
		    try {
		        if (rs1 != null) {
		            rs1.close();
		        }
		        if (st != null) {
		            st.close();
		        }
		        if (con != null) {
		            con.close();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		out.println("hii");
		
		  out.println("</body></html>");

	        // Flush the PrintWriter
	        out.flush();
		
	}

}
