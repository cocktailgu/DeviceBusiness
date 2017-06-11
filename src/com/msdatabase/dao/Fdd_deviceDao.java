package com.msdatabase.dao;

import java.sql.SQLException;
import java.util.List;

import com.msdatabase.DBUtil;
import com.msdatabase.obj.*;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class Fdd_deviceDao {
	private QueryRunner runner = null;
	
	public Fdd_deviceDao(){
		runner = new QueryRunner();
	}
	
	public List<fdd_device> findByName(String[] hostname) throws SQLException{
		String inwhere = "";
		for (int i=0;i<hostname.length;i++){
			inwhere =inwhere + "'"+hostname[i].toString()+"',";
		}
		inwhere = inwhere.substring(0, inwhere.length()-1);
		String Sql = "select n_device_id,c_device_code,c_device_name,n_device_status,n_money_type," +
				"n_unit_price,n_start_price,n_start_unit" +
				" from fdd_device where c_device_name in ("+inwhere+") order by c_device_name asc";
		//System.out.println(Sql);
		return (List<fdd_device>)runner.query(DBUtil.getConnection(), Sql, new BeanListHandler<fdd_device>(fdd_device.class));
		//return null;
	}
	
	public fdd_device findByNameOneDevice (String hostname) throws SQLException{
		String sql = "select top 1 * from fdd_device where c_device_name = ?";
		return (fdd_device)runner.query(DBUtil.getConnection(), sql, new BeanHandler<fdd_device>(fdd_device.class), hostname);
	}
	
	public void UpdateDeviceStatus(int status,String hostname) throws SQLException{
		String sql = "UPDATE fdd_device SET n_device_status = ? WHERE c_device_name = ?";
		runner.update(DBUtil.getConnection(), sql, status,hostname);
	}
}
