package dao;

import java.util.List;

import Exceptions.employeeException;

public interface EmployeeDao {

	public String registerEmployee(String username,String password)throws employeeException;
	
	public String login(String username,String password)throws employeeException;
	
	public String registerComplain(String complainType)throws employeeException;
	
	public String getComplainDetails(int complainId)throws employeeException;
	
	public List<Object> getAllComplains()throws employeeException;
	
	public String changePassword(String newPassword)throws employeeException;
	
}
