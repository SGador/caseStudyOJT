package com.ibm.achievement.dao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

import com.ibm.achievement.dao.manager.UserManager;

public class UserEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserManager userManager;

	public UserEvent(Object source) {
		super(source);
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
}
