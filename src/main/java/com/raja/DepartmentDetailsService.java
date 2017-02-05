package service;

import validation.DepartmentDetailsValidation;

import java.util.logging.Logger;

import javax.xml.bind.ValidationException;

import com.mysql.cj.mysqlx.protobuf.MysqlxNotice.Warning.Level;

import dao.DepartmentDetailsDao;
import model.DepartmentDetails;

public class DepartmentDetailsService {

	public class DepartmentService {
		public void save(DepartmentDetails department){
			DepartmentDetailsValidation DepartmentDetailsValidation=new DepartmentDetailsValidation();
			final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());
			try{
				DepartmentDetailsValidation.saveValidation(department);
				DepartmentDetailsDao  departmentDao=new DepartmentDetailsDao();
				departmentDao.save(department);
			}catch (ValidationException e){
				logger.log(Level.SEVERE, "exception occur %s", e);
			}
		}
		public void delete(DepartmentDetails department){
			DepartmentDetailsValidation DepartmentDetailsValidation=new DepartmentDetailsValidation();
			final Logger logger = Logger.getLogger(Department.class.getName());
			try{
				DepartmentDetailsValidation.deleteValidation(department);
				DepartmentDetailsDao  departmentDao=new DepartmentDao();
				departmentDao.delete(department.getId());
			}catch (ValidationException e){
				logger.log(Level.SEVERE, "exception occur %s", e);
			}
		}
		}

}
