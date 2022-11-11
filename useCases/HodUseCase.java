package useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.complainException;
import Exceptions.engineerException;
import Exceptions.hodException;
import dao.HodDao;
import dao.HodDaoImpl;
import model.Complaints;
import model.Engineer;
import model.Hod;

public class HodUseCase {

	public static void main(String[] args) throws hodException,engineerException,complainException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Head of Department of Hardware/Software Support System.");
		HodDao dao=new HodDaoImpl();
		Hod hod= null;
		while(true) {
		System.out.println("Please First Login...");
		System.out.println();
		System.out.println("Enter the username");
		String email=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
			try {
				hod = dao.loginHOD(email, password);
				if(hod!=null) {
					System.out.println("Login Successful....");
					System.out.println();
					break;
				}
				
			} catch (hodException e) {
			System.out.println(e.getMessage());
			}
		System.out.println();
		}
		while(hod!=null) {
			System.out.println("Press 1 To RegisterNew Engineer");
			System.out.println("Press 2 To View All Registered Users");
			System.out.println("Press 3 To Delete the Engineer");
			System.out.println("Press 4 To View All Raised Complains");
			System.out.println("Press 5 To Assign the Complaint");
			System.out.println("Press 6 To Exit");
			List<Complaints> complaints = new ArrayList<>();
			List<Engineer> engineers = new ArrayList<>();
			int val = sc.nextInt();
			if(val==1) {
				System.out.println("Enter the Engineer First Name : ");
				String engFirstName=sc.next();
				System.out.println("Enter the Engineer Last Name : ");
				String engLastName=sc.next();
				System.out.println("Enter the Engineer City Name : ");
				String engCity=sc.next();
				System.out.println("Enter the Engineer Salary : ");
				int salary = sc.nextInt();
				System.out.println("Enter the Engineer Email Id : ");
				String emailId = sc.next();
				System.out.println("Enter the Engineer Password : ");
				String password = sc.next();
				System.out.println("Press 1 for Hardware Type Complaint \n Press 2 for Software Type Complaint");
				int x = sc.nextInt();
				String type="";
				if(x==1) {
					type="Hardware";
				}else if(x==2) {
					type="Software";
				}else {
					System.out.println("Invalid Input");
					System.out.println();
					continue;
				}
				Engineer engineer = new Engineer(engFirstName, engLastName, engCity, salary, emailId, password, type, hod.getHodId());
				try {
					String check = dao.registerNewEngineer(engineer);
					System.out.println(check);
				} catch (engineerException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else if(val==2) {
					try {
						engineers=dao.viewAllRegisteredEngineers(hod.getHodId());
						if(engineers.size()==0) {
							System.out.println("No engineers Registered..");
						}else {
							engineers.forEach(System.out::println);	
						}
					} catch (hodException e) {
						System.out.println(e.getMessage());
					} catch (engineerException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
			}else if(val==3) {
				System.out.println("Enter the username of Engineer whom you want to delete : ");
				String username = sc.next();
				try {
					String check = dao.deleteEngineer(username,hod.getHodId());
					System.out.println(check);
				} catch (engineerException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else if(val==4) {
				try {
					complaints=dao.raisedProblems();
					complaints.forEach(System.out::println);
				} catch (complainException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else if(val==5) {
				System.out.println("Enter the EngineerId to Assign complaint : ");
				int engineerId = sc.nextInt();
				System.out.println("Enter the complainId : ");
				int complainId = sc.nextInt();
				try {
					String check = dao.assignProblem(engineerId, complainId,hod.getHodId());
					System.out.println(check);
				} catch (complainException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
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
