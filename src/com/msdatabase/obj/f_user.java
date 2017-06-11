package com.msdatabase.obj;

public class f_user {
	private String c_user_id;
	private String c_user_name;
	private int n_dept_id;
	private int n_valid_flag;
	private String c_user_code;
	
	public f_user(){
		
	}
	
	public f_user(String cUserId, String cUserName, int nDeptId,
			int nValidFlag, String cUserCode) {
		super();
		c_user_id = cUserId;
		c_user_name = cUserName;
		n_dept_id = nDeptId;
		n_valid_flag = nValidFlag;
		c_user_code = cUserCode;
	}
	
	public String getC_user_id() {
		return c_user_id;
	}
	public void setC_user_id(String cUserId) {
		c_user_id = cUserId;
	}
	public String getC_user_name() {
		return c_user_name;
	}
	public void setC_user_name(String cUserName) {
		c_user_name = cUserName;
	}
	public int getN_dept_id() {
		return n_dept_id;
	}
	public void setN_dept_id(int nDeptId) {
		n_dept_id = nDeptId;
	}
	public int getN_valid_flag() {
		return n_valid_flag;
	}
	public void setN_valid_flag(int nValidFlag) {
		n_valid_flag = nValidFlag;
	}
	public String getC_user_code() {
		return c_user_code;
	}
	public void setC_user_code(String cUserCode) {
		c_user_code = cUserCode;
	}
	@Override
	public String toString() {
		return "f_user [c_user_code=" + c_user_code + ", c_user_id="
				+ c_user_id + ", c_user_name=" + c_user_name + ", n_dept_id="
				+ n_dept_id + ", n_valid_flag=" + n_valid_flag + "]";
	}
}
