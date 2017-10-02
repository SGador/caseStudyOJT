package com.ibm.achievement.dao;

import java.util.List;

import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;

public interface EmployeeDAO {
	public void deleteEmployeeData(String empId);
	public List<Employee> findAllEmployee();
	public List<Employee> findByManagerFlag();
	public List<EmployeeUserProject> findEmployeeByActiveFlg(String actFlag);
	public Employee findEmployeeById(String empId);	
	public Employee findEmployeeByMailId(String emailId);
	public List<Employee> findEmployees(String emailID, String firstName, String lastName, String managerFlag);
	public List<Project> findProjectByEmpId(String employeeId);
	public void insertEmployeeData(String empId, String emailID, String firstName, String lastName, String managerId, String managerFlag);
	public void updateEmployeeData(String empId, String emailID, String firstName, String lastName, String managerId, String managerFlag);	
}