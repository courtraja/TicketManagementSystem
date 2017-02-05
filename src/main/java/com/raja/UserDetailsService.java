package service;
import java.util.logging.Logger;
import dao.UserDetailsDao;


import javax.xml.bind.ValidationException;

import com.mysql.cj.mysqlx.protobuf.MysqlxNotice.Warning.Level;
import model.UserDetails;
public class UserDetailsService {
	final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());
	UserDetailsValidation userDetailValidator=new UserDetailsValidation();

public void save(UserDetails userDetail){
	try{
		userDetailValidator.saveValidation(userDetail);
		UserDetailsDao userDetailDao=new UserDetailsDao();
		userDetailDao.save(userDetail);
	}catch (ValidationException e){
		logger.log(Level.SEVERE, "exception occur %s",e);
	}
}
public void delete(UserDetails userDetail){
	try{
		userDetailValidator.deleteValidation(userDetail);
		UserDetailsDao userDetailDao=new UserDetailsDao();
		userDetailDao.delete(userDetail.getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
	}
}
public void update(UserDetail userDetail){
	try{
		userDetailValidator.updateValidation(userDetail);
		UserDetailDao userDetailDao=new UserDetailsDao();
		userDetailDao.update(userDetail.getId(), userDetail.getPassword());
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur", e);
	}
}
public void login(String email,String password){
	try{
		UserDetailsDao userDetailDao=new UserDetailsDao();
		UserDetails row=(userDetailDao.selectOne(email));
		String tname=row.getEmailId();
		String tpassword=row.getName();
		
		String message=(userDetailValidator.loginValidation(tname, tpassword, email, password));
		
		System.out.println(message);
	}
	catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
	}
}
}
