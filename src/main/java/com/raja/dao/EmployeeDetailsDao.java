package com.raja.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.DepartmentDetails;
import com.raja.model.EmployeeDetails;
import com.raja.util.ConnectionUtil;

public class EmployeeDetailsDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(EmployeeDetails employee) {

		String sql = "insert into employee_details(employee_id,employee_name,employee_e-mail,employee_Password,department_id) values(?,?,?,?,?)";
		Object[] params = {employee.getEmployeeId(),employee.getEmployeeName(),employee.getEmployeeMail(),employee.getEmployeePass(),employee.getDepartmentId()};
		jdbcTemplate.update(sql, params);
		
		}
	public void update(EmployeeDetails employee) {

		String sql = "update employee_details set department_id=?,roles=?,employee_name=?,employee_e-mail=?,employee_password=? where employee_id=?";
		Object[] params = {employee.getEmployeeId(),employee.getEmployeeName(),employee.getEmployeeMail(),employee.getEmployeePass(),employee.getDepartmentId(),employee.getRoles()};
		jdbcTemplate.update(sql, params);
		
		}

	public void delete(EmployeeDetails employee) {

		String sql = "delete from employee_details where employee_e-mail=?";
		Object[] params = {employee.getEmployeeMail()};
		jdbcTemplate.update(sql, params);
		
		}
	
	private EmployeeDetails convert(ResultSet rs) throws SQLException
	{
		
		
			DepartmentDetails dept=new DepartmentDetails();
			dept.setDepartmentId(rs.getInt("department_id"));
		
			EmployeeDetails employee = new EmployeeDetails();
			employee.setEmployeeName((rs.getString("employee_name")));
			employee.setEmployeeMail(rs.getString("employee_e-mail"));
			employee.setEmployeePass(rs.getString("employee_password"));
			employee.setEmployeeActive(rs.getString("employee_active"));
			employee.setDepartmentId(dept);
			return employee;
			
		};
	
	public EmployeeDetails findone()
	{
		String sql = "select * from employee_details where employee_id=?";
		
		return (EmployeeDetails) jdbcTemplate.queryForObject(sql, (rs,rowNum) -> convert(rs));
	}
	public EmployeeDetails list()
	{
		String sql = "select * from employee_details";
		
		return (EmployeeDetails) jdbcTemplate.queryForObject(sql, (rs,rowNum) -> convert(rs));
	}
	
}
