package com.ibm.achievement.dao.manager;

public interface AchievementManager {
	public void findAllAchievementType();
	public void findAchievementType();
	public void findAllAchievementCatg();
	public void findAchievementByEmpId();
	public void saveAchievement();
	public void updateAchievement();
	public void findAchievementByApproverId();
	public void findAchievementById();
	public void saveAchievementDoc();
	public void findAchievementCountById();
}
