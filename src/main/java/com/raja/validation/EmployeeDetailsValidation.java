package validation;

import javax.xml.bind.ValidationException;

import model.EmployeeDetails;
import util.ValidationUtil;
public class EmployeeDetailsValidation {
public void employeeValidation(EmployeeDetails emp)throws ValidationException{
	ValidationUtil.isInvalidObject(emp, "empty object");
	}
public void idValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid id");
}
public void nameValidation(String name)throws ValidationException{
	ValidationUtil.isInvalidString(name, "invalid name");
}
public void emailValidation(String email)throws ValidationException{
	ValidationUtil.isValidEmail(email, "invalid email");
}
public void passwordValidation(String password)throws ValidationException{
	ValidationUtil.isValidPassword(password, "invalid password");
}
public void departmentValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid department id");
}
public  void statusValidation(boolean num)throws ValidationException{
	ValidationUtil.isValidBoolean(num, "invalid status");
}
public void roleValidation(Integer id)throws ValidationException{
	ValidationUtil.isInvalidNumber(id, "invalid role");
}
public void saveValidation(EmployeeDetails emp)throws  ValidationException{
	employeeValidation(emp);
	idValidation(emp.getEmployeeId());
	nameValidation(emp.getEmployeeName());
	emailValidation(emp.getEmployeeMail());
	passwordValidation(emp.getEmployeePass());
	departmentValidation(emp.getDepartmentId().getDepartmentId());
	statusValidation(emp.getEmployeeActive());
	roleValidation(emp.getRoleId().getRoleId());
}
public void deleteValidation(EmployeeDetails emp)throws ValidationException{
	employeeValidation(emp);
	idValidation(emp.getRoleId());
}
public void updateValidation(EmployeeDetails emp)throws ValidationException{
 employeeValidation(emp);
 idValidation(emp.getEmployeeId());
}
}
