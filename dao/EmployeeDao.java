package dao;

import java.util.List;
import Exceptions.complainException;
import Exceptions.employeeException;
import model.Complaints;
import model.Employee;

public interface EmployeeDao {

	public String registerEmployee(Employee employee)throws employeeException;
	
	public Employee login(String username,String password)throws employeeException;
	
	public String registerComplain(String complainType,int employeeId,String status)throws complainException;
	
	public Complaints getComplainDetails(int complainId,int employeeId)throws complainException;
	
	public List<Complaints> getAllComplains(int employeeId)throws complainException;
	
	public String changePassword(String username,String newPassword)throws employeeException;
	
}
