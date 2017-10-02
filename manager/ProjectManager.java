package com.ibm.achievement.dao.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.model.Project;

@Component
public class ProjectManager {
	private JdbcTemplate jdbcTemplate;
	
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

	public void insertEmpProject(String projectID, String employeeId) {
		// TODO Auto-generated method stub
		String query="INSERT INTO TA_EMPLOYEE_PROJECT(PROJECT_ID,EMPLOYEE_ID) VALUES('" + projectID + "','" + employeeId +"')";
		jdbcTemplate.update(query);
	}

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
