package com.luoyger.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "123456";
	private static String url = "jdbc:mysql://localhost:3306/servlet_template";
	private static Connection con = null;

	public static void getConnection() throws SQLException {

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int udpate(String sql, String[] args) {
		int result = 0;
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			if (args != null) {
				for (int i = 1; i <= args.length; i++) {
					ps.setString(i, args[i - 1]);
				}
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public static ResultSet query(String sql, String[] args) {
		ResultSet resultSet = null;
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			if (args != null) {
				for (int i = 1; i <= args.length; i++) {
					ps.setString(i, args[i - 1]);
				}
			}
			resultSet = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//close();
		}
		return resultSet;
	}

	public static void close() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
