package com.ibm.achievement.dao.model;

public class AchievementCount {
	String employeeId;
	String currentMonthCount;
	String currentYearCount;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
}
