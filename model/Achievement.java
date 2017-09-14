package com.ibm.achievement.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.achievement.entity.AchievementDocVO;

public class Achievement {
	private int achievementId;
	private String employeeId;
	private String achievementTypeId;
	private String achievementText;
	private String approverComment;
	private String approverId;
	private int approverPointVal;
	private Date endDate;
	private Date startDate;
	private String projectId;
	private String statusCode;
	private List<AchievementDocVO> achievementDoc = new ArrayList<AchievementDocVO>();

	public List<AchievementDocVO> getAchievementDoc() {
		return achievementDoc;
	}

	public void setAchievementDoc(List<AchievementDocVO> achievementDoc) {
		this.achievementDoc = achievementDoc;
	}

	public int getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAchievementTypeId() {
		return achievementTypeId;
	}

	public void setAchievementTypeId(String achievementTypeId) {
		this.achievementTypeId = achievementTypeId;
	}

	public String getAchievementText() {
		return achievementText;
	}

	public void setAchievementText(String achievementText) {
		this.achievementText = achievementText;
	}

	public String getApproverComment() {
		return approverComment;
	}

	public void setApproverComment(String approverComment) {
		this.approverComment = approverComment;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public int getApproverPointVal() {
		return approverPointVal;
	}

	public void setApproverPointVal(int approverPointVal) {
		this.approverPointVal = approverPointVal;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
