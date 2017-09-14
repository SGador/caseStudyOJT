package com.ibm.achievement.dao.manager;

import java.util.List;

import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;

public interface EmployeeManager {
	public List<Employee> findByManagerFlag();
	public Employee findEmployeeByMailId(String emailId);
	public void findAllEmployee();
	public List<EmployeeUserProject> findEmployeeByActiveFlg(String activeFlag);
	public void findProjectByEmpId();
	public Employee findEmployeeById(String employeeId);
	public void updateEmployeeData();
	public void insertEmployeeData(String employeeId, String emailID, String firstName, String lastName, String managerId, String managerFlag);
	public void deleteEmployeeData();
	public List<Employee> findEmployees(String emailID, String firstName, String lastName, String managerFlag);
}
