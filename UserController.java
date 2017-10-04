package com.ibm.achievement.dao.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.achievement.bo.ProjectManagementBO;
import com.ibm.achievement.bo.UserManagementBO;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.User;
import com.ibm.achievement.entity.EmployeeVO;
import com.ibm.achievement.entity.ProjectVO;
import com.ibm.achievement.exception.AchievementTrackerException;
import com.sun.media.jfxmedia.logging.Logger;

@Controller
public class UserController{
	
	@Autowired
    private UserManagementBO userManagementBO;
	@Autowired
	private ProjectManagementBO projectManagementBO;
	
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
        if(userManagementBO.isValidUser(email, password) == null) {
            return "register";
        }
        else {
            return "trial";
        }
    }
	
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public ModelAndView register(){
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("user", new User());
//		model.put("employee", new Employee());
//		System.out.println("Register na!");
//		return new ModelAndView("register", "command", model);
//	}
	
//	@RequestMapping(value = "/register, method = RequestMethod.GET")
//	public String register(Model model){
//		model.addAttribute("user", new User());
//		model.addAttribute("employee", new Employee());
//		return "register";
//	}
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
	
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@RequestParam(value = "user.emailId") String userEmail, @RequestParam(value = "user.passwd") String userPassword, 
			@RequestParam(value = "employee.firstName") String userFirstName, @RequestParam(value = "employee.lastName") String userLastName,
			@RequestParam(value = "employee.employeeId") String userEmpId, @RequestParam(value = "employee.managerId") String userManagerId){
		Boolean registered = false;
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmailID(userEmail);
		employeeVO.setActiveFlag("N");
		employeeVO.setEmployeeId(userEmpId);
		employeeVO.setFirstName(userFirstName);
		employeeVO.setLastName(userLastName);
		employeeVO.setManagerFlag("N");
		employeeVO.setManagerId(userManagerId);
		employeeVO.setUserRoll("user");
		try {
			registered = userManagementBO.registerUser(employeeVO, userPassword);
		} catch (AchievementTrackerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Registerd value : " + registered);
		return "registered";
	}
}
