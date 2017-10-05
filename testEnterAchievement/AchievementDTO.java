package com.ibm.achievement.dao.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.achievement.dao.model.AchievementType;
import com.ibm.achievement.entity.AchievementDocVO;

public class AchievementDTO {
	private String employeeId;
	private String empName;
	private String managerId;
	private String achievementTypeId;
	private String achievementText;
	private String approverComment;
	private String approverId;
	private String peerId;
	private int approverPointVal;
	private String projectId;
	private String statusCode;
	private String categoryId;
	private String descriptionCat;
	String currentMonthCount;
	String currentYearCount;
	private String typeId;
	private String descriptionType;
	
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
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescriptionCat() {
		return descriptionCat;
	}
	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}
	public String getCurrentMonthCount() {
		return currentMonthCount;
	}
	public void setCurrentMonthCount(String currentMonthCount) {
		this.currentMonthCount = currentMonthCount;
	}
	public String getCurrentYearCount() {
		return currentYearCount;
	}
	public void setCurrentYearCount(String currentYearCount) {
		this.currentYearCount = currentYearCount;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getDescriptionType() {
		return descriptionType;
	}
	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getPeerId() {
		return peerId;
	}
	public void setPeerId(String peerId) {
		this.peerId = peerId;
	}
}
