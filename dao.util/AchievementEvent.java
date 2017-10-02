package com.ibm.achievement.dao.util;

import org.springframework.context.ApplicationEvent;

public class AchievementEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AchievementEvent(Object source) {
		super(source);
	}
}
