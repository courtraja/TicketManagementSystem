package com.raja.validation;

import javax.xml.bind.ValidationException;
import com.raja.model.UserDetails;
import com.raja.util.ValidationUtil;

public class UserDetailsValidation {

	public void validDepartment(UserDetails user)throws ValidationException{
		  ValidationUtil.isInvalidObject(user, "empty object");
	  }
	  public void idValidation(Integer id)throws Exception{
		  ValidationUtil.isInvalidNumber(id, "invalid id");
	  }
	  public void namevalidation(String name)throws Exception{
		  ValidationUtil.isInvalidString(name, "invalid name");
	  }
	  
	  public void saveValidation(UserDetails user)throws Exception{
		  validDepartment(user);
		  idValidation(user.getUserId());
		  namevalidation(user.getUserName());
		  
	  }
	  public void deleteValidation(UserDetails user)throws Exception{
		  validDepartment(user);
		  idValidation(user.getUserId());
	  }
}
