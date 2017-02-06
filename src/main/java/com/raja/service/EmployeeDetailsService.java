package service;

import java.util.logging.Logger;

import javax.xml.bind.ValidationException;
import model.EmployeeDetails;
import com.mysql.cj.mysqlx.protobuf.MysqlxNotice.Warning.Level;

public class EmployeeDetailsService {
 EmployeeDetailsValidation employeeDetailValidator=new EmployeeDetailsValidation();
	final Logger logger = Logger.getLogger(Department.class.getName());

 public void save(EmployeeDetails employee){
	 try{
		 employeeDetailValidator.saveValidation(employee);
		 EmployeeDetailsDao employeeDetailDao=new EmployeeDetailsDao();
		 employeeDetailDao.save(employee);
	 }catch(ValidationException e){
		 logger.log(Level.SEVERE, "exception occur",e);
	 }
 }
 public void delete(EmployeeDetails employee){
	 try{
		 employeeDetailValidator.deleteValidation(employee);
		 EmployeeDetailsDao employeeDetailDao=new EmployeeDetailsDao();
		 employeeDetailDao.delete(employee.getId());
	 }catch (ValidationException e){
		 logger.log(Level.CONFIG,"exception occur",e);
	 }
 }
}

