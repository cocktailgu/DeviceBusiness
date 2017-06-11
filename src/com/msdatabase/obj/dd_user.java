package com.msdatabase.obj;

import java.math.BigDecimal;
import java.util.Date;

public class dd_user {
	private Long n_use_id;
	private int n_dispatch_id;
	private int n_bill_id;
	private int n_use_status;
	private int n_use_type;
	private int n_device_type_id;
	private String c_device_code;
	private int n_device_id;
	private int n_money_type;
	private Float n_original_use_money;
	private Float n_modify_use_money;
	private Float n_difference_money;
	private String d_use_begin_time;
	private String d_use_end_time;
	private Long n_use_time_length;
	private int n_grade_detail_id;
	private int n_use_dept_id;
	private int n_use_channel_id;
	private int n_use_column_id;
	private String c_use_person_id;
	private String c_return_man;
	private int n_is_check_out;
	private int n_is_print_bill;
	private String d_return_time;
	private String c_comments;
	private int n_manage_dept_id;
	private int n_team_id;
	private int n_is_have_slave;
	private String c_program_name;
	private int n_manage_type;
	private int n_device_amount;
	private int is_send;
	
	public dd_user(){
		
	}
	
	
	public Long getN_use_id() {
		return n_use_id;
	}
	public void setN_use_id(Long bigDecimal) {
		n_use_id = bigDecimal;
	}
	public int getN_dispatch_id() {
		return n_dispatch_id;
	}
	public void setN_dispatch_id(int nDispatchId) {
		n_dispatch_id = nDispatchId;
	}
	public int getN_bill_id() {
		return n_bill_id;
	}
	public void setN_bill_id(int nBillId) {
		n_bill_id = nBillId;
	}
	public int getN_use_status() {
		return n_use_status;
	}
	public void setN_use_status(int nUseStatus) {
		n_use_status = nUseStatus;
	}
	public int getN_use_type() {
		return n_use_type;
	}
	public void setN_use_type(int nUseType) {
		n_use_type = nUseType;
	}
	public int getN_device_type_id() {
		return n_device_type_id;
	}
	public void setN_device_type_id(int nDeviceTypeId) {
		n_device_type_id = nDeviceTypeId;
	}
	public String getC_device_code() {
		return c_device_code;
	}
	public void setC_device_code(String cDeviceCode) {
		c_device_code = cDeviceCode;
	}
	public int getN_device_id() {
		return n_device_id;
	}
	public void setN_device_id(int nDeviceId) {
		n_device_id = nDeviceId;
	}
	public int getN_money_type() {
		return n_money_type;
	}
	public void setN_money_type(int nMoneyType) {
		n_money_type = nMoneyType;
	}
	public Float getN_original_use_money() {
		return n_original_use_money;
	}
	public void setN_original_use_money(Float nOriginalUseMoney) {
		n_original_use_money = nOriginalUseMoney;
	}
	public Float getN_modify_use_money() {
		return n_modify_use_money;
	}
	public void setN_modify_use_money(Float nModifyUseMoney) {
		n_modify_use_money = nModifyUseMoney;
	}
	public Float getN_difference_money() {
		return n_difference_money;
	}
	public void setN_difference_money(Float nDifferenceMoney) {
		n_difference_money = nDifferenceMoney;
	}
	public String getD_use_begin_time() {
		return d_use_begin_time;
	}
	public void setD_use_begin_time(String dUseBeginTime) {
		d_use_begin_time = dUseBeginTime;
	}
	public String getD_use_end_time() {
		return d_use_end_time;
	}
	public void setD_use_end_time(String dUseEndTime) {
		d_use_end_time = dUseEndTime;
	}
	public Long getN_use_time_length() {
		return n_use_time_length;
	}
	public void setN_use_time_length(Long nUseTimeLength) {
		n_use_time_length = nUseTimeLength;
	}
	public int getN_grade_detail_id() {
		return n_grade_detail_id;
	}
	public void setN_grade_detail_id(int nGradeDetailId) {
		n_grade_detail_id = nGradeDetailId;
	}
	public int getN_use_dept_id() {
		return n_use_dept_id;
	}
	public void setN_use_dept_id(int nUseDeptId) {
		n_use_dept_id = nUseDeptId;
	}
	public int getN_use_channel_id() {
		return n_use_channel_id;
	}
	public void setN_use_channel_id(int nUseChannelId) {
		n_use_channel_id = nUseChannelId;
	}
	public int getN_use_column_id() {
		return n_use_column_id;
	}
	public void setN_use_column_id(int nUseColumnId) {
		n_use_column_id = nUseColumnId;
	}
	public String getC_use_person_id() {
		return c_use_person_id;
	}
	public void setC_use_person_id(String cUsePersonId) {
		c_use_person_id = cUsePersonId;
	}
	public String getC_return_man() {
		return c_return_man;
	}
	public void setC_return_man(String cReturnMan) {
		c_return_man = cReturnMan;
	}
	public int getN_is_check_out() {
		return n_is_check_out;
	}
	public void setN_is_check_out(int nIsCheckOut) {
		n_is_check_out = nIsCheckOut;
	}
	public int getN_is_print_bill() {
		return n_is_print_bill;
	}
	public void setN_is_print_bill(int nIsPrintBill) {
		n_is_print_bill = nIsPrintBill;
	}
	public String getD_return_time() {
		return d_return_time;
	}
	public void setD_return_time(String dReturnTime) {
		d_return_time = dReturnTime;
	}
	public String getC_comments() {
		return c_comments;
	}
	public void setC_comments(String cComments) {
		c_comments = cComments;
	}
	public int getN_manage_dept_id() {
		return n_manage_dept_id;
	}
	public void setN_manage_dept_id(int nManageDeptId) {
		n_manage_dept_id = nManageDeptId;
	}
	public int getN_team_id() {
		return n_team_id;
	}
	public void setN_team_id(int nTeamId) {
		n_team_id = nTeamId;
	}
	public int getN_is_have_slave() {
		return n_is_have_slave;
	}
	public void setN_is_have_slave(int nIsHaveSlave) {
		n_is_have_slave = nIsHaveSlave;
	}
	public String getC_program_name() {
		return c_program_name;
	}
	public void setC_program_name(String cProgramName) {
		c_program_name = cProgramName;
	}
	public int getN_manage_type() {
		return n_manage_type;
	}
	public void setN_manage_type(int nManageType) {
		n_manage_type = nManageType;
	}
	public int getN_device_amount() {
		return n_device_amount;
	}
	public void setN_device_amount(int nDeviceAmount) {
		n_device_amount = nDeviceAmount;
	}
	public int getIs_send() {
		return is_send;
	}
	public void setIs_send(int isSend) {
		is_send = isSend;
	}
	@Override
	public String toString() {
		return "dd_user [c_comments=" + c_comments + ", c_device_code="
				+ c_device_code + ", c_program_name=" + c_program_name
				+ ", c_return_man=" + c_return_man + ", c_use_person_id="
				+ c_use_person_id + ", d_return_time=" + d_return_time
				+ ", d_use_begin_time=" + d_use_begin_time
				+ ", d_use_end_time=" + d_use_end_time + ", is_send=" + is_send
				+ ", n_bill_id=" + n_bill_id + ", n_device_amount="
				+ n_device_amount + ", n_device_id=" + n_device_id
				+ ", n_device_type_id=" + n_device_type_id
				+ ", n_difference_money=" + n_difference_money
				+ ", n_dispatch_id=" + n_dispatch_id + ", n_grade_detail_id="
				+ n_grade_detail_id + ", n_is_check_out=" + n_is_check_out
				+ ", n_is_have_slave=" + n_is_have_slave + ", n_is_print_bill="
				+ n_is_print_bill + ", n_manage_dept_id=" + n_manage_dept_id
				+ ", n_manage_type=" + n_manage_type + ", n_modify_use_money="
				+ n_modify_use_money + ", n_money_type=" + n_money_type
				+ ", n_original_use_money=" + n_original_use_money
				+ ", n_team_id=" + n_team_id + ", n_use_channel_id="
				+ n_use_channel_id + ", n_use_column_id=" + n_use_column_id
				+ ", n_use_dept_id=" + n_use_dept_id + ", n_use_id=" + n_use_id
				+ ", n_use_status=" + n_use_status + ", n_use_time_length="
				+ n_use_time_length + ", n_use_type=" + n_use_type + "]";
	}
}
