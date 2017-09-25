package com.ibm.achievement.dao.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.achievement.dao.manager.AchievementManager;
import com.ibm.achievement.dao.manager.EmployeeManager;
import com.ibm.achievement.dao.manager.ProjectManager;
import com.ibm.achievement.dao.manager.UserManager;

public class AchievementListeners{

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("AchievementTrackerService/WebContent/WEB-INF/applicationContext.xml");
		
		private UserManager userManager;
		private EmployeeManager employeeManager;
		private ProjectManager projectManager;
		private AchievementManager achievementManager;
		
		public UserManager getUserManager() {
			return userManager = ctx.getBean("userManager", UserDaoImpl.class);
		}
		public void setUserManager(UserManager userManager) {
			this.userManager = userManager;
		}
		public EmployeeManager getEmployeeManager() {
			return employeeManager = ctx.getBean("employeeManager", EmployeeDaoImpl.class);
		}
		public void setEmployeeManager(EmployeeManager employeeManager) {
			this.employeeManager = employeeManager;
		}
		public ProjectManager getProjectManager() {
			return projectManager = ctx.getBean("projectManager", ProjectDaoImpl.class);
		}
		public void setProjectManager(ProjectManager projectManager) {
			this.projectManager = projectManager;
		}
		public AchievementManager getAchievementManager() {
			return achievementManager = ctx.getBean("achievementManager", AchievementDaoImpl.class);
		}
		public void setAchievementManager(AchievementManager achievementManager) {
			this.achievementManager = achievementManager;
		}
}