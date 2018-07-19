package me.dalek.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MysqlConnentTest {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/board?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String USERNAME = "study";
	private static final String PASSWORD = "study";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		try {
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println(con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
