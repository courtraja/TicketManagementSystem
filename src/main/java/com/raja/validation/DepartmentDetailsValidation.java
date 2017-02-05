package validation;

import javax.xml.bind.ValidationException;

import model.DepartmentDetails;
import util.ValidationUtil;

public class DepartmentDetailsValidation{

public void validDepartment(DepartmentDetails department)throws ValidationException{
	  ValidationUtil.isInvalidObject(department, "empty object");
  }
  public void idValidation(Integer id)throws ValidationException{
	  ValidationUtil.isInvalidNumber(id, "invalid id");
  }
  public void namevalidation(String name)throws ValidationException{
	  ValidationUtil.isInvalidString(name, "invalid name");
  }public void statusValidation(String string)throws ValidationException{
	  ValidationUtil.isValidBoolean(string, "invalid status");
  }
  public void saveValidation(DepartmentDetails department)throws ValidationException{
	  validDepartment(department);
	  idValidation(department.getDepartmentId());
	  namevalidation(department.getDepartmentName());
	  statusValidation(department.getDepartmentActive());
  }
  public void deleteValidation(DepartmentDetails department)throws ValidationException{
	  validDepartment(department);
	  idValidation(department.getDepartmentId());
  }
}