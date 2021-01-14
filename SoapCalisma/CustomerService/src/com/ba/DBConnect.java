package com.ba;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
    Connection con=null;

	
	public Connection serverConnect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb?seSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false","root","123456");
       
         
        } catch (Exception e) {
            System.out.println("inter.DBConnect.connect()"+e.getMessage());
        }
       return con;
    }

}
