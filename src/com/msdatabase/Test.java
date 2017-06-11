package com.msdatabase;

import com.common.DealDataHD;
import com.common.LoginControlOper;
import com.msdatabase.obj.*;
import com.msdatabase.dao.*;
import com.view.LoginForm;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jxl.write.DateTime;


import oracle.net.aso.f;

public class Test {

	/**
	 * @param args
	 */
	
	public static void findAll(){
		/*Connection conn = DBUtil.getConnection();
		String sql = "select c_user_id,c_user_name,n_dept_id,n_valid_flag,c_user_code from f_user";
		try{
			PreparedStatement ps =  conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				f_user user = new f_user();
				user.setC_user_code(rs.getString("c_user_code"));
				user.setC_user_id(rs.getString("c_user_id"));
				user.setC_user_name(rs.getString("c_user_name"));
				user.setN_dept_id(rs.getInt("n_dept_id"));
				user.setN_valid_flag(rs.getInt("n_valid_flag"));
				System.out.println(user.toString());
			}
		} catch (SQLException e){
			e.printStackTrace();
		}*/
		f_userDao fudao = new f_userDao();
		try {
			List<f_user> f = fudao.findAll();
			//System.out.println(f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException {
		//Test.findAll();
		/*f_userDao fuDao = new f_userDao();
		f_user f = null;
		try {
			fuDao.add(new f_user("90901", "ÄãºÃºÃ", 5, 0, "9090"));
			f = fuDao.findByName("¹Ë¼ÎÎÄ");
			List<f_user> fs= fuDao.findAll();
			System.out.println(fs);
			fuDao.update(f)
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		/*F_userDao2 fUserDao2 = new F_userDao2();
		try {
			int d = fUserDao2.f_usercnt();
			System.out.println(d);
			List<f_user> x= fUserDao2.findAll();
			System.out.println(x);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		/*
		Fdd_deviceDao fdddaoDao = new Fdd_deviceDao();
		String[] hostname = new String[] {"HD-1","HD-2","HD-3","HD-4","HD-5","HD-6","HD-7","HD-8","HD-9" 
				,"HD-10","HD-11","HD-12","HD-13","HD-14"};
		try {
			List<fdd_device> x =  fdddaoDao.findByName(hostname);
			int[] hoststatus = DealDataHD.DealDeviceHost(x);
			for (int l=0;l<hoststatus.length;l++){
				System.out.println(l+":"+hoststatus[l]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*
		UserAndColumnDao userColumnDao = new UserAndColumnDao();
		try {
			List<UserAndColumn> mmAndColumns = userColumnDao.findByName("Ðì½ú");
			System.out.println(mmAndColumns);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		/*Fdd_deviceDao fdd =new Fdd_deviceDao();
		try {
			fdd_device x = fdd.findByNameOneDevice("HD-1");
			System.out.println(x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*DdUserDao d = new DdUserDao();
		try {
			Long xBigDecimal = d.MaxDDuserId();
			System.out.println(d.MaxDDuserId().toString());
			System.out.println((xBigDecimal+1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*
		Calendar rightNow=Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m:s");  
	    String demo = sdf.format(rightNow.getTime());  
		System.out.println(demo);
		x.setD_use_begin_time(rightNow.getTime());
		*/
		/*F_userDao2 fUserDao2 = new F_userDao2();
		try {
			f_user x = fUserDao2.findByCode("80002");
			System.out.println(x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*UseDeviceUserDao ff = new UseDeviceUserDao();
		List<UseDeviceUser> xx= ff.GetInfoFromHosts(LoginForm.hostname);
		for (int i=0;i<xx.size();i++){
			UseDeviceUser xDeviceUser = xx.get(i);
			System.out.println(xDeviceUser.getNuseid());
			System.out.println(xDeviceUser.getCdevicename()+xDeviceUser.getCusername());
		}*/
		
		/*DdUserDao dduse = new DdUserDao();
		System.out.println(dduse.FindByUserCode("84138"));
		*/
		/*
		Calendar rightNow=Calendar.getInstance();
		String dateString ="2017-05-19 16:30:00"; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date x = sdf.parse(dateString);
			System.out.println(x.getTime());
			System.out.println((rightNow.getTimeInMillis()-x.getTime())/1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}

}
