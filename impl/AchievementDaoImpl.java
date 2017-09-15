package com.ibm.achievement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.ibm.achievement.dao.manager.AchievementManager;
import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCatg;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;

public class AchievementDaoImpl implements AchievementManager {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<AchievementType> findAllAchievementType() {
		String sql = "SELECT * FROM `ta_achievement_type`";
		List<AchievementType> achievementTypeList = new ArrayList<AchievementType>();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
		while(srs.next()){
			AchievementType achievementType = new AchievementType();
			achievementType.setTypeId(srs.getString(0));
			achievementType.setDescription(srs.getString(1));
			achievementTypeList.add(achievementType);
		}
		return achievementTypeList;
	}

	@Override
	public AchievementType findAchievementType(String typeId) {
		String sql = "SELECT * FROM `ta_achievement_type` WHERE `TYPE_ID` = ?";
		AchievementType achievementType = new AchievementType();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, new Object[] {typeId});
		while(srs.next()) {
			achievementType.setTypeId(srs.getString(0));
			achievementType.setDescription(srs.getString(1));
		}
		return achievementType;
	}

	@Override
	public List<AchievementCatg> findAllAchievementCatg() {
		String sql = "SELECT * FROM `ta_achievement_category`";
		List<AchievementCatg> achievementCatgList = new ArrayList<AchievementCatg>();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
		while(srs.next()) {
			AchievementCatg achievementCatg = new AchievementCatg();
			achievementCatg.setCategoryId(srs.getString(0));
			achievementCatg.setDescription(srs.getString(1));
			achievementCatgList.add(achievementCatg);
		}
		return achievementCatgList;
	}

	@Override
	public List<Achievement> findAchievementByEmpId(String employeeId) {
		String sql = "SELECT `ACHIEVEMENT_ID`, `APPROVER_COMMENT_TEXT`, `APPROVER_POINT_VAL`, `STATUS_CODE`,  `CATEGORY_ID`, `FROM `ta_achievement` WHERE `EMPLOYEE_ID` = ?";
		/* Learn foreign key for AchievementDocs*/
		return null;
	}

	@Override
	public int saveAchievement(Achievement achievement) {
		String sql = "INSERT INTO `ta_achievement` (`STATUS_CODE`, `APPROVER_COMMENT_TEXT`, `CATEGORY_ID`, `APPROVER_POINT_VAL`) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {achievement.getStatusCode(), achievement.getApproverComment(), achievement.getCategoryId(), achievement.getApproverPointVal()});
	}

	@Override
	public int updateAchievement(Achievement achievement) {
		String sql = "UPDATE `ta_achievement` SET `STATUS_CODE` = ?, `APPROVER_COMMENT_TEXT` = ?, `CATEGORY_ID` = ?, `APPROVER_POINT_VAL` = ? WHERE `ACHIEVEMENT_ID` = ?";
		return jdbcTemplate.update(sql, new Object[] {achievement.getStatusCode(), achievement.getApproverComment(), achievement.getCategoryId(), achievement.getApproverPointVal()});
	}

	@Override
	public List<Achievement> findAchievementByApproverId(String approverId) {
		String sql = "SELECT `ACHIEVEMENT_ID`, `APPROVER_COMMENT_TEXT`, `APPROVER_POINT_VAL`, `STATUS_CODE`, `CATEGORY_ID` FROM `ta_achievement` WHERE `";
		/* Learn foreign key sql syntax for approverId */
		return null;
	}

	@Override
	public Achievement findAchievementById(int achievementId) {
		String sql = "SELECT `ACHIEVEMENT_ID`, `APPROVER_COMMENT_TEXT`, `APPROVER_POINT_VAL`, `STATUS_CODE`, `CATEGORY_ID` FROM `ta_achievement` WHERE `ACHIEVEMENT_ID` = ?";
		Achievement achievement = new Achievement();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, new Object[] {achievementId});
		while(srs.next()) {
			achievement.setAchievementId(achievementId);
			achievement.setApproverComment(srs.getString(1));
			achievement.setApproverPointVal(srs.getInt(2));
			achievement.setStatusCode(srs.getString(3));
			achievement.setCategoryId(srs.getString(4));
		}
		return achievement;
	}

	@Override
	public void saveAchievementDoc(AchievementDoc doc) {
		String sql = "INSERT INTO `ta_achievement_documents` (`ACHIEVEMENT_ID`, `DOCUMENT_CONTENT`) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[] {doc.getAchievementId(), doc.getDocumentContent()});
	}

	@Override
	public AchievementCount findAchievementCountById(String employeeId) {
		String sql = "SELECT ";
		/* Wala ko kasabot ani nga method. Please elaborate further. */
		return null;
	}
}
