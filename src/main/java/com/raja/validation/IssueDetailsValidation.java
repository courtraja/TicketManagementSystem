package validation;

import javax.xml.bind.ValidationException;

import model.IssueDetails;
import model.TicketDetails;
import util.ValidationUtil;

public class IssueDetailsValidation {
public void IssueDetailsvalidation(IssueDetails IssueDetails)throws ValidationException{
	ValidationUtil.isInvalidObject(IssueDetails, "invalid object");
}
public void idValidation(TicketDetails ticketDetails)throws ValidationException{
	ValidationUtil.isInvalidNumber(ticketDetails, "invalid id");
	
}
public void ticketValidation(int id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid ticket");
	
}
public void solutionValidation(String msg)throws ValidationException{
	ValidationUtil.isInvalidString(msg, "invalid solution");
}
public void saveValidation(IssueDetails IssueDetails)throws ValidationException{
	idValidation(IssueDetails.getId());
	ticketValidation(IssueDetails.getId());
	solutionValidation(IssueDetails.getSolution());
}
public void deleteValidation(IssueDetails IssueDetails)throws ValidationException{
	idValidation(IssueDetails.getId());
}
public void updateValidation(IssueDetails IssueDetails )throws ValidationException{
	idValidation(IssueDetails.getId());
	solutionValidation(IssueDetails.getSolution());
}
}