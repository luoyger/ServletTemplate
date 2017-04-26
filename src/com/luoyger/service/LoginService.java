package com.luoyger.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.luoyger.db.DBUtil;
import com.luoyger.entity.Admin;

public class LoginService {
	public static LoginService loginService = null;
	
	public LoginService(){
		if(loginService != null ){
			loginService = new LoginService();
		}
	}
	
	public void insertAdmin(String username,String password){
		String sql = "insert into admin(username,password) values(?,?)";
		String[] params = new String[]{username,password};
		DBUtil.udpate(sql, params);
	}
	
	public List<Admin> displayAdminList(){
		String sql = "select * from admin";
		String[] params = new String[]{};
		ResultSet resultSet = DBUtil.query(sql, params);
		List<Admin> adminList = new ArrayList<Admin>();
		try {
			while(resultSet.next()){
				Admin admin = new Admin();
				admin.setUsername(resultSet.getString("username"));
				adminList.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminList;
	}
}
