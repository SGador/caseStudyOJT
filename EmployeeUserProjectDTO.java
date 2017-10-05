package com.ibm.achievement.dao.util;

import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.User;
import com.ibm.achievement.entity.ProjectVO;

public class EmployeeUserProjectDTO {
	
	private User user;
	private Employee employee;
	private ProjectVO projectVO;
	
	public ProjectVO getProjectVO() {
		return projectVO;
	}
	public void setProjectVO(ProjectVO projectVO) {
		this.projectVO = projectVO;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
