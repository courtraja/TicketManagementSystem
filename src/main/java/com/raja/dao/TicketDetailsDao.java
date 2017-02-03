package com.raja.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.DepartmentDetails;
import com.raja.model.EmployeeDetails;
import com.raja.model.TicketDetails;
import com.raja.model.UserDetails;
import com.raja.util.ConnectionUtil;

public class TicketDetailsDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(TicketDetails ticket) {

		String sql = "insert into ticket_details(user_id,subject,description,assigned_employee) values(?,?,?,?)";
		Object[] params = {ticket.getUserId(),ticket.getSubject(),ticket.getDescription(),ticket.getEmployeeId()};
		jdbcTemplate.update(sql, params);
		
		}
	public void update(TicketDetails ticket) {

		String sql = "update ticket_details set description=? where user_id=?";
		Object[] params = {ticket.getDescription(),ticket.getUserId()};
		jdbcTemplate.update(sql, params);
		
		}

	public void delete(TicketDetails ticket) {

		String sql = "delete from ticket_details where user_id=?";
		Object[] params = {ticket.getUserId()};
		jdbcTemplate.update(sql, params);
		
		}
	
	private TicketDetails convert(ResultSet rs) throws SQLException
	{
		
		
			TicketDetails ticket = new TicketDetails();
			UserDetails user=new UserDetails();
			user.setUserId(rs.getInt("user_id"));
			TicketDetails ticket1=new TicketDetails();
			EmployeeDetails employ=new EmployeeDetails();
			employ.setEmployeeId(rs.getInt("assigned_employee"));
			
			DepartmentDetails dept=new DepartmentDetails();
			dept.setDepartmentId(rs.getInt("department_id"));
			
			
			ticket1.setId(rs.getInt("id"));
			ticket1.setUserId(user);
			ticket1.setDepartmentId(dept);
			ticket1.setSubject(rs.getString("subject"));
			ticket1.setDescription(rs.getString("description"));
			ticket1.setEmployeeId(employ);
			ticket1.setCreatedTime((rs.getTimestamp("created_time")).toLocalDateTime());
			ticket1.setStatus(rs.getString("status"));
			ticket1.setModifiedTime(rs.getTimestamp("modified_time").toLocalDateTime());
			return ticket1;
			
		};
	
	public TicketDetails findone()
	{
		String sql = "select select * from TicketDetails where issue_id=?";
		
		return (TicketDetails) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	public List<TicketDetails> list()
	{
		String sql = "select select * from TicketDetails";
		
		return (List<TicketDetails>) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
}
