package org.karthik;
import java.sql.*;
public class Demojdbc {


	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url="jdbc:mysql://localhost:3306/karthiksarma?useSSL=false";
		String uname="root";
		String pass="D@ngereag1e";
	    String user="000";
	    String passw="9";
		String query1 = "select * from login" ;
		
		Class.forName("com.mysql.cj.jdbc.Driver");//optional for >=jdbc 4.0
			//automatically loaded by the connector
			Connection con= DriverManager.getConnection(url,uname,pass);
			PreparedStatement st= con.prepareStatement(query1);
		
		
		
			ResultSet rs1=st.executeQuery();
		   System.out.println(rs1);
	    

			while (rs1.next()) {
			    String password = rs1.getString("pass");
			    
			    String username=rs1.getString("uname");
			    System.out.println(username +":"  + password);
			}
			    

			st.close();
			con.close();
			

		}

	}


