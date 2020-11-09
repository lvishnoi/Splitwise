package org.finance.dao;

public interface DatabaseCredentials {

	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost/splitwise?autoReconnect=true&useSSL=false";

	String USER = "root";
	String PASS = "root";

}
