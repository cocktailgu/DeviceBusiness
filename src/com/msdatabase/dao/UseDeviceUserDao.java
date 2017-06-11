package com.msdatabase.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.msdatabase.JdbcTemplate;
import com.msdatabase.baseImp.ResultSetHandler;
import com.msdatabase.obj.UseDeviceUser;

public class UseDeviceUserDao {
	private QueryRunner runner;
	private JdbcTemplate jdbctemp;
	
	public UseDeviceUserDao(){
		runner = new QueryRunner();
		jdbctemp = new JdbcTemplate();
	}
	
	@SuppressWarnings("unchecked")
	public List<UseDeviceUser> GetInfoFromHosts(String[] hostname){
		String inwhere = "";
		for (int i=0;i<hostname.length;i++){
			inwhere =inwhere + "'"+hostname[i].toString()+"',";
		}
		inwhere = inwhere.substring(0, inwhere.length()-1);
		String sqlString = "SELECT a.n_use_id AS nuseid, a.n_use_status AS nusestatus, "+
						   "a.n_device_id AS ndeviceid, b.c_device_name AS cdevicename, "+
						   "b.c_device_code AS cdevicecode, c.c_user_id AS cuserid, "+ 
						   "c.c_user_name AS cusername, c.n_dept_id AS ndeptid, "+ 
						   "c.c_user_code AS cusercode "+
						   "FROM dd_use a LEFT OUTER JOIN " +
						   "fdd_device b ON a.n_device_id = b.n_device_id LEFT OUTER JOIN "+
						   "f_user c ON a.c_use_person_id = c.c_user_id "+
						   "WHERE (a.n_use_status = 1) AND (b.c_device_name in("+inwhere+" ))";
		return (List<UseDeviceUser>)jdbctemp.query(sqlString, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				UseDeviceUser usedeviceuser = null;
				List<UseDeviceUser> usedeviceusers = new ArrayList<UseDeviceUser>();
				while (rs.next()){
					usedeviceuser = new UseDeviceUser();
					usedeviceuser.setNuseid(rs.getLong("nuseid"));
					usedeviceuser.setNusestatus(rs.getInt("nusestatus"));
					usedeviceuser.setNdeviceid(rs.getInt("ndeviceid"));
					usedeviceuser.setCdevicename(rs.getString("cdevicename"));
					usedeviceuser.setCdevicecode(rs.getString("cdevicecode"));
					usedeviceuser.setCuserid(rs.getString("cuserid"));
					usedeviceuser.setCusername(rs.getString("cusername"));
					usedeviceuser.setNdeptid(rs.getInt("ndeptid"));
					usedeviceuser.setCusercode(rs.getString("cusercode"));
					usedeviceusers.add(usedeviceuser);
				}
				return usedeviceusers;
			}
		}, null);
	}
}
