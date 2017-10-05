package com.ibm.achievement.forms;

import java.util.ArrayList;
import java.util.List;

import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeVOChkBox;
import com.ibm.achievement.entity.EmployeeVO;

public class EmpToApproveForm {
	//private List<EmployeeVO> empToApprove;
	private List<EmployeeVOChkBox> empToApprove;
	private List<EmployeeVO> mgr;
	//private List<EmployeeVO> empToApprove2;

	public List<EmployeeVO> getMgr() {
		return mgr;
	}

	public void setMgr(List<EmployeeVO> mgr) {
		this.mgr = mgr;
	}

	public List<EmployeeVOChkBox> getEmpToApprove() {
		return empToApprove;
	}

	public void setEmpToApprove(List<EmployeeVOChkBox> empToApprove) {
		this.empToApprove = empToApprove;
	}

//	public List<EmployeeVO> getEmpToApprove() {
//		return empToApprove;
//	}
//
//	public void setEmpToApprove(List<EmployeeVO> empToApprove) {
//		this.empToApprove = empToApprove;
//	}
//	
//	public void setEmpToApprove2(List<EmployeeVO> empToApprove2) {
//		this.empToApprove2 = empToApprove2;
//	}
//
//	public List<EmployeeVOChkBox> getEmpToApprove() {
//		return empToApprove;
//	}

//	public void setEmpToApprove(List<EmployeeVO> empToApprove) {
//		this.empToApprove2 = empToApprove;
//
//	}
//	
//	public List<EmployeeVO> getEmpToApprove2() {
//		return empToApprove2;
//	}
//	
//	public void convertEmpToApprove() {
//		EmployeeVOChkBox ecb;
//		empToApprove = new ArrayList<EmployeeVOChkBox>();
//		for(EmployeeVO e: empToApprove2){
//			ecb = new EmployeeVOChkBox();
//			ecb.setActiveFlag(e.getActiveFlag());
//			ecb.setCheckControl(false);
//			ecb.setEmailID(e.getEmailID());
//			ecb.setEmployeeId(e.getEmployeeId());
//			ecb.setFirstName(e.getFirstName());
//			ecb.setLastName(e.getLastName());
//			ecb.setManagerFlag(e.getManagerFlag());
//			ecb.setManagerId(e.getManagerId());
//			ecb.setProjects(e.getProjects());
//			ecb.setUserRoll(e.getUserRoll());
////			System.out.println(ecb.getCheckControl());
////			System.out.println(ecb.getEmailID());
////			System.out.println(ecb.getFirstName());
////			System.out.println(ecb.getActiveFlag());
//			
//			empToApprove.add(ecb);
//		}
//	}

	

	
	
}

