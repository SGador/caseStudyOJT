package com.ibm.achievement.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.ibm.achievement.dao.manager.UserManager;
import com.ibm.achievement.dao.model.User;

public class UserDaoImpl implements UserManager {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public User findUserByMailId(String emailId) {
		User user = new User();
		String query = "SELECT * from TA_USERS where EMAIL_ADDRESS='" + emailId + "'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			
			user.setEmailId(srs.getString(1));
			user.setPasswd(srs.getString(2));
			user.setActivFlg(srs.getString(3));
			user.setRole(srs.getString(4));
		}
		return user;
	}

	@Override
	public List<User> findUserByActiveFlg(String activeFlag) {
		User user;
		List<User> userList = new ArrayList<User>();
		String query = "SELECT * FROM TA_USERS WHERE ACTIVE_FLAG='" + activeFlag +"'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			user = new User();
			user.setEmailId(srs.getString(1));
			user.setPasswd(srs.getString(2));
			user.setActivFlg(srs.getString(3));
			user.setRole(srs.getString(4));
			userList.add(user);
		}
		return userList;
	}

	@Override
	public List<User> findAllUser() {
		User user;
		List<User> userList = new ArrayList<User>();
		String query = "SELECT * FROM TA_USERS";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			user = new User();
			user.setEmailId(srs.getString(1));
			user.setPasswd(srs.getString(2));
			user.setActivFlg(srs.getString(3));
			user.setRole(srs.getString(4));
			userList.add(user);
		}
		return userList;
	}

	@Override
	public int updateActiveFlag(String emailId, String activeFlag) {
		String query = "UPDATE TA_USERS SET ACTIVE_FLAG='" + activeFlag +"' WHERE EMAIL_ADDRESS='" + emailId + "'";
		return jdbcTemplate.update(query);
	}

	@Override
	public boolean insertUserData(String emailId, String password, String activeFlag, String userRole) {
		String query = "INSERT INTO TA_USERS(EMAIL_ADDRESS,PASSWORD,ACTIVE_FLAG,USER_ROLE) VALUES('" + emailId + "','" + 
				password + "','" + activeFlag + "','" + userRole + "')";
		try{
			jdbcTemplate.update(query);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean deleteUserData(String emailId) {
		String query = "DELETE FROM TA_USERS WHERE EMAIL_ADDRESS='" + emailId + "'";
		try{
			jdbcTemplate.update(query);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

}
