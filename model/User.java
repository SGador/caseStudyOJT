package com.ibm.achievement.dao.model;

public class User {
		String emailId;
		String passwd;
		String role;
		String activFlg;
		
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPasswd() {
			return passwd;
		}
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getActivFlg() {
			return activFlg;
		}
		public void setActivFlg(String activFlg) {
			this.activFlg = activFlg;
		}
}
