package com.ibm.achievement.forms;

import java.util.ArrayList;
import java.util.List;

import com.ibm.achievement.dao.model.EmployeeVOChkBox;
import com.ibm.achievement.entity.EmployeeVO;

public class EmployeeConverter {
		private List<EmployeeVOChkBox> empToApprove;
		private List<EmployeeVO> empToApprove2;
		public void setEmpToApprove(List<EmployeeVOChkBox> empToApprove) {
			this.empToApprove = empToApprove;
		}
	
		public List<EmployeeVOChkBox> getEmpToApprove() {
			return empToApprove;
		}

		public void setEmpToApprove2(List<EmployeeVO> empToApprove2) {
			this.empToApprove2 = empToApprove2;
	
		}
		
		public List<EmployeeVO> getEmpToApprove2() { //CONVERT to ChkBoxFormat
			return empToApprove2;
		}
		
		public void convertEmpToApprove2() {
			EmployeeVOChkBox ecb;
			empToApprove = new ArrayList<EmployeeVOChkBox>();
			for(EmployeeVO e: empToApprove2){
				ecb = new EmployeeVOChkBox();
				ecb.setActiveFlag(e.getActiveFlag());
				ecb.setCheckControl(false);
				ecb.setEmailID(e.getEmailID());
				ecb.setEmployeeId(e.getEmployeeId());
				ecb.setFirstName(e.getFirstName());
				ecb.setLastName(e.getLastName());
				ecb.setManagerFlag(e.getManagerFlag());
				ecb.setManagerId(e.getManagerId());
				ecb.setProjects(e.getProjects());
				ecb.setUserRoll(e.getUserRoll());
				System.out.println(ecb.getCheckControl());
				System.out.println(ecb.getEmailID());
				System.out.println(ecb.getFirstName());
				System.out.println(ecb.getActiveFlag());
				
				empToApprove.add(ecb);
			}
		}
		public void convertEmpToApprove() { //CONVERT from ChkboxFormat
			EmployeeVO e;
			empToApprove = new ArrayList<EmployeeVOChkBox>();
			for(EmployeeVOChkBox ecb: empToApprove){
				e = new EmployeeVO();
				e.setActiveFlag(ecb.getActiveFlag());
				
				e.setEmailID(ecb.getEmailID());
				e.setEmployeeId(ecb.getEmployeeId());
				e.setFirstName(ecb.getFirstName());
				e.setLastName(ecb.getLastName());
				e.setManagerFlag(ecb.getManagerFlag());
				e.setManagerId(ecb.getManagerId());
				e.setProjects(ecb.getProjects());
				e.setUserRoll(ecb.getUserRoll());
				
				System.out.println(e.getEmailID());
				System.out.println(e.getFirstName());
				System.out.println(e.getActiveFlag());
				
				empToApprove2.add(e);
			}
		}

}
