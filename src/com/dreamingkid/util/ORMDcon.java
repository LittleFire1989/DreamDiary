package com.dreamingkid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ORMDcon {
	 public Connection getConnection() throws SQLException {
	        Connection conn = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException ex) {
	            
	        }
	            String url = "jdbc:mysql://mengkerorg.ipagemysql.com/mengker";
	            String user = "mengkerkid"; //remote
	            String password = "QMM_2013";     //remote_2013
	             
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("DB connects successfully.");
	            return conn;
	    }
	 
	 public static void main (String[] args) {
		 try {
			new ORMDcon().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
