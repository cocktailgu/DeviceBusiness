package com.msdatabase.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.msdatabase.DBUtil;
import com.msdatabase.obj.dd_user;

public class DdUserDao {
	private QueryRunner runner=null;
	public DdUserDao() {
		runner = new QueryRunner();		
	}
	
	public int add(dd_user dduser) throws SQLException{
		String sql = "insert into dd_use (n_use_id, n_use_status, n_use_type, n_device_type_id, " +
				"c_device_code, n_device_id, n_money_type, d_use_begin_time, n_use_dept_id, " +
				"n_use_column_id, c_use_person_id, n_team_id, n_manage_type) values " +
				" (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return runner.update(DBUtil.getConnection(), sql,dduser.getN_use_id(),dduser.getN_use_status(),
				dduser.getN_use_type(),dduser.getN_device_type_id(),dduser.getC_device_code(),
				dduser.getN_device_id(),dduser.getN_money_type(),dduser.getD_use_begin_time(),
				dduser.getN_use_dept_id(),dduser.getN_use_column_id(),dduser.getC_use_person_id(),
				dduser.getN_team_id(),dduser.getN_manage_type());
	}
	
	public Long MaxDDuserId() throws SQLException{
		String sql = "select max(n_use_id) from dd_use";
		BigDecimal tmpBigDecimal =  runner.query(DBUtil.getConnection(), sql, new ScalarHandler<BigDecimal>());
		return tmpBigDecimal.longValue();
	}
	
	public int FindByUserCode(String usecode) throws SQLException{
		String sqlString= "select n_use_id from dd_use where n_use_status = 1 and c_use_person_id = ?";
		BigDecimal tmpBigDecimal = runner.query(DBUtil.getConnection(), sqlString, new ScalarHandler<BigDecimal>(), usecode);
		if (tmpBigDecimal!= null){
			return 1;
		} else {
			return 0;
		}
	}
	
	public dd_user FindByDdUseId(Long dduseid) throws SQLException{
		String sql = "select * from dd_use where n_use_id = ?";
		return runner.query(DBUtil.getConnection(), sql, new BeanHandler<dd_user>(dd_user.class), dduseid);
	}
	
	public int UpdateDDuser(dd_user dduser)throws SQLException{
		String sql = "update dd_use set n_use_status =? , d_return_time=? , n_original_use_money =? , " +
				" n_modify_use_money =? , n_use_time_length=? where n_use_id =? ";
		return runner.update(DBUtil.getConnection(), sql,dduser.getN_use_status(),dduser.getD_return_time(),
				dduser.getN_original_use_money(),dduser.getN_modify_use_money(),dduser.getN_use_time_length(),
				dduser.getN_use_id());
	}
}
