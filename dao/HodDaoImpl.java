package dao;

import java.sql.Connection;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import Exceptions.complainException;
import Exceptions.engineerException;
import Exceptions.hodException;
import dbUtility.DBUtility;
import model.Complaints;
import model.Engineer;
import model.Hod;

public class HodDaoImpl implements HodDao {

	@Override
	public Hod loginHOD(String username, String password) throws hodException{
		Hod hod = null;
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from hod where hodEmail=? and hodPassword=?");
			ps.setString(1,username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				hod=new Hod(rs.getInt("hodId"), rs.getString("hodFirstName"), rs.getString("hodLastName"), rs.getString("hodCity"), rs.getString("hodEmail"), rs.getString("hodPassword"));
			}else {
				System.out.println("Invalid username or password..");
			}
			
		} catch (SQLException e) {
			
			throw new hodException(e.getMessage());
			
		}
		return hod;
	}

	@Override
	public String registerNewEngineer(Engineer engineer) throws hodException,engineerException{
		String message="Not registered";
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into engineer(engFirstName,engLastName,engCity,engSalary,engEmail,engPassword,engType,hodId) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, engineer.getEngFirstName());
			ps.setString(2, engineer.getEngLastName());
			ps.setString(3, engineer.getEngCity());
			ps.setInt(4, engineer.getEngSalary());
			ps.setString(5, engineer.getEngEmail());
			ps.setString(6 , engineer.getEngPassword());
			ps.setString(7, engineer.getEngType());
			ps.setInt(8, engineer.getHodId());
			int x = ps.executeUpdate();
			if(x>0) {
				message="Engineer registered Successfully";
			}else {
				System.out.println("Invalid username or password..");
			}
			
		} catch (SQLException e) {
			throw new engineerException(e.getMessage());
			
		}
		return message;
	}

	@Override
	public List<Engineer> viewAllRegisteredEngineers(int hodId) throws hodException,engineerException{
		List<Engineer> list = new ArrayList<>();
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from engineer where hodId=?");	
			ps.setInt(1, hodId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Engineer(rs.getInt("engineerId"), rs.getString("engFirstName"), rs.getString("engLastName"), rs.getString("engCity"), rs.getInt("engSalary"), rs.getString("engEmail"), rs.getString("engPassword"), rs.getString("engType"), rs.getInt("hodId")));
			}	
		} catch (SQLException e) {
			throw new engineerException(e.getMessage());
		}
		return list;
	}

	@Override
	public String deleteEngineer(String username,int hodId) throws hodException,engineerException{
		String message = "Not deleted";
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("delete from engineer where engEmail=? and hodId=?");	
			ps.setString(1, username);
			ps.setInt(2, hodId);
			int x = ps.executeUpdate();
			if(x>0) {
				message=username + " username Engineer is successfully deleted";
			}
		} catch (SQLException e) {
			throw new engineerException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Complaints> raisedProblems() throws hodException,complainException{
		List<Complaints> list = new ArrayList<>();
		try (Connection conn = DBUtility.provideConnection()){
			String type="Not Assigned";
			PreparedStatement ps = conn.prepareStatement("select * from complaints where status=?");	
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Complaints(rs.getInt("complainId"), rs.getInt("employeeId"),rs.getInt("engineerId"), rs.getString("status"), rs.getString("type")));
			}
		} catch (SQLException e) {
			throw new complainException(e.getMessage());
		}
 		
		return list;
	}

	@Override
	public String assignProblem(int engId, int complainId,int hodId) throws hodException,complainException{
		String message = "Not Assigned";
		try (Connection conn = DBUtility.provideConnection()){
			String setStatus="Assigned";
			PreparedStatement ps = conn.prepareStatement(" update complaints set status=?,engineerId=? where type=(select engType from engineer where engineerId=?) and complainId=?");	
			ps.setString(1, setStatus);
			ps.setInt(2, engId);
			ps.setInt(3, engId);
			ps.setInt(4, complainId);
			int x = ps.executeUpdate();
			if(x>0) {
				message="Assigned Successfully......";
			}else {
				System.out.println("There might be conflicts check complainId, Type, EngineerId and Engineer Type");
			}
		} catch (SQLException e) {
			throw new complainException(e.getMessage());
		}
		return message;
	}

}
