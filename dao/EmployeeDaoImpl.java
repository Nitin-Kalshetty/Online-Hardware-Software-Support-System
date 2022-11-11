package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.complainException;
import Exceptions.employeeException;
import Exceptions.engineerException;
import dbUtility.DBUtility;
import model.Complaints;
import model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(Employee employee) throws employeeException {
		String message="Not registered";
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into employee(empFirstName,empLastName,empCity,empSalary,empEmail,empPassword) values(?,?,?,?,?,?)");
			ps.setString(1, employee.getEmpFirstname());
			ps.setString(2, employee.getEmpLastname());
			ps.setString(3, employee.getEmpCity());
			ps.setInt(4, employee.getEmpSalary());
			ps.setString(5, employee.getEmpEmail());
			ps.setString(6, employee.getEmpPassword());
			int x = ps.executeUpdate();
			if(x>0) {
				message="Employee registered Successfully";
			}else {
				System.out.println("Invalid data type...");
			}
			
		} catch (SQLException e) {
			throw new employeeException(e.getMessage());
			
		}
		return message;
	}

	@Override
	public Employee login(String username, String password) throws employeeException {
		Employee employee=null;
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from employee where empEmail=? and empPassword=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee=new Employee(rs.getInt("employeeId"),rs.getString("empFirstName"),rs.getString("empLastName"),rs.getString("empCity"),rs.getInt("empSalary"),rs.getString("empEmail"),rs.getString("empPassword"));
			}
		} catch (SQLException e) {
			throw new employeeException(e.getMessage());
		}
		return employee;
	}

	@Override
	public String registerComplain(String complainType,int employeeId,String status) throws complainException {
		String message="Complain Not Registered";
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into complaints(employeeId,status,type) values(?,?,?)");
			ps.setInt(1, employeeId);
			ps.setString(2, status);
			ps.setString(3, complainType);
			int x = ps.executeUpdate();
			if(x>0) {
				message="Complain registered Successfully";
			}else {
				System.out.println("Invalid data type...");
			}
		} catch (SQLException e) {
			throw new complainException(e.getMessage());
		}
		return message;
	}
	@Override
	public Complaints getComplainDetails(int complainId,int employeeId) throws complainException {
		Complaints complain=null;
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from complaints where complainId=? and employeeId=?");
			ps.setInt(1, complainId);
			ps.setInt(2, employeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				complain= new Complaints(rs.getInt("complainId"), rs.getInt("employeeId"), rs.getInt("engineerId"), rs.getString("status"), rs.getString("type"));
			}
		} catch (SQLException e) {
			throw new complainException(e.getMessage());
		}
		return complain;
	}

	@Override
	public List<Complaints> getAllComplains(int employeeId) throws complainException {
		List<Complaints> list = new ArrayList<>();
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from complaints where employeeId=?");
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Complaints(rs.getInt("complainId"), rs.getInt("employeeId"), rs.getInt("engineerId"), rs.getString("status"), rs.getString("type")));
			}
		} catch (SQLException e) {
			throw new complainException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public String changePassword(String username,String newPassword) throws employeeException {
		String message="Password Not Changed";
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update employee set empPassword=? where empEmail=?");
			ps.setString(1, newPassword);
			ps.setString(2, username);
			int x = ps.executeUpdate();
			if(x>0) {
				message="Status updated";
			}else {
				System.out.println("Invalid EmployeeId/Username");
			}
			
		} catch (SQLException e) {
			throw new employeeException(e.getMessage());
		}
		
		return message;
	}

}
