package com.raja.service;

import java.util.logging.Level;
import java.util.logging.Logger;



import com.raja.dao.IssueDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.model.IssueDetails;
import com.raja.validation.IssueDetailsValidation;

public class IssueDetailsService {
IssueDetailsValidation issueValidator=new IssueDetailsValidation();
final Logger logger = Logger.getLogger(IssueDetails.class.getName());

public void replyToTicket(IssueDetails issue){
	try{
		issueValidator.saveValidation(issue);
		IssueDetailsDao issueDao=new IssueDetailsDao();
		issueDao.save(issue);
		
		issueDao.update(issue);}
	catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
	}
}

}
