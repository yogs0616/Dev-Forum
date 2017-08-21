package netcracker.developer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import netcracker.developer.dao.RolesDao;
import netcracker.developer.jdbc.UserRowMapper;
import netcracker.developer.viewBean.RegBean;

public class RolesDaoImpl implements RolesDao {

private DataSource dataSource;
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public RegBean getUser(String emailId) {
		List<RegBean> userList = new ArrayList<RegBean>();
		String sql = "select * from user where emailId ='"+emailId+"'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		System.out.println(userList.size());
		
		
		return userList.get(0);
		
	}


	@Override
	public void updateProfile(RegBean regBean) {
		try{
		String sql = "UPDATE user set firstName = ?,lastName = ? , mobileNumber = ?  where emailId = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] {regBean.getFirstName(),regBean.getLastName(),regBean.getMobileNumber(),regBean.getEmailId()}
				);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public void changePassword(RegBean regBean,String password) {
		String sql = "UPDATE user set password= ? where emailId = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] {password,regBean.getEmailId()}
				);
	
		
	}

	@Override
	public void increaseLike(int queryId) {
		
		String query= "update queries set no_of_likes=no_of_likes+1 where queryId="+queryId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.execute(query);
	}

	
	
	
}
