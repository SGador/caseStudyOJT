package com.ibm.achievement.dao.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.achievement.bo.UserManagementBO;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.User;
import com.ibm.achievement.entity.EmployeeVO;
import com.ibm.achievement.exception.AchievementTrackerException;

@Controller
public class UserController {
	
	@Autowired
	private UserManagementBO userManagementBO;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView user() {
		System.out.println("I was here. 1");
		return new ModelAndView("login", "command", new User());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "emailId") String email, @RequestParam(value = "passwd") String password) throws AchievementTrackerException {
		User user = new User();
		user.setEmailId(email);
		user.setPasswd(password);
		EmployeeVO empVO = userManagementBO.isValidUser(email, password);
		if(empVO == null) {
			return "redirect:register";
		}
		else {
			if (empVO.getUserRoll().equalsIgnoreCase("admin")) {
				return "redirect:reviewUserDetails";
			}
			else {
				return "redirect:trial";
			}
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", new User());
		model.put("employee", new Employee());
		return new ModelAndView("register", "command", new Employee());
	}
	
	@RequestMapping(value = "/reviewUserDetails")
	public ModelAndView reviewUserDetails() {
		return new ModelAndView("ReviewUserDetails");
	}
	
	@RequestMapping(value = "/trial")
	public ModelAndView mainPage() {
		return new ModelAndView("trial");
	}
}
