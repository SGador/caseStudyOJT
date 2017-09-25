package com.ibm.achievement.dao.manager;

import java.util.List;

import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;

public interface EmployeeManager {
	public List<Employee> findByManagerFlag();
	public Employee findEmployeeByMailId(String emailId);
	public List<Employee> findAllEmployee();
	public List<EmployeeUserProject> findEmployeeByActiveFlg(String activeFlag);
	public List<Project> findProjectByEmpId(String employeeId);
	public Employee findEmployeeById(String employeeId);
	public void updateEmployeeData();
	public void insertEmployeeData(String employeeId, String emailID, String firstName, String lastName, String managerId, String managerFlag);
	public void deleteEmployeeData();
	public List<Employee> findEmployees(String emailID, String firstName, String lastName, String managerFlag);
}
