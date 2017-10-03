package com.ibm.achievement.dao.util;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.manager.AchievementManager;
import com.ibm.achievement.dao.manager.EmployeeManager;
import com.ibm.achievement.dao.manager.ProjectManager;
import com.ibm.achievement.dao.manager.UserManager;

@Component
public class AchievementListeners{

	@Autowired
	private AchievementManager achievementManager;
	@Autowired
	private EmployeeManager employeeManager;
	@Autowired
	private ProjectManager projectManager;
	@Autowired
	private UserManager userManager;
	
	public AchievementManager getAchievementManager() {
		System.out.println("I was here. AM");
		return achievementManager;
	}
	
	public EmployeeManager getEmployeeManager() {
		System.out.println("I was here. EM");
		return employeeManager;
	}
	
	public ProjectManager getProjectManager() {
		System.out.println("I was here. PM");
		return projectManager;
	}
	
	public UserManager getUserManager() {
		System.out.println("I was here. UM");
		return userManager;
	}
}