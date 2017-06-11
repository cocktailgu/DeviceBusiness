package com.common;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.msdatabase.dao.DdUserDao;
import com.msdatabase.dao.F_userDao2;
import com.msdatabase.dao.Fdd_deviceDao;
import com.msdatabase.dao.UseDeviceUserDao;
import com.msdatabase.dao.UserAndColumnDao;
import com.msdatabase.obj.UseDeviceUser;
import com.msdatabase.obj.UserAndColumn;
import com.msdatabase.obj.dd_user;
import com.msdatabase.obj.f_user;
import com.msdatabase.obj.fdd_device;
import com.view.LoginForm;

public class LoginControlOper {
	
	public static List<UserAndColumn> FindColumnByName(String username){
		UserAndColumnDao userColumnDao = new UserAndColumnDao();
		if (username.length()==9){
			username = username.substring(0, 5);
		}
		try {
			List<UserAndColumn> mmAndColumns = userColumnDao.findByName(username);
			return mmAndColumns;
			//System.out.println(mmAndColumns);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	public static String[] GetColumn(String username){
		List<UserAndColumn> userandcolumns = FindColumnByName(username);
		int size = userandcolumns.size();
		if (size > 0){
			String[] columns = new String[size];
			for (int i=0;i<userandcolumns.size();i++){
				columns[i] = userandcolumns.get(i).getColumnname();
			}
			return columns;
		} else {
			return null;
		}
	}
	
	public static fdd_device GetOneDeviceInfo(String hostname){
		Fdd_deviceDao fdd = new Fdd_deviceDao();
		try {
			return fdd.findByNameOneDevice(hostname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static int InsertDDuser(String deivcename,String usercode,int column_id){
		DdUserDao ddusedao = new DdUserDao();
		dd_user dduser = new dd_user();
		Fdd_deviceDao fdddao = new Fdd_deviceDao();		
		F_userDao2 fuser = new F_userDao2();
		
		dduser.setN_use_status(1);
		dduser.setN_use_type(1);
		dduser.setN_money_type(1);
		Calendar rightNow=Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m:s");  
	    String demo = sdf.format(rightNow.getTime()); 
		dduser.setD_use_begin_time(demo);
		dduser.setN_use_column_id(column_id);
		dduser.setN_team_id(1);
		dduser.setN_manage_type(1);
		Long maxidLong ;
		//dduser.setN_use_id(nUseId)
		try {
			maxidLong = ddusedao.MaxDDuserId();
			maxidLong = maxidLong +1;
			dduser.setN_use_id(maxidLong);
			LoginForm.dduseid = maxidLong;
			fdd_device device = fdddao.findByNameOneDevice(deivcename);
			f_user f = fuser.findByCode(usercode);
			dduser.setN_device_type_id(device.getN_device_type_id());
			dduser.setC_device_code(device.getC_device_code());
			dduser.setN_device_id(device.getN_device_id());
			dduser.setN_use_dept_id(f.getN_dept_id());
			dduser.setC_use_person_id(f.getC_user_id());
			return ddusedao.add(dduser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void SetdeviceStatusUp(String hostname){
		Fdd_deviceDao fdddao = new Fdd_deviceDao();
		try {
			fdddao.UpdateDeviceStatus(1,hostname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void SetdeviceStatusDown(String hostname){
		Fdd_deviceDao fdddao = new Fdd_deviceDao();
		try {
			fdddao.UpdateDeviceStatus(0,hostname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int JudgeReLogin(String usercode){
		DdUserDao ddusedao = new DdUserDao();
		try {
			return ddusedao.FindByUserCode(usercode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
