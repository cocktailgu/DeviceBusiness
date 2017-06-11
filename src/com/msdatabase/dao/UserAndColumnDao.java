package com.msdatabase.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.msdatabase.DBUtil;
import com.msdatabase.JdbcTemplate;
import com.msdatabase.baseImp.ResultSetHandler;
import com.msdatabase.obj.UserAndColumn;
import com.msdatabase.obj.f_user;
public class UserAndColumnDao {
	private QueryRunner runner = null;
	private JdbcTemplate jdbctemp;

	public UserAndColumnDao() {
		runner = new QueryRunner();
		jdbctemp = new JdbcTemplate();
	}
	
	public List<UserAndColumn> getUserAndColumns (String username) throws SQLException{
		String sqlString = "select c.n_column_id as columnid,c.c_column_name as columnname,b.c_user_id as userid" +
						   ",b.c_user_name as c_user_name , b.c_user_code as c_user_code "+
						   " from f_user_column as a "+
						   " left join f_user as b on a.c_user_id = b.c_user_id"+ 
						   " left join f_column as c on a.n_column_id = c.n_column_id"+
						   " where c.n_valid_flag = 1 and b.n_valid_flag = 1 and " +
						   " (c_user_name = ? or c_user_code =?)";

		List<UserAndColumn> fs = runner.query(DBUtil.getConnection(), sqlString, new BeanListHandler<UserAndColumn>(UserAndColumn.class),username,username);
		return fs;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserAndColumn> findByName (final String user_name) throws SQLException {
		System.out.println(user_name);
		String sqlString = "select c.n_column_id as columnid,c.c_column_name as columnname,b.c_user_id as userid" +
		   ",b.c_user_name as c_user_name , b.c_user_code as c_user_code "+
		   " from f_user_column as a "+
		   " left join f_user as b on a.c_user_id = b.c_user_id"+ 
		   " left join f_column as c on a.n_column_id = c.n_column_id"+
		   " where c.n_valid_flag = 1 and b.n_valid_flag = 1 and " +
		   " (b.c_user_name = ? or b.c_user_code =? or b.c_user_id = ?)";
		System.out.println(sqlString);
		return (List<UserAndColumn>)jdbctemp.query(sqlString, new ResultSetHandler() {
			@Override
			public Object doHandler(ResultSet rs)throws SQLException {
				UserAndColumn userandcolum = null;
				List<UserAndColumn> userandcolums = new ArrayList<UserAndColumn>();
				while (rs.next()){
					userandcolum = new UserAndColumn();
					userandcolum.setColumnid(rs.getInt("columnid"));
					userandcolum.setColumnname(rs.getString("columnname"));
					userandcolum.setC_user_code(rs.getString("c_user_code"));
					userandcolum.setC_user_name(rs.getString("c_user_name"));
					userandcolum.setUserid(rs.getString("userid"));
					userandcolums.add(userandcolum);
				}
				return userandcolums;
			}
		}, user_name,user_name,user_name);
	}
}
