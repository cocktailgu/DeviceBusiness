package com.msdatabase.obj;

public class fdd_device {
	private int n_device_id;
	private String c_device_code;
	private String c_device_name;
	private int n_device_type_id;
	private int n_device_use_type;
	private int n_manage_type_id;
	private int n_money_type;
	private int n_device_status;
	private int n_is_fixup;
	private int n_is_iccard_manage;
	private int n_icard_type;
	private int n_is_grade;
	private int n_computation_unit;
	private int n_computation_cell;
	private int n_unit_price;
	private int n_start_price;
	private int n_start_unit;
	private int n_use_interval_time;
	private int n_timeseg_main_id;
	private int n_grade_main_id;
	private int n_cancel_preapply_id;
	private int n_apply_id;
	private int n_use_time;
	private int n_valid_flag;
	private String c_comments;
	private int n_overtime_main_id;
	private int n_late_main_id;
	private int n_use_timeseg_main_id;
	private int n_day_hours;
	
	public fdd_device(){
		
	}
	
	public fdd_device(int nDeviceId, String cDeviceCode, String cDeviceName,
			int nDeviceTypeId, int nDeviceUseType, int nManageTypeId,
			int nMoneyType, int nDeviceStatus, int nIsFixup,
			int nIsIccardManage, int nIcardType, int nIsGrade,
			int nComputationUnit, int nComputationCell, int nUnitPrice,
			int nStartPrice, int nStartUnit, int nUseIntervalTime,
			int nTimesegMainId, int nGradeMainId, int nCancelPreapplyId,
			int nApplyId, int nUseTime, int nValidFlag, String cComments,
			int nOvertimeMainId, int nLateMainId, int nUseTimesegMainId,
			int nDayHours) {
		super();
		n_device_id = nDeviceId;
		c_device_code = cDeviceCode;
		c_device_name = cDeviceName;
		n_device_type_id = nDeviceTypeId;
		n_device_use_type = nDeviceUseType;
		n_manage_type_id = nManageTypeId;
		n_money_type = nMoneyType;
		n_device_status = nDeviceStatus;
		n_is_fixup = nIsFixup;
		n_is_iccard_manage = nIsIccardManage;
		n_icard_type = nIcardType;
		n_is_grade = nIsGrade;
		n_computation_unit = nComputationUnit;
		n_computation_cell = nComputationCell;
		n_unit_price = nUnitPrice;
		n_start_price = nStartPrice;
		n_start_unit = nStartUnit;
		n_use_interval_time = nUseIntervalTime;
		n_timeseg_main_id = nTimesegMainId;
		n_grade_main_id = nGradeMainId;
		n_cancel_preapply_id = nCancelPreapplyId;
		n_apply_id = nApplyId;
		n_use_time = nUseTime;
		n_valid_flag = nValidFlag;
		c_comments = cComments;
		n_overtime_main_id = nOvertimeMainId;
		n_late_main_id = nLateMainId;
		n_use_timeseg_main_id = nUseTimesegMainId;
		n_day_hours = nDayHours;
	}
	
