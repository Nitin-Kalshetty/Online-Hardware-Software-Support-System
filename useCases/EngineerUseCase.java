package useCases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.engineerException;
import dao.EngineerDao;
import dao.EngineerDaoImpl;
import model.Complaints;
import model.Engineer;

public class EngineerUseCase {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hardware/Software Support System.");
		EngineerDao dao=new EngineerDaoImpl();
		Engineer engineer = null;
		while(true) {
		System.out.println("Please First Login...");
		System.out.println();
		System.out.println("Enter the username");
		String email=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
		try {
			engineer = dao.engLogin(email, password);
			if(engineer!=null) {
				System.out.println("Login Successful....");
				System.out.println();
				break;
			}
			
		} catch (engineerException e) {
			e.printStackTrace();
		}
		System.out.println();
		}
		
		while(engineer!=null) {
			System.out.println("Press 1 for Engineer viewProblems");
			System.out.println("Press 2 for Updating The Status");
			System.out.println("Press 3 To View the attended Problems");
			System.out.println("Press 4 To Change the password");
			System.out.println("Press 5 To Change the password");
			List<Complaints> list = new ArrayList<>();
			int val = sc.nextInt();
			if(val==1) {
				 try {
					list = dao.viewProblems(engineer);
					if(list.size()==0) {
						System.out.println("No problems assigned to You");
					}else {
						list.forEach(System.out::println);
					}
				} catch (engineerException e) {
					throw new engineerException(e.getMessage());
				}
				 System.out.println();
			}else if(val==2) {
				System.out.println("Enter the complainId to update Status");
				int complainId = sc.nextInt();
				System.out.print("To Change status \n press 1 for pending \n press 2 for completed");
				int statusV =sc.nextInt();
				String status ="";
				if(statusV==1) {
					status = "Pending";
				}else if(statusV==2){
					status ="Completed";
				}else {
					System.out.println("Invalid Input..");
					continue;
				}
				String check = dao.updateStatus(complainId, engineer, status);
				System.out.println(check);
				 System.out.println();
			}else if(val==3) {
				try {
					list=dao.viewAttended(engineer);
					if(list.size()==0) {
						System.out.println("No problems attended");
					}else {
						list.forEach(System.out::println);
					}
				} catch (engineerException e) {
					throw new engineerException(e.getMessage());
				}
				System.out.println();
				
			}else if(val==4) {
				System.out.println("Enter New Password to Change");
				String newPassword= sc.next();
				try {
					String changePassword = dao.changePassword(engineer, newPassword);
					System.out.println(changePassword);
				} catch (engineerException e) {
					throw new engineerException(e.getMessage());
				}
				System.out.println();
			}else if(val==5) {
				break;
			}else {
				System.out.println("Do You Want to Exit : (Y/N)");
				String exitVal=sc.next();
				if("y".equalsIgnoreCase(exitVal)) {
					System.out.println();
					break;
				}else {
					continue;
				}
				
				
			}
		}
		System.out.println("Thank You....");
		sc.close();
		
		

	}


}
