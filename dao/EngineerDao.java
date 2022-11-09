package dao;

public interface EngineerDao {
	
	public String engLogin(String username,String password);
	
	public String viewProblems();
	
	public String updateStatus(String status);
	
	public String viewAttended();
	
	public String changePassword(String newPassword);

}
