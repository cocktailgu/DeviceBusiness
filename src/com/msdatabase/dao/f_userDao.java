package com.msdatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msdatabase.baseImp.ResultSetHandler;
import com.msdatabase.obj.f_user;
import com.msdatabase.DBUtil;
import com.msdatabase.JdbcTemplate;

public class f_userDao  {
	private JdbcTemplate jdbctemp;
	
	public f_userDao(){
		jdbctemp = new JdbcTemplate();
	}
	
	public void add (f_user f) throws SQLException{
		String sqlString = "insert into f_user (c_user_id,c_user_name,n_dept_id,n_valid_flag,c_user_code) values" +
				" (?,?,?,?,?)";
		jdbctemp.update(sqlString, f.getC_user_id(),f.getC_user_name(),f.getN_dept_id(),f.getN_valid_flag(),f.getC_user_code());
	}
	
	public void update(f_user f) throws SQLException{
		String sqlString = "update f_user set c_user_name=?,c_user_code=? where c_user_id=?";
		jdbctemp.update(sqlString, f.getC_user_name(),f.getC_user_code(),f.getC_user_id());
	}
	
	public f_user findByName (final String user_name) throws SQLException {
		String sqlString = "select c_user_id,c_user_name,n_dept_id,n_valid_flag,c_user_code from f_user " +
				" where c_user_name = ?";
		return (f_user)jdbctemp.query(sqlString, new ResultSetHandler() {
			@Override
			public Object doHandler(ResultSet rs)throws SQLException {
				f_user fUser = null;
				if (rs.next()){
					fUser = new f_user();
					fUser.setC_user_id(rs.getString("c_user_id"));
					fUser.setC_user_name(rs.getString("c_user_name"));
					fUser.setN_dept_id(rs.getInt("n_dept_id"));
					fUser.setN_valid_flag(rs.getInt("n_valid_flag"));
					fUser.setC_user_code(rs.getString("c_user_code"));
				}
				return fUser;
			}
		}, user_name);
	}
	
	@SuppressWarnings("unchecked")
	public List<f_user> findAll() throws SQLException{
		String sqlString = "select TOP 100 c_user_id,c_user_name,n_dept_id,n_valid_flag,c_user_code from f_user " +
				"where 1 = ?";
		return (List<f_user>)jdbctemp.query(sqlString, new ResultSetHandler() {
			public Object doHandler(ResultSet rs) throws SQLException {
				f_user fUser = null;
				List<f_user> fUsers = new ArrayList<f_user>();
				while (rs.next()){
					if (rs!= null){
						fUser = new f_user();
						fUser.setC_user_id(rs.getString("c_user_id"));
						fUser.setC_user_name(rs.getString("c_user_name"));
						fUser.setN_dept_id(rs.getInt("n_dept_id"));
						fUser.setN_valid_flag(rs.getInt("n_valid_flag"));
						fUser.setC_user_code(rs.getString("c_user_code"));
						fUsers.add(fUser);
					}
				}
				return fUsers;
			}
		}, 1);
	}
	
	/*old function */
	public List<f_user> oldfindAll() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		f_user fu = null;
		List<f_user> f_users = new ArrayList<f_user>();
		String sql = "select c_user_id,c_user_name,n_dept_id,n_valid_flag,c_user_code from f_user" +
				" where n_valid_flag = 1";
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()){
				fu = new f_user(null, null, 0, 0, sql);
				fu.setC_user_code(rs.getString("c_user_code"));
				fu.setC_user_id(rs.getString("c_user_id"));
				fu.setC_user_name(rs.getString("c_user_name"));
				fu.setN_dept_id(rs.getInt("n_dept_id"));
				fu.setN_valid_flag(rs.getInt("n_valid_flag"));
				f_users.add(fu);
				System.out.println(fu.toString());
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(rs, ps, conn);
		}
		return f_users;
	}
}
