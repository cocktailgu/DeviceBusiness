package com.msdatabase.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.msdatabase.DBUtil;
import com.msdatabase.obj.f_user;

public class F_userDao2 {
	private QueryRunner runner = null;
	
	public F_userDao2(){
		runner = new QueryRunner(); 
	}
	
	public void add (f_user f) throws SQLException{
		String sqlString = "insert into f_user (c_user_id,c_user_name,n_dept_id,n_valid_flag,c_user_code) values" +
				" (?,?,?,?,?)";
		runner.update(DBUtil.getConnection(), sqlString, f.getC_user_id(),f.getC_user_name(),f.getN_dept_id(),
				f.getN_valid_flag(),f.getC_user_code());
	}
	
	public void update(f_user f) throws SQLException{
		String sqlString = "update f_user set c_user_name=?,c_user_code=? where c_user_id=?";
		runner.update(DBUtil.getConnection(), sqlString, f.getC_user_name(),f.getC_user_code(),f.getC_user_id());
	}
	
	public void delete(String c_user_id) throws SQLException{
		String sqlString = "delete from f_user where c_user_id = ?";
		runner.update(DBUtil.getConnection(), sqlString, c_user_id);
	}
	
	public f_user findByName(String username) throws SQLException{
		String sqlString = "select c_user_id,c_user_name,n_dept_id,n_valid_flag,c_user_code from f_user where c_user_name = ?";
		f_user fu = runner.query(DBUtil.getConnection(), sqlString, new BeanHandler<f_user>(f_user.class), username);
		return fu;
	}
	
	public List<f_user> findAll() throws SQLException{
		String sqlString = "select top 100 c_user_id,c_user_name,n_dept_id,n_valid_flag,c_user_code from f_user ";
		List<f_user> fs = runner.query(DBUtil.getConnection(), sqlString, new BeanListHandler<f_user>(f_user.class));
		return fs;
	}
	
	public int f_usercnt() throws SQLException{
		String sql = "select count(*) from f_user";
		return runner.query(DBUtil.getConnection(), sql, new ScalarHandler<Integer>());
	}
	
	public f_user findByCode(String userid) throws SQLException{
		String sqlString = "select * from f_user where c_user_id = ?";
		f_user fu = runner.query(DBUtil.getConnection(), sqlString, new BeanHandler<f_user>(f_user.class), userid);
		return fu;
	}
}
