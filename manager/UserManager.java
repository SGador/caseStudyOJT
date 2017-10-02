package com.ibm.achievement.dao.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.achievement.dao.model.User;

@Component
public class UserManager {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
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

	@Transactional
	public int updateActiveFlag(String emailId, String activeFlag) {
		String query = "UPDATE TA_USERS SET ACTIVE_FLAG='" + activeFlag +"' WHERE EMAIL_ADDRESS='" + emailId + "'";
		return jdbcTemplate.update(query);
	}

	@Transactional
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

	@Transactional
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
