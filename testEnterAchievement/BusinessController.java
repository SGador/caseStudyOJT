package com.ibm.achievement.dao.util;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.achievement.bo.*;
import com.ibm.achievement.dao.manager.*;
import com.ibm.achievement.dao.model.*;
import com.ibm.achievement.entity.AchievementDocVO;
import com.ibm.achievement.entity.AchievementTypesVO;
import com.ibm.achievement.entity.AchievementVO;
import com.ibm.achievement.exception.AchievementTrackerException;

@Controller
public class BusinessController implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher applicationEventPublisher;
	private List<AchievementTypesVO> achievementTypes = new ArrayList<AchievementTypesVO>();
	
	AchievementDTO achievementDTO = new AchievementDTO();
	@Autowired
	private UserManagementBO userManagementBO;
	
	@Autowired
	private AchievementTrackerBO achievementTrackerBO;
	
	@Autowired
	private EmployeeManagementBO employeeManagementBO;
	
	@Autowired
	private ProjectManagementBO projectManagementBO;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView enterAchievement() {
		System.out.println("I was here. 1");
		try {
			achievementTypes = achievementTrackerBO.findAchievementTypes();
		} catch (AchievementTrackerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("enterAchievement", "command", achievementDTO);
	}
	
	
	@RequestMapping(value = "/saveAchievement", method = RequestMethod.POST)
	public ModelAndView submitAchievement(@RequestParam("achievementType")AchievementTypesVO at, @RequestParam("files") MultipartFile[] file, @RequestParam("achievementTextArea") String text,
			@RequestParam("fromDate")Date from, @RequestParam("toDate")Date to){		
		AchievementDocVO achDoc1 = new AchievementDocVO();
		AchievementDocVO achDoc2 = new AchievementDocVO();
		List<AchievementDocVO> achDoc = new ArrayList<AchievementDocVO>();
		try {
			if(file[0]!=null){				
				byte[] file1 = file[0].getBytes();
				achDoc1.setDocumentName(file[0].getOriginalFilename());
				achDoc1.setDocumentContent(file1);
				achDoc.add(achDoc1);
			}
			
			if(file[1]!=null){				
				byte[] file2 = file[1].getBytes();
				achDoc2.setDocumentName(file[0].getOriginalFilename());
				achDoc2.setDocumentContent(file2);
				achDoc.add(achDoc2);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AchievementVO achievement = new AchievementVO();
		/*achievement.setEmployeeId(achievementDTO.getEmployeeId());*/
		achievement.setEmployeeId("000000");
		achievement.setAchievementTypeId(at.getTypeId());
		achievement.setAchievementText(text);
		achievement.setStartDate(from);
		achievement.setEndDate(to);
		achievement.setAchievementDoc(achDoc);
		try {
			achievementTrackerBO.saveAchievement(achievement);
		} catch (AchievementTrackerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("enterAchievement", "command", achievementDTO);
	}
	
	
}
