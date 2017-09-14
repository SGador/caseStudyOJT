package com.ibm.achievement.dao.model;

import java.util.ArrayList;
import java.util.List;

public class Achievement {
	private int achievementId;
	private int approverPointVal;
	private String statusCode;
	private String categoryId;
	private List<AchievementDoc> achievementDoc = new ArrayList<AchievementDoc>();

	public List<AchievementDoc> getAchievementDoc() {
		return achievementDoc;
	}

	public void setAchievementDoc(List<AchievementDoc> achievementDoc) {
		this.achievementDoc = achievementDoc;
	}

	public int getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
	}

	public int getApproverPointVal() {
		return approverPointVal;
	}

	public void setApproverPointVal(int approverPointVal) {
		this.approverPointVal = approverPointVal;
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

}
