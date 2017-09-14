package com.ibm.achievement.dao.manager;

import java.util.List;

import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCatg;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;

public interface AchievementManager {
	public List<AchievementType> findAllAchievementType();
	public AchievementType findAchievementType(String typeId);
	public List<AchievementCatg> findAllAchievementCatg();
	public List<Achievement> findAchievementByEmpId(String employeeId);
	public int saveAchievement(Achievement achievement);
	public int updateAchievement(Achievement achievement);
	public List<Achievement> findAchievementByApproverId(String approverId);
	public Achievement findAchievementById(int achievementId);
	public void saveAchievementDoc(AchievementDoc doc);
	public AchievementCount findAchievementCountById(String employeeId);
}
