package service;

import java.util.logging.Logger;

import javax.xml.bind.ValidationException;

import com.mysql.cj.mysqlx.protobuf.MysqlxNotice.Warning.Level;

import dao.IssueDetailsDao;
import dao.TicketDetailsDao;
import model.DepartmentDetails;
import model.EmployeeDetails;
import model.TicketDetails;
import validation.TicketDetailsValidation;

public class TicketDetailsService {

	TicketDetailsValidation ticketDetailValidator=new TicketDetailsValidation();
	final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());
public void save(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.saveValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.save(ticketDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void delete(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.deleteValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		EmployeeDetails row =ticketDetailDao.checkadmin(ticketDetail.getUserId().getId());
	     ticketDetailValidator.deleteTicketAssign(row);
			IssueDetailsDao issueDao=new IssueDetailsDao();
		issueDao.deleteIssue(ticketDetail);
		ticketDetailDao.delete(ticketDetail.getId(),ticketDetail.getUserId().getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void update(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.updateValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.update(ticketDetail.getUserId().getId(), ticketDetail.getUserId().getId(),ticketDetail.getSubject());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		}
}
public void createTicket(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.createTicketValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.createticket(ticketDetail);
		
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"Exception occur", e);
	}
}
public void assignTicket(TicketDetails ticketDetail ){
	try{
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		DepartmentDetails department=new DepartmentDetails();
		EmployeeDetails row=ticketDetailDao.checkEmployee(ticketDetail.getUserId().getId(),department.getName());
		ticketDetailValidator.employeeValidation(row);
		ticketDetailDao.assignTicket(ticketDetail.getId(), ticketDetail.getAssignedTo().getId(),ticketDetail.getModifiedTime());
	}catch(ValidationException e)
	{
		logger.log(Level.SEVERE,"Exception occur", e);
	}
}
public void updateReassign(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.reassignTicket(ticketDetail.getId(), ticketDetail.getAssignedTo().getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		}
}
public void close(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.closeticketValidation(ticketDetail);
		TicketDetaislDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.closeTicket(ticketDetail.getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
	}
}

}
