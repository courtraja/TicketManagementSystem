package service;

import java.util.logging.Logger;

import javax.xml.bind.ValidationException;

import com.mysql.cj.mysqlx.protobuf.MysqlxNotice.Warning.Level;

import dao.IssueDetailsDao;
import model.IssueDetails;
import validation.IssueDetailsValidation;

public class IssueDetailsService {
IssueDetailsValidation issueValidator=new IssueDetailsValidation();
final Logger logger = Logger.getLogger(IssueDetails.class.getName());

public void replyToTicket(IssueDetails issue){
	try{
		issueValidator.saveValidation(issue);
		IssueDetailsDao issueDao=new IssueDetailsDao();
		issueDao.save(issue);
		
		issueDao.updateStatus(issue.getIssueId());}
	catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
	}
}

}
