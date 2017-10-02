package com.ibm.achievement.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.achievement.dao.manager.ProjectManager;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.Project;

@Transactional
public class ProjectDaoImpl implements ProjectManager {
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Project> findAllProject() {
		// TODO Auto-generated method stub
		Project project;
		List<Project> projectList = new ArrayList<Project>();
		String query = "SELECT * FROM TA_PROJECTS";
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

	@Override
	public List<Project> findProjectByEmpId(String employeeId) {
		// TODO Auto-generated method stub
		Project project;
		List<Project> projectList = new ArrayList<Project>();
		String query = "SELECT P.PROJECT_ID,PROJECT_NAME,MANAGER_ID FROM TA_PROJECTS P JOIN TA_EMPLOYEE_PROJECT E WHERE ON E.PROJECT_ID = P.PROJECT_ID"
				+ " WHERE EMPLOYEE_ID='" + employeeId + "'";
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

	@Override
	public void insertEmpProject(String projectID, String employeeId) {
		// TODO Auto-generated method stub
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		Date date = new Date(today.getTimeInMillis()); 
		
		
		String query="INSERT INTO TA_EMPLOYEE_PROJECT(PROJECT_ID,EMPLOYEE_ID,START_DATE) VALUES(?,?,?)";
		jdbcTemplate.update(query,new Object[]{projectID,employeeId,date});
	}

	@Override
	public Project findProjectById(String projectId) {
		// TODO Auto-generated method stub
		Project project = new Project();
		String query = "SELECT FROM TA_PROJECTS WHERE PROJECT_ID='" + projectId + "'";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		while(srs.next()){
			
			project.setProjectID(srs.getString(1));
			project.setProjectName(srs.getString(2));
			project.setManagerID(srs.getString(3));
			
		}
		return project;
	}

}