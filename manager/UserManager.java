package com.ibm.achievement.dao.manager;

import java.util.List;

import com.ibm.achievement.dao.model.User;

public interface UserManager {
	public User findUserByMailId(String emailId);
	public List<User> findUserByActiveFlg();
	public List<User> findAllUser();
	public int updateActiveFlag(String emailId, String activeFlag);
	public boolean insertUserData(String emailID, String password, String activeFlg, String userRoll);
	public boolean deleteUserData();
}
