package com.common;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jxl.write.DateTime;

import com.msdatabase.dao.DdUserDao;
import com.msdatabase.dao.Fdd_deviceDao;
import com.msdatabase.dao.UseDeviceUserDao;
import com.msdatabase.obj.UseDeviceUser;
import com.msdatabase.obj.dd_user;
import com.msdatabase.obj.fdd_device;
import com.view.IndexForm;
import com.view.LoginForm;

public class DealDataHD {
	
	public static int[] GetFdd_deviceStatus(){
		Fdd_deviceDao fdddaoDao = new Fdd_deviceDao();
		String[] hostname = new String[] {"HD-1","HD-2","HD-3","HD-4","HD-5","HD-6","HD-7","HD-8","HD-9" 
				,"HD-10","HD-11","HD-12","HD-13","HD-14"};
		try {
			List<fdd_device> x =  fdddaoDao.findByName(hostname);
			int[] hoststatus = DealDataHD.DealDeviceHost(x);
			return hoststatus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int[] DealDeviceHost(List<fdd_device> fdddevices){
		int[] hoststatus = new int[14];
		int hostindex; 
		for(int i = 0 ; i < fdddevices.size() ; i++) {
			hostindex = ReturnHostIndex(fdddevices.get(i).getC_device_name());
			if (hostindex != 0){
				hoststatus[hostindex-1] = fdddevices.get(i).getN_device_status();
			}
		}
		return hoststatus;
	}
	
	public static int ReturnHostIndex(String devicename){
		if (devicename.indexOf("HD-1")!=-1){
			return 0;
		}
		if (devicename.indexOf("HD-2")!=-1){
			return 1;
		}
		if (devicename.indexOf("HD-3")!=-1){
			return 2;
		}
		if (devicename.indexOf("HD-4")!=-1){
			return 3;
		}
		if (devicename.indexOf("HD-5")!=-1){
			return 4;
		}
		if (devicename.indexOf("HD-6")!=-1){
			return 5;
		}
		if (devicename.indexOf("HD-7")!=-1){
			return 6;
		}
		if (devicename.indexOf("HD-8")!=-1){
			return 7;
		}
		if (devicename.indexOf("HD-9")!=-1){
			return 8;
		}
		if (devicename.indexOf("HD-10")!=-1){
			return 9;
		}
		if (devicename.indexOf("HD-11")!=-1){
			return 10;
		}
		if (devicename.indexOf("HD-12")!=-1){
			return 11;
		}
		if (devicename.indexOf("HD-13")!=-1){
			return 12;
		}
		if (devicename.indexOf("HD-14")!=-1){
			return 13;
		}
		return -1;
	}
	
	public static void GetUseDeviceUser(){
		UseDeviceUserDao ff = new UseDeviceUserDao();
		List<UseDeviceUser> xx= ff.GetInfoFromHosts(IndexForm.hostname);
		int hostindex = -1;
		for (int i=0;i<xx.size();i++){
			UseDeviceUser xDeviceUser = xx.get(i);
			hostindex = ReturnHostIndex(xDeviceUser.getCdevicename());
			if (hostindex!=-1){
				IndexForm.DeviceUser[hostindex] = xDeviceUser.getCusername();
				IndexForm.DDuserId[hostindex] = xDeviceUser.getNuseid();
			}
			//System.out.println(IndexForm.DeviceUser[hostindex]);
			//System.out.println(xDeviceUser.getCdevicename()+xDeviceUser.getCusername());
		}
	}
	
	public static int LogoffTransact(int hostcode){
		if (IndexForm.DDuserId[hostcode]== null){
			return 0;
		} else {
			DdUserDao dduserdao = new DdUserDao();
			Fdd_deviceDao fddevicedao = new Fdd_deviceDao();
			dd_user ddUser = null;
			fdd_device fddevice = null;
			try {
				ddUser = dduserdao.FindByDdUseId(IndexForm.DDuserId[hostcode]);
				fddevice = fddevicedao.findByNameOneDevice(IndexForm.hostname[hostcode]);
				//System.out.println(fddevice);
				ddUser.setN_use_status(2);
				
				Calendar endtime=Calendar.getInstance(); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			    String demo = sdf.format(endtime.getTime()); 
				ddUser.setD_return_time(demo);
				
				Date begintime;
				Long timelength = null;
				try {
					begintime = sdf.parse(ddUser.getD_use_begin_time());
					timelength = (endtime.getTimeInMillis() - begintime.getTime())/1000;
				} catch (ParseException e) {
					e.printStackTrace();
				}
				float usemoney = fddevice.getN_start_price() + (timelength/(fddevice.getN_computation_cell()*60) * fddevice.getN_unit_price());
				ddUser.setN_use_time_length(timelength);
				ddUser.setN_original_use_money(usemoney);
				ddUser.setN_modify_use_money(usemoney);
				
				int IsSuccess = dduserdao.UpdateDDuser(ddUser);
				if (IsSuccess == 1){
					LoginControlOper.SetdeviceStatusDown(IndexForm.hostname[hostcode]);
				}
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
