package dao;

import java.util.List;

import Exceptions.engineerException;
import model.Complaints;
import model.Engineer;

public interface EngineerDao {
	
	public Engineer engLogin(String username,String password) throws engineerException;
	
	public List<Complaints> viewProblems(Engineer engineer)throws engineerException;
	
	public String updateStatus(int complainId,Engineer engineer,String status)throws engineerException;
	
	public List<Complaints> viewAttended(Engineer engineer)throws engineerException;
	
	public String changePassword(Engineer engineer,String newPassword)throws engineerException;

}

