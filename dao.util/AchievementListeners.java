package com.ibm.achievement.dao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.manager.AchievementManager;
import com.ibm.achievement.dao.manager.UserManager;

@Component
public class AchievementListeners{

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private AchievementManager achievementManager;
	
	@EventListener(AchievementEvent.class)
	public AchievementManager getAchievementManger() {
		System.out.println("I was here. AM");
		return achievementManager;
	}
	
	@EventListener(UserEvent.class)
	public UserManager getUserManager() {
		System.out.println("I was here. UM");
		return userManager;
	}
}