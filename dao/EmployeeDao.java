package dao;

import java.util.List;

public interface EmployeeDao {

	public String registerEmployee(String username,String password);
	
	public String login(String username,String password);
	
	public String registerComplain(String complainType);
	
	public String getComplainDetails(int complainId);
	
	public String getAllComplains();
	
	public String changePassword(String newPassword);
	
}
