package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.engineerException;
import dbUtility.DBUtility;
import model.Complaints;
import model.Engineer;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public Engineer engLogin(String username, String password) throws engineerException {
		Engineer engineer = null;
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from engineer where engEmail=? and engPassword=?");
			ps.setString(1,username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				engineer = new Engineer(rs.getInt("engineerId"),rs.getString("engFirstName"),rs.getString("engLastName"),rs.getString("engCity"),rs.getInt("engSalary"),
						rs.getString("engEmail"),rs.getString("engPassword"),rs.getString("engType"),rs.getInt("hodId"));
			}else {
				System.out.println("Invalid username or password..");
			}
			
		} catch (SQLException e) {
			
			throw new engineerException(e.getMessage());
			
		}
		return engineer;
	}

	@Override
	public List<Complaints> viewProblems(Engineer engineer) throws engineerException {
		List<Complaints> list = new ArrayList<>();
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from complaints where engineerid=?");
			ps.setInt(1, engineer.getEngineerId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Complaints(rs.getInt("complainId"), rs.getInt("employeeId"), rs.getInt("EngineerId"),rs.getString("status"),rs.getString("type")));
			}
		} catch (SQLException e) {
			throw new engineerException(e.getMessage());
		}
		return list;
	}

	@Override
	public String updateStatus(int complainId,Engineer engineer,String status) throws engineerException {
		String message="Not updated";
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update complaints set status=? where complainId=? and engineerid=?");
			ps.setString(1,status);
			ps.setInt(2, complainId);
			ps.setInt(3, engineer.getEngineerId());
			int x = ps.executeUpdate();
			if(x>0) {
				message="Status updated";
			}else {
				System.out.println("Invalid ComplaintId/EngineerId");
			}
			
		} catch (SQLException e) {
			throw new engineerException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Complaints> viewAttended(Engineer engineer) throws engineerException {
		List<Complaints> list = new ArrayList<>();
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from complaints where status not like in(not assigned,assigned) and engineerId=?");
			ps.setInt(1, engineer.getEngineerId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			list.add(new Complaints(rs.getInt("complainId"), rs.getInt("employeeId"), rs.getInt("EngineerId")));
			}
		} catch (SQLException e) {
			throw new engineerException(e.getMessage());
		}
		return list;
	}

	@Override
	public String changePassword(Engineer engineer,String newPassword) throws engineerException {
		String message="Password Not Changed";
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update engineer set password=? where email=?");
			ps.setString(1, newPassword);
			ps.setString(2, engineer.getEngEmail());
			int x = ps.executeUpdate();
			if(x>0) {
				message="Status updated";
			}else {
				System.out.println("Invalid EngineerId/Username");
			}
			
		} catch (SQLException e) {
			throw new engineerException(e.getMessage());
		}
		
		return message;
	}



}
