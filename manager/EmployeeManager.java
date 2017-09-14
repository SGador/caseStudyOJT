package com.ibm.achievement.dao.manager;

public interface EmployeeManager {
	public void findByManagerFlag();
	public void findEmployeeByMailId();
	public void findAllEmployee();
	public void findEmployeeByActiveFlg();
	public void findProjectByEmpId();
	public void findEmployeeById();
	public void updateEmployeeData();
	public void insertEmployeeData();
	public void deleteEmployeeData();
	public void findEmployees();
}
