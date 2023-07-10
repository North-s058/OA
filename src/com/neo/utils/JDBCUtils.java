package com.neo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	//线程池
	private static ThreadLocal<Connection> pool = new ThreadLocal<Connection>();
	//初始化properties
	private static Properties properties = null;
	static {
		properties = new Properties();
		InputStream iStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			properties.load(iStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		Connection connection = pool.get();
		if(connection==null) {
			try {
				Class.forName(properties.getProperty("jdbc_driver"));
				connection = DriverManager.getConnection(properties.getProperty("jdbc_url"),properties.getProperty("jdbc_user"),properties.getProperty("jdbc_password"));
				return connection;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	public static void close() {
		Connection connection = pool.get();
		if(connection!=null) {
			try {
				pool.remove();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
