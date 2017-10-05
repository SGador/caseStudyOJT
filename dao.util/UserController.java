package com.ibm.achievement.dao.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.achievement.bo.ProjectManagementBO;
import com.ibm.achievement.bo.UserManagementBO;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.User;
import com.ibm.achievement.entity.EmployeeVO;
import com.ibm.achievement.entity.ProjectVO;
import com.ibm.achievement.exception.AchievementTrackerException;

@Controller
@SessionAttributes("userCredentials")
public class UserController {
	
	@Autowired
	private UserManagementBO userManagementBO;
	@Autowired
	private ProjectManagementBO projectManagementBO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView user() {
		System.out.println("I was here. 1");
		return new ModelAndView("login", "userCredentials", new User());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "emailId") String email, @RequestParam(value = "passwd") String password) throws AchievementTrackerException {
		User user = new User();
		user.setEmailId(email);
		user.setPasswd(password);
		EmployeeVO empVO = userManagementBO.isValidUser(email, password);
		ModelAndView modelAndView = new ModelAndView();
		if(empVO == null) {
			modelAndView.setViewName("redirect:/register");
		}
		else {
			modelAndView.addObject("userCredentials", user);
			if (empVO.getUserRoll().equalsIgnoreCase("admin")) {
				modelAndView.setViewName("redirect:/reviewUserDetails");
			}
			else {
				modelAndView.setViewName("redirect:/mainPage");
			}
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage(@ModelAttribute("userdetails") EmployeeUserDTO userDetails,
			Map<String, Object> model) {			
		User user = userDetails.getUser();
		model.put("user", user);
		Employee employee = userDetails.getEmployee();
		model.put("employee", employee);
		try {
			List<ProjectVO> projectList = projectManagementBO.findProjects();
			model.put("projectlist", projectList);
		} catch (AchievementTrackerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "register";
	}
	
	@RequestMapping(value = "/reviewUserDetails")
	public ModelAndView reviewUserDetails() {
		return new ModelAndView("ReviewUserDetails");
	}
	
	@RequestMapping(value = "/mainPage")
	public ModelAndView mainPage() {
		return new ModelAndView("mainPage");
	}
}
