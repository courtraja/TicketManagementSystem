package com.raja.validation;

import com.raja.exception.ValidationException;
import com.raja.model.UserDetails;
import com.raja.util.ValidationUtil;

public class UserDetailsValidation {

	public void validDepartment(UserDetails user)throws ValidationException{
		  ValidationUtil.isInvalidObject(user, "empty object");
	  }
	  public void idValidation(Integer id)throws ValidationException{
		  ValidationUtil.isInvalidNumber(id, "invalid id");
	  }
	  public void namevalidation(String name)throws ValidationException{
		  ValidationUtil.isInvalidString(name, "invalid name");
	  }
	  
	  public void saveValidation(UserDetails user)throws ValidationException{
		  validDepartment(user);
		  idValidation(user.getUserId());
		  namevalidation(user.getUserName());
		  
	  }
	  public void deleteValidation(UserDetails user)throws ValidationException{
		  validDepartment(user);
		  idValidation(user.getUserId());
	  }
}