	public int getN_device_id() {
		return n_device_id;
	}
	public void setN_device_id(int nDeviceId) {
		n_device_id = nDeviceId;
	}
	public String getC_device_code() {
		return c_device_code;
	}
	public void setC_device_code(String cDeviceCode) {
		c_device_code = cDeviceCode;
	}
	public String getC_device_name() {
		return c_device_name;
	}
	public void setC_device_name(String cDeviceName) {
		c_device_name = cDeviceName;
	}
	public int getN_device_type_id() {
		return n_device_type_id;
	}
	public void setN_device_type_id(int nDeviceTypeId) {
		n_device_type_id = nDeviceTypeId;
	}
	public int getN_device_use_type() {
		return n_device_use_type;
	}
	public void setN_device_use_type(int nDeviceUseType) {
		n_device_use_type = nDeviceUseType;
	}
	public int getN_manage_type_id() {
		return n_manage_type_id;
	}
	public void setN_manage_type_id(int nManageTypeId) {
		n_manage_type_id = nManageTypeId;
	}
	public int getN_money_type() {
		return n_money_type;
	}
	public void setN_money_type(int nMoneyType) {
		n_money_type = nMoneyType;
	}
	public int getN_device_status() {
		return n_device_status;
	}
	public void setN_device_status(int nDeviceStatus) {
		n_device_status = nDeviceStatus;
	}
	public int getN_is_fixup() {
		return n_is_fixup;
	}
	public void setN_is_fixup(int nIsFixup) {
		n_is_fixup = nIsFixup;
	}
	public int getN_is_iccard_manage() {
		return n_is_iccard_manage;
	}
	public void setN_is_iccard_manage(int nIsIccardManage) {
		n_is_iccard_manage = nIsIccardManage;
	}
	public int getN_icard_type() {
		return n_icard_type;
	}
	public void setN_icard_type(int nIcardType) {
		n_icard_type = nIcardType;
	}
	public int getN_is_grade() {
		return n_is_grade;
	}
	public void setN_is_grade(int nIsGrade) {
		n_is_grade = nIsGrade;
	}
	public int getN_computation_unit() {
		return n_computation_unit;
	}
	public void setN_computation_unit(int nComputationUnit) {
		n_computation_unit = nComputationUnit;
	}
	public int getN_computation_cell() {
		return n_computation_cell;
	}
	public void setN_computation_cell(int nComputationCell) {
		n_computation_cell = nComputationCell;
	}
	public int getN_unit_price() {
		return n_unit_price;
	}
	public void setN_unit_price(int nUnitPrice) {
		n_unit_price = nUnitPrice;
	}
	public int getN_start_price() {
		return n_start_price;
	}
	public void setN_start_price(int nStartPrice) {
		n_start_price = nStartPrice;
	}
	public int getN_start_unit() {
		return n_start_unit;
	}
	public void setN_start_unit(int nStartUnit) {
		n_start_unit = nStartUnit;
	}
	public int getN_use_interval_time() {
		return n_use_interval_time;
	}
	public void setN_use_interval_time(int nUseIntervalTime) {
		n_use_interval_time = nUseIntervalTime;
	}
	public int getN_timeseg_main_id() {
		return n_timeseg_main_id;
	}
	public void setN_timeseg_main_id(int nTimesegMainId) {
		n_timeseg_main_id = nTimesegMainId;
	}
	public int getN_grade_main_id() {
		return n_grade_main_id;
	}
	public void setN_grade_main_id(int nGradeMainId) {
		n_grade_main_id = nGradeMainId;
	}
	public int getN_cancel_preapply_id() {
		return n_cancel_preapply_id;
	}
	public void setN_cancel_preapply_id(int nCancelPreapplyId) {
		n_cancel_preapply_id = nCancelPreapplyId;
	}
	public int getN_apply_id() {
		return n_apply_id;
	}
	public void setN_apply_id(int nApplyId) {
		n_apply_id = nApplyId;
	}
	public int getN_use_time() {
		return n_use_time;
	}
	public void setN_use_time(int nUseTime) {
		n_use_time = nUseTime;
	}
	public int getN_valid_flag() {
		return n_valid_flag;
	}
	public void setN_valid_flag(int nValidFlag) {
		n_valid_flag = nValidFlag;
	}
	public String getC_comments() {
		return c_comments;
	}
	public void setC_comments(String cComments) {
		c_comments = cComments;
	}
	public int getN_overtime_main_id() {
		return n_overtime_main_id;
	}
	public void setN_overtime_main_id(int nOvertimeMainId) {
		n_overtime_main_id = nOvertimeMainId;
	}
	public int getN_late_main_id() {
		return n_late_main_id;
	}
	public void setN_late_main_id(int nLateMainId) {
		n_late_main_id = nLateMainId;
	}
	public int getN_use_timeseg_main_id() {
		return n_use_timeseg_main_id;
	}
	public void setN_use_timeseg_main_id(int nUseTimesegMainId) {
		n_use_timeseg_main_id = nUseTimesegMainId;
	}
	public int getN_day_hours() {
		return n_day_hours;
	}
	public void setN_day_hours(int nDayHours) {
		n_day_hours = nDayHours;
	}
	@Override
	public String toString() {
		return "fdd_device [c_comments=" + c_comments + ", c_device_code="
				+ c_device_code + ", c_device_name=" + c_device_name
				+ ", n_apply_id=" + n_apply_id + ", n_cancel_preapply_id="
				+ n_cancel_preapply_id + ", n_computation_cell="
				+ n_computation_cell + ", n_computation_unit="
				+ n_computation_unit + ", n_day_hours=" + n_day_hours
				+ ", n_device_id=" + n_device_id + ", n_device_status="
				+ n_device_status + ", n_device_type_id=" + n_device_type_id
				+ ", n_device_use_type=" + n_device_use_type
				+ ", n_grade_main_id=" + n_grade_main_id + ", n_icard_type="
				+ n_icard_type + ", n_is_fixup=" + n_is_fixup + ", n_is_grade="
				+ n_is_grade + ", n_is_iccard_manage=" + n_is_iccard_manage
				+ ", n_late_main_id=" + n_late_main_id + ", n_manage_type_id="
				+ n_manage_type_id + ", n_money_type=" + n_money_type
				+ ", n_overtime_main_id=" + n_overtime_main_id
				+ ", n_start_price=" + n_start_price + ", n_start_unit="
				+ n_start_unit + ", n_timeseg_main_id=" + n_timeseg_main_id
				+ ", n_unit_price=" + n_unit_price + ", n_use_interval_time="
				+ n_use_interval_time + ", n_use_time=" + n_use_time
				+ ", n_use_timeseg_main_id=" + n_use_timeseg_main_id
				+ ", n_valid_flag=" + n_valid_flag + "]";
	}
	
	
}
