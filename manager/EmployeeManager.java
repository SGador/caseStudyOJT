package com.ibm.achievement.dao.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;

@Component
public class EmployeeManager {
	private JdbcTemplate jdbcTemplate;
	
	public List<Employee> findByManagerFlag() {
		// TODO Auto-generated method stub
		Employee employee;
		List<Employee> employeeList = new ArrayList<Employee>();
		String query = "SELECT * FROM TA_EMPLOYEE_DETAIL WHERE MANAGER_FLAG='Y'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			employee = new Employee();
			employee.setEmployeeId(srs.getString(1));
			employee.setEmailID(srs.getString(2));
			employee.setFirstName(srs.getString(3));
			employee.setLastName(srs.getString(4));
			employee.setManagerId(srs.getString(5));
			employee.setManagerFlag(srs.getString(6));
			employeeList.add(employee);
		}
		
		return employeeList;
	}

	public Employee findEmployeeByMailId(String emailId) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		String query = "SELECT * from TA_EMPLOYEE_DETAIL WHERE EMAIL_ADDRESS='" + emailId + "'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			
			
			employee.setEmployeeId(srs.getString(1));
			employee.setEmailID(srs.getString(2));
			employee.setFirstName(srs.getString(3));
			employee.setLastName(srs.getString(4));
			employee.setManagerId(srs.getString(5));
			employee.setManagerFlag(srs.getString(6));
		}
		return employee;
	}

	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		Employee employee;
		List<Employee> employeeList = new ArrayList<Employee>();
		String query = "SELECT * FROM TA_EMPLOYEE_DETAIL";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			employee = new Employee();
			employee.setEmployeeId(srs.getString(1));
			employee.setEmailID(srs.getString(2));
			employee.setFirstName(srs.getString(3));
			employee.setLastName(srs.getString(4));
			employee.setManagerId(srs.getString(5));
			employee.setManagerFlag(srs.getString(6));
			employeeList.add(employee);
		}
		return employeeList;
	}

	public List<EmployeeUserProject> findEmployeeByActiveFlg(String activeFlag) {
		// TODO Auto-generated method stub
		EmployeeUserProject eup;
		List<EmployeeUserProject> eupList = new ArrayList<EmployeeUserProject>();
		String query = "SELECT EMPLOYEE_ID,E.EMAIL_ADDRESS,FIRST_NAME,LAST_NAME,MANAGER_ID,MANAGER_FLAG,ACTIVE_FLAG,USER_ROLE"
				+ " FROM TA_EMPLOYEE_DETAIL E JOIN TA_USERS U ON E.EMAIL_ADDRESS = U.EMAIL_ADDRESS "
				+ "WHERE ACTIVE_FLAG='" + activeFlag + "'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			eup = new EmployeeUserProject();
			eup.setEmployeeId(srs.getString("EMPLOYEE_ID"));
			eup.setEmailID(srs.getString("EMAIL_ADDRESS"));
			eup.setFirstName(srs.getString("FIRST_NAME"));
			eup.setLastName(srs.getString("LAST_NAME"));
			eup.setManagerId(srs.getString("MANAGER_ID"));
			eup.setManagerFlag(srs.getString("MANAGER_FLAG"));
			eup.setActiveFlag(srs.getString("ACTIVE_FLAG"));
			eup.setUserRoll(srs.getString("USER_ROLE"));
			eupList.add(eup);
		}
		return eupList;
	}

	public List<Project> findProjectByEmpId(String empId) {
		// TODO Auto-generated method stub
		List<Project> projectList = new ArrayList<Project>();
		Project project;
		String query = "SELECT E.PROJECT_ID,PROJECT_NAME,MANAGER_ID FROM TA_EMPLOYEE_PROJECT E JOIN TA_PROJECTS P"
				+ " ON E.PROJECT_ID = P.PROJECT_ID WHERE EMPLOYEE_ID='" + empId + "'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			project = new Project();
			project.setProjectID(srs.getString(1));
			project.setProjectName(srs.getString(2));
			project.setManagerID(srs.getString(3));
			projectList.add(project);
		}
		return projectList;
	}

	public Employee findEmployeeById(String employeeId) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		String query = "SELECT * from TA_EMPLOYEE_DETAIL WHERE EMPLOYEE_ID='" + employeeId + "'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			
			
			employee.setEmployeeId(srs.getString(1));
			employee.setEmailID(srs.getString(2));
			employee.setFirstName(srs.getString(3));
			employee.setLastName(srs.getString(4));
			employee.setManagerId(srs.getString(5));
			employee.setManagerFlag(srs.getString(6));
		}
		return employee;
		
	}

	public void updateEmployeeData() {
		// TODO Auto-generated method stub
		//SKIPPED coz next case study pa ni

	}

	public void insertEmployeeData(String employeeId, String emailID, String firstName, String lastName,
			String managerId, String managerFlag) {
		// TODO Auto-generated method stub
		String query="INSERT INTO TA_EMPLOYEE_DETAIL(EMPLOYEE_ID,EMAIL_ADDRESS,FIRST_NAME,LAST_NAME,MANAGER_ID,MANAGER_FLAG) "
				+ "VALUES('" + employeeId + "','" + emailID + "','" + firstName + "','" + lastName + "','" + managerId + "','" + managerFlag + "')";
		jdbcTemplate.update(query);
	}

	public void deleteEmployeeData() {
		// TODO Auto-generated method stub
		//SKIPPED
	}

	public List<Employee> findEmployees(String emailID, String firstName, String lastName, String managerFlag) {
		// TODO Auto-generated method stub
		Employee employee;
		List<Employee> employeeList = new ArrayList<Employee>();
		String query = "SELECT * FROM TA_EMPLOYEE_DETAIL WHERE EMAIL_ADDRESS='"+ emailID + "' OR"
				+ "FIRST_NAME='" + firstName + "' OR LAST_NAME='" + lastName + "' OR MANAGER_FLAG='" + managerFlag +"'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			employee = new Employee();
			employee.setEmployeeId(srs.getString(1));
			employee.setEmailID(srs.getString(2));
			employee.setFirstName(srs.getString(3));
			employee.setLastName(srs.getString(4));
			employee.setManagerId(srs.getString(5));
			employee.setManagerFlag(srs.getString(6));
			employeeList.add(employee);
		}
		return employeeList;
	}
}
