package com.ibm.achievement.dao.manager;

public interface UserManager {
	public void findUserByMailId();
	public void findUserByActiveFlg();
	public void findAllUser();
	public void updateActiveFlag();
	public void insertUserData();
	public void deleteUserData();
}
