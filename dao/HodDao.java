package dao;

import java.util.List;

import Exceptions.complainException;
import Exceptions.engineerException;
import Exceptions.hodException;
import model.Complaints;
import model.Engineer;
import model.Hod;

public interface HodDao {

	public Hod loginHOD(String username,String password) throws hodException;
	
	public String registerNewEngineer(Engineer engineer)throws hodException,engineerException;
	
	public List<Engineer> viewAllRegisteredEngineers(int hodId)throws hodException,engineerException;
	
	public String deleteEngineer(String username,int hodId)throws hodException,engineerException;
	
	public List<Complaints> raisedProblems()throws hodException,complainException;
	
	public String assignProblem(int engId,int complainId,int hodId)throws hodException,complainException;
}
