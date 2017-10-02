package com.ibm.achievement.dao.util;

import org.springframework.context.ApplicationEvent;

import com.ibm.achievement.dao.manager.EmployeeManager;

public class EmployeeEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeManager employeeManager;
	
	public EmployeeEvent(Object source) {
		super(source);
	}

	public EmployeeManager getEmployeeManager() {
		return employeeManager;
	}
}
