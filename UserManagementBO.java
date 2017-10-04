package com.ibm.achievement.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.achievement.dao.manager.EmployeeManager;
import com.ibm.achievement.dao.manager.ProjectManager;
import com.ibm.achievement.dao.manager.UserManager;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;
import com.ibm.achievement.dao.model.User;
import com.ibm.achievement.dao.util.AchievementListeners;
import com.ibm.achievement.entity.EmployeeVO;
import com.ibm.achievement.entity.ProjectVO;
import com.ibm.achievement.exception.AchievementTrackerException;
import com.ibm.achievement.util.AchievementConstants;

@Service
public class UserManagementBO {
	
	@Autowired
	private AchievementListeners achievementListeners;

	private Logger logger = Logger.getLogger(UserManagementBO.class);

	/**
	 * This method is used to validate one user for login and return the user
	 * roll. If user roll is null that means user in not valid.
	 * 
	 * @param emailAddress
	 * @param password
	 * @return String
	 */
	public EmployeeVO isValidUser(String emailId, String password) throws AchievementTrackerException {
		
		logger.info("START isValidUser");
		EmployeeVO employeeVO = null;
		
		if (emailId == null || emailId.equals("")) {
			throw new AchievementTrackerException(AchievementConstants.EMAIL_ID_IS_BLANK);
		}
		if (password == null || password.equals("")) {
			throw new AchievementTrackerException(AchievementConstants.PASSWORD_ID_IS_BLANK);
		}
//		try {
			UserManager userManager = achievementListeners.getUserManager();
			User user = userManager.findUserByMailId(emailId);

			if (user != null && user.getPasswd().equals(password) && user.getActivFlg().equals("Y")) {
				employeeVO = new EmployeeVO();
				EmployeeManager employeeManager = achievementListeners.getEmployeeManager();
				Employee employee = employeeManager.findEmployeeByMailId(user.getEmailId());
				BeanUtils.copyProperties(employee, employeeVO);
				employeeVO.setUserRoll(user.getRole());
				employeeVO.setActiveFlag(user.getActivFlg());
				
				ProjectManager projectManager = achievementListeners.getProjectManager();
				List<Project> projList = projectManager.findProjectByEmpId(employee.getEmployeeId());
				List<ProjectVO> projects = new ArrayList<ProjectVO>();
				
				for (Project project : projList) {
					ProjectVO projectVO = new ProjectVO();
					BeanUtils.copyProperties(project, projectVO);
					projects.add(projectVO);
				}

				employeeVO.setProjects(projects);
			}
//		} catch (SQLException ex) {
//			throw new AchievementTrackerException(ex.getMessage());
//		}
		logger.info("END isValidUser");
		
		return employeeVO;
	}

	/**
	 * This method is used to save user
	 * 
	 * @param emailId
	 * @param password
	 * @param activeFlag
	 */
	@Transactional
	public boolean registerUser(EmployeeVO employeeVO, String password) throws AchievementTrackerException {
		
		logger.info("START registerUser");
//		try {
			// CHECK FOR THE EMPLOYEE ID
			EmployeeManager employeeManager = achievementListeners.getEmployeeManager();
			Employee employee =  employeeManager.findEmployeeById(employeeVO.getEmployeeId());
			
			if(employee != null && employee.getEmployeeId()!= null){
				throw new AchievementTrackerException(AchievementConstants.EMPLOYEE_ID_IS_ALREADY_EXIST);
			}
			
			// CHECK FOR THE EMAIL ID
			Employee employee2 = employeeManager.findEmployeeByMailId(employeeVO.getEmailID());
			
			if(employee2 != null && employee2.getEmailID() != null){
				throw new AchievementTrackerException(AchievementConstants.EMAIL_ID_IS_ALREADY_EXIST);
			}
			
			Employee manager =  employeeManager.findEmployeeById(employeeVO.getManagerId());
			if(manager != null && !("Y").equals(manager.getManagerFlag())){
				throw new AchievementTrackerException(AchievementConstants.INVALID_MANAGER_ID);
			}
			
			if(employeeVO.getEmployeeId().equals(manager.getEmployeeId())){
				throw new AchievementTrackerException(AchievementConstants.INVALID_EMPLOYEE_ID);
			}
			
			UserManager userManager = achievementListeners.getUserManager();

			userManager.insertUserData(employeeVO.getEmailID(), password,
					employeeVO.getActiveFlag(), employeeVO.getUserRoll());

			employeeManager.insertEmployeeData(employeeVO.getEmployeeId(),
					employeeVO.getEmailID(), employeeVO.getFirstName(),
					employeeVO.getLastName(), employeeVO.getManagerId(),
					employeeVO.getManagerFlag());

			ProjectManager projectManager = achievementListeners.getProjectManager();
			List<ProjectVO> projects = employeeVO.getProjects();
			
			if(projects != null ){
				for (ProjectVO projVo : projects) {
					projectManager.insertEmpProject(projVo.getProjectID(),employeeVO.getEmployeeId());
				}
			}

//		} catch (SQLException ex) {
//			throw new AchievementTrackerException(ex.getMessage());
//		}
		logger.info("END registerUser");

		return true;
	}

