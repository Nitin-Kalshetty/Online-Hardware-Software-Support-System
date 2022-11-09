package dao;

public interface HodDao {

	public String loginHOD(String username,String password);
	
	public String registerNewEngineer(String username,String password,String type);
	
	public String viewAllRegisteredEngineers();
	
	public String deleteEngineer(String username);
	
	public String raisedProblems();
	
	public String assignProblem(int engId,int complainId);
}
