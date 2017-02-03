package com.raja.model;

import lombok.Data;

@Data
public class EmployeeDetails {

	private int employeeId;
	private String employeeName;
	private String employeeMail;
	private String employeePass;
	private String employeeActive;
	private String roles;
    private DepartmentDetails departmentId;
	
	
}
