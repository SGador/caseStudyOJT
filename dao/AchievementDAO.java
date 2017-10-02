package com.ibm.achievement.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCatg;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;

public interface AchievementDAO {
	public List<Achievement> findAchievementByApproverId(String approverId) throws SQLException;
	public List<Achievement> findAchievementByEmpId(String employeeId) throws SQLException;
	public Achievement findAchievementById(int achievementId);
	public AchievementCount findAchievementCountById(String employeeId);
	public AchievementDoc findAchievementDocById(String achievementId);
	public AchievementType findAchievementType(String typeId);
	public List<AchievementCatg> findAllAchievementCatg();
	public List<AchievementType> findAllAchievementType();
	public int saveAchievement(Achievement achievement);
	public void saveAchievementDoc(AchievementDoc doc);
	public int updateAchievement(Achievement achievement);	
}
