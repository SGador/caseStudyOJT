package com.ibm.achievement.dao;

import java.util.List;

import com.ibm.achievement.dao.model.User;

public interface UserDAO {
	public User findUserByMailId(String emailId);
	public List<User> findUserByActiveFlg(String activeFlag);
	public List<User> findAllUser();
	public int updateActiveFlag(String emailId, String activeFlag);
	public boolean insertUserData(String emailId, String password, String activeFlag, String role);
	public boolean deleteUserData(String emailId);
}
