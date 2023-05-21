package com.learn.interview.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class DatabaseTestUtils {

	private static String URL = "amRiYzptYXJpYWRiOi8vbXlzcWwtc2VydmljZS1vcmRlcjozMzA2L29yZGVyZGI/dXNlU1NMPWZhbHNlJm1heF9hbGxvd2VkX3BhY2tldD0xNTcyODY0MAo=";
	private static String USER = "cpandey";
	private static String PASSWORD = "chandan@1234";
	private static String DB = "orderdb";
	
	private static String DRIVER_NAME="org.mariadb.jdbc.Driver";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	  	Class.forName(DRIVER_NAME);
	  	String urlChars = new String(Base64.getDecoder().decode(URL));
	  	System.out.println(urlChars);
	  	System.out.println();
	  	URL="jdbc:mariadb://localhost:30011/orderdb?useSSL=false&max_allowed_packet=15728640";
	  	Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
	  	PreparedStatement rs=  connection.prepareStatement("show databases");
	  	boolean bool =  rs.execute();
	  	System.out.println(bool);
	  	
	}
	
	
	public static String encode() {
		String strToEncode =  "jdbc:mariadb://localhost:330011/orderdb?useSSL=false&max_allowed_packet=15728640";
		String str = new String(Base64.getEncoder().encode(strToEncode.getBytes()));
		System.out.println(str);
		return str;
	}
	
	
}
