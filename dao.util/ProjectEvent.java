package com.ibm.achievement.dao.util;

import org.springframework.context.ApplicationEvent;

public class ProjectEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProjectEvent(Object source) {
		super(source);
	}
}