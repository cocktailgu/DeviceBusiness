package com.msdatabase.obj;

public class UserAndColumn {
	private int columnid;
	private String columnname;
	private String userid;
	private String c_user_name;
	private String c_user_code;
	public int getColumnid() {
		return columnid;
	}
	public void setColumnid(int columnid) {
		this.columnid = columnid;
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getC_user_name() {
		return c_user_name;
	}
	public void setC_user_name(String cUserName) {
		c_user_name = cUserName;
	}
	public String getC_user_code() {
		return c_user_code;
	}
	public void setC_user_code(String cUserCode) {
		c_user_code = cUserCode;
	}
	@Override
	public String toString() {
		return "UserAndColumn [c_user_code=" + c_user_code + ", c_user_name="
				+ c_user_name + ", columnid=" + columnid + ", columnname="
				+ columnname + ", userid=" + userid + "]";
	}
	
	
}
