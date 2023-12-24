package org.karthik;
import java.sql.*;


public class Jdbc {
public String Sql() throws SQLException {
	String url="jdbc:mysql://localhost:3306/karthiksarma";
	String uname="root";
	String pass="D@ngereag1e";
	String query1 = "select * from login";
	
		Connection con= DriverManager.getConnection(url,uname,pass);
		Statement st= con.createStatement();
	
	
		int count=st.executeUpdate(query1);
	     System.out.println(count+"rows affected");    
    

	

		ResultSet rs1=st.executeQuery(query1);


		    String password = rs1.getString("passw");
		    
		    String username=rs1.getString("uname");
		
return (username +":"  + password);

}
	
	
}

