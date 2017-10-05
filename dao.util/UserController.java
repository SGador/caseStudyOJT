package com.ibm.achievement.dao.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.achievement.bo.EmployeeManagementBO;
import com.ibm.achievement.bo.ProjectManagementBO;
import com.ibm.achievement.bo.UserManagementBO;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeVOChkBox;
import com.ibm.achievement.dao.model.User;
import com.ibm.achievement.entity.EmployeeVO;
import com.ibm.achievement.entity.ProjectVO;
import com.ibm.achievement.exception.AchievementTrackerException;
import com.ibm.achievement.forms.EmpToApproveForm;
import com.ibm.achievement.forms.EmployeeConverter;

@Controller
@SessionAttributes({"userCredentials", "role"})
public class UserController {
	
	@Autowired
	private UserManagementBO userManagementBO;
	@Autowired
	private ProjectManagementBO projectManagementBO;
	@Autowired
	private EmployeeManagementBO employeeManagementBO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView user() {
		System.out.println("I was here. 1");
		return new ModelAndView("login", "userCredentials", new User());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "emailId") String email, @RequestParam(value = "passwd") String password, Model model) throws AchievementTrackerException {
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
			model.addAttribute("role", empVO.getUserRoll());
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
	
	@RequestMapping(value = "/mainPage")
	public ModelAndView mainPage() {
		return new ModelAndView("mainPage");
	}
	
	@RequestMapping(value = "/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/reviewUserDetails", method = RequestMethod.GET)
	public ModelAndView reviewUserDetails() throws AchievementTrackerException {
		EmpToApproveForm empToApproveForm = new EmpToApproveForm();
		try {
			EmployeeConverter ec = new EmployeeConverter();
			ec.setEmpToApprove2(userManagementBO.findUserByActiveFlag("N"));
			ec.convertEmpToApprove2();
			empToApproveForm.setEmpToApprove(ec.getEmpToApprove());
			ec.convertEmpToApprove();
			empToApproveForm.setMgr(new ArrayList<EmployeeVO>());
			for(EmployeeVO emp:ec.getEmpToApprove2()){
				try {
					empToApproveForm.getMgr().add(employeeManagementBO.findEmployeesByID(emp.getManagerId()));
				} catch (AchievementTrackerException e) {
					e.printStackTrace();
				}		
			}
		} catch (AchievementTrackerException e) {
			e.printStackTrace();
		}
		return new ModelAndView("ReviewUserDetails","empToApproveForm",empToApproveForm);
	}
	
	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	public ModelAndView approve(@ModelAttribute("empToApproveForm") EmpToApproveForm empToApproveForm) {
		System.out.println(empToApproveForm);
		System.out.println(empToApproveForm.getEmpToApprove());
		List<EmployeeVOChkBox> empToApprove = empToApproveForm.getEmpToApprove();
		for(EmployeeVOChkBox emp:empToApprove){
			if(emp.getCheckControl()){
				try {
					userManagementBO.updateUserActiveFlag("Y", emp.getEmailID());
				} catch (AchievementTrackerException e) {
					e.printStackTrace();
				}
			}
			System.out.println(emp.getFirstName() +" " + emp.getLastName() + " " + emp.getEmployeeId() + " "+ emp.getCheckControl());
		}
		try {
			EmployeeConverter ec = new EmployeeConverter();
			ec.setEmpToApprove2(userManagementBO.findUserByActiveFlag("N"));
			ec.convertEmpToApprove2();
			empToApproveForm.setEmpToApprove(ec.getEmpToApprove());
			ec.convertEmpToApprove();
			empToApproveForm.setMgr(new ArrayList<EmployeeVO>());	
			for(EmployeeVO emp:ec.getEmpToApprove2()){			
					try {			
						empToApproveForm.getMgr().add(employeeManagementBO.findEmployeesByID(emp.getManagerId()));
					} catch (AchievementTrackerException e) {
						e.printStackTrace();
					}	
			}		
		} catch (AchievementTrackerException e) {
			e.printStackTrace();
		}
		return new ModelAndView("ReviewUserDetails", "empToApproveForm", empToApproveForm);
	}
}
