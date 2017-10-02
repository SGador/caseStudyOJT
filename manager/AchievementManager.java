package com.ibm.achievement.dao.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCatg;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;

@Component
public class AchievementManager {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

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

	public List<Achievement> findAchievementByEmpId(String employeeId) throws SQLException {
		/* Unsure of AchievementDoc process */
		String sql = "SELECT ta_achievement.`ACHIEVEMENT_ID`, `APPROVER_COMMENT_TEXT`, `APPROVER_POINT_VAL`, `STATUS_CODE`,  `CATEGORY_ID`, ta_achievement_documents.`DOCUMENT_ID`, ta_achievement_documents.`DOCUMENT_CONTENT` FROM `ta_achievement` INNER JOIN `ta_achievement_documents` ON ta_achievement.`ACHIEVEMENT_ID` = ta_achievement_documents.`ACHIEVEMENT_ID` WHERE `EMPLOYEE_ID` = ?";
		List<Achievement> achievementList = new ArrayList<Achievement>();
		ResultSetWrappingSqlRowSet srs = (ResultSetWrappingSqlRowSet) jdbcTemplate.queryForRowSet(sql, new Object[] {employeeId});
		while(srs.next()) {
			Achievement achievement = new Achievement();
			AchievementDoc achievementDoc = new AchievementDoc();
			achievement.setAchievementId(srs.getInt(0));
			achievement.setApproverComment(srs.getString(1));
			achievement.setApproverPointVal(srs.getInt(2));
			achievement.setStatusCode(srs.getString(3));
			achievement.setCategoryId(srs.getString(4));
			achievementDoc.setAchievementId(srs.getInt(0));
			achievementDoc.setDocumentId(srs.getInt(5));
			achievementDoc.setDocumentContent(srs.getResultSet().getBytes(6));
			achievement.getAchievementDoc().add(achievementDoc);
			achievementList.add(achievement);
		}
		return achievementList;
	}

	public int saveAchievement(Achievement achievement) {
		String sql = "INSERT INTO `ta_achievement` (`STATUS_CODE`, `APPROVER_COMMENT_TEXT`, `CATEGORY_ID`, `APPROVER_POINT_VAL`) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {achievement.getStatusCode(), achievement.getApproverComment(), achievement.getCategoryId(), achievement.getApproverPointVal()});
	}

	public int updateAchievement(Achievement achievement) {
		String sql = "UPDATE `ta_achievement` SET `STATUS_CODE` = ?, `APPROVER_COMMENT_TEXT` = ?, `CATEGORY_ID` = ?, `APPROVER_POINT_VAL` = ? WHERE `ACHIEVEMENT_ID` = ?";
		return jdbcTemplate.update(sql, new Object[] {achievement.getStatusCode(), achievement.getApproverComment(), achievement.getCategoryId(), achievement.getApproverPointVal()});
	}

	public List<Achievement> findAchievementByApproverId(String approverId) throws SQLException {
		/* Not sure with AchievementDoc process */
		String sql = "SELECT `ACHIEVEMENT_ID`, `APPROVER_COMMENT_TEXT`, `APPROVER_POINT_VAL`, `STATUS_CODE`, `CATEGORY_ID`, ta_achievement_documents.`DOCUMENT_ID`, ta_achievement_documents.`DOCUMENT_CONTENT`FROM `ta_achievement` INNER JOIN `ta_employee_detail`, `ta_achievement_documents` ON ta_achievement.`APPROVER_ID` = ta_employee_detail.`EMPLOYEE_ID` AND ta_achievement.`ACHIEVEMENT_ID` = ta_achievement_documents.`ACHIEVEMENT_ID` WHERE ta_achievement.`APPROVER_ID` = ?";
		List<Achievement> achievementList = new ArrayList<Achievement>();
		ResultSetWrappingSqlRowSet srs = (ResultSetWrappingSqlRowSet) jdbcTemplate.queryForRowSet(sql, new Object[] {approverId});
		while(srs.next()) {
			Achievement achievement = new Achievement();
			AchievementDoc achievementDoc = new AchievementDoc();
			achievement.setAchievementId(srs.getInt(0));
			achievement.setApproverComment(srs.getString(1));
			achievement.setApproverPointVal(srs.getInt(2));
			achievement.setStatusCode(srs.getString(3));
			achievement.setCategoryId(srs.getString(4));
			achievementDoc.setAchievementId(srs.getInt(0));
			achievementDoc.setDocumentId(srs.getInt(5));
			achievementDoc.setDocumentContent(srs.getResultSet().getBytes(6));
			achievement.getAchievementDoc().add(achievementDoc);
			achievementList.add(achievement);
		}
		return achievementList;
	}

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

	public void saveAchievementDoc(AchievementDoc doc) {
		String sql = "INSERT INTO `ta_achievement_documents` (`ACHIEVEMENT_ID`, `DOCUMENT_CONTENT`) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[] {doc.getAchievementId(), doc.getDocumentContent()});
	}

	public AchievementCount findAchievementCountById(String employeeId) {
		//String sql = "SELECT COUNT(`ACHIEVEMENT_ID`) FROM `ta_achievement` WHERE `EMPLOYEE_ID` = ? AND MONTH(`START_DATE`) = MONTH(CURRENT_DATE()) AND YEAR(`START_DATE`) = YEAR(CURRENT_DATE())";
		String sql = "SELECT * FROM `ta_achievement` WHERE `EMPLOYEE_ID` = ?";
		AchievementCount achievementCount = new AchievementCount();
		/* Wala ko kasabot ani nga method. Please elaborate further. */
		return achievementCount;
	}
}
