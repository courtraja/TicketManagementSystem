package validation;

import java.time.LocalDateTime;

import javax.xml.bind.ValidationException;

import model.EmployeeDetails;
import model.TicketDetails;
import util.ValidationUtil;

public class TicketDetailsValidation {
public void ticketValidation(TicketDetails ticket)throws ValidationException{
	ValidationUtil.isInvalidObject(ticket, "object is empty");
}
public void idvalidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid id");
}
public void userValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid user id");
}
public void departmentValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid department");
}
public void subjectValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid subject");
}
public void descriptionValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid description");
}
public void employeeValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid employee");
}
public void timeValidation(LocalDateTime num)throws ValidationException{
	ValidationUtil.isValidDateTime(num, "invalid timestramp");
}
public void statusValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid status");
}
public void adminValidation(EmployeeDetail employeeDetail)throws ValidationException{
	ValidationUtil.isInvalidObject(employeeDetail, "employee is not ia admin");
}

public void saveValidation(TicketDetails ticket)throws ValidationException{
	ticketValidation(ticket);
	idvalidation(ticket.getId());
	userValidation(ticket.getUserId().getId());
	departmentValidation(ticket.getDepartmenttId().getId());
	subjectValidation(ticket.getSubject());
   descriptionValidation(ticket.getDescription());
   employeeValidation(ticket.getAssignedTo().getId());
   timeValidation(ticket.getCreatedTime());
   timeValidation(ticket.getModifiedTime());
   statusValidation(ticket.getStatus());
   
}
public void createTicketValidation(TicketDetails ticket)throws ValidationException{
	ticketValidation(ticket);
	idvalidation(ticket.getId());
	userValidation(ticket.getUserId().getUserId());
	departmentValidation(ticket.getDepartmenttId(),getId());
	subjectValidation(ticket.getSubject());
   descriptionValidation(ticket.getDescription());
   timeValidation(ticket.getCreatedTime());
   
   
}
public void deleteValidation(TicketDetails ticket)throws ValidationException{
	idvalidation(ticket.getId());
	userValidation(ticket.getUserId().getUserId());
}
public void updateValidation(TicketDetails ticket)throws ValidationException{
	idvalidation(ticket.getId());
	subjectValidation(ticket.getSubject());
}
public void closeticketValidation(TicketDetails ticket)throws ValidationException{
	idvalidation(ticket.getId());
	
}
public void assignTicketValidation(TicketDetails ticket)throws ValidationException{
	idvalidation(ticket.getId());
	employeeValidation(ticket.getId());
}
public void deleteTicketAssign(EmployeeDetails row)throws ValidationException{
	adminValidation(row);
	}
public void employeeValidation(EmployeeDetails row)throws ValidationException{
	adminValidation(row);
}
}