	/**
	 * This method is used to find user by active flag
	 * 
	 * @param activeFlag
	 * @return list of EmployeeVO
	 */
	public List<EmployeeVO> findUserByActiveFlag(String activeFlag) throws AchievementTrackerException {
		
		logger.info("START findUserByActiveFlag");
		List<EmployeeVO> employeeVOs = new ArrayList<EmployeeVO>();
		EmployeeManager employeeManager = achievementListeners.getEmployeeManager();
		List<EmployeeUserProject> employeeUser = employeeManager.findEmployeeByActiveFlg(activeFlag);
//		try {
			for (EmployeeUserProject empUser : employeeUser) {
				EmployeeVO employeeVO = new EmployeeVO();
				employeeVO.setActiveFlag(empUser.getActiveFlag());
				employeeVO.setEmailID(empUser.getEmailID());
				employeeVO.setEmployeeId(empUser.getEmployeeId());
				employeeVO.setFirstName(empUser.getFirstName());
				employeeVO.setLastName(empUser.getLastName());
				employeeVO.setManagerFlag(empUser.getManagerFlag());
				employeeVO.setManagerId(empUser.getManagerId());
				employeeVO.setManagerId(empUser.getManagerId());
				employeeVO.setUserRoll(empUser.getUserRoll());

				ProjectManager projectManager = achievementListeners.getProjectManager();
				List<Project> projList = projectManager.findProjectByEmpId(empUser.getEmployeeId());
				List<ProjectVO> projects = new ArrayList<ProjectVO>();
				
				for (Project project : projList) {
					ProjectVO projectVO = new ProjectVO();
					BeanUtils.copyProperties(project, projectVO);
					projects.add(projectVO);
				}

				employeeVO.setProjects(projects);
				employeeVOs.add(employeeVO);
			}
//		} catch (SQLException ex) {
//			throw new AchievementTrackerException(ex.getMessage());
//		}
		logger.info("END findUserByActiveFlag");
		
		return employeeVOs;
	}

	/**
	 * @param activeFlag
	 * @param emailId
	 */
	@Transactional
	public boolean updateUserActiveFlag(String activeFlag, String emailId) throws AchievementTrackerException {
		
		logger.info("START updateUserActiveFlag");
		if (activeFlag == null || activeFlag.equals("")) {
			throw new AchievementTrackerException(AchievementConstants.ACTIVE_FLAG_IS_BLANK);
		}
//		try {
			UserManager userManager = achievementListeners.getUserManager();
			int status = userManager.updateActiveFlag(emailId, activeFlag);
			logger.info("END updateUserActiveFlag");
			if (status == 1) {
				return true;
			} else {
				return false;
			}
//		} catch (SQLException ex) {
//			throw new AchievementTrackerException(ex.getMessage());
//		}
	}
}
