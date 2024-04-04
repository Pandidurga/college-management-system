import java.util.Scanner;
import java.util.LinkedHashMap;
import java.time.LocalDateTime;

/*Class responsible for managing the main functionality of the College Management System
 *In this MainPage multiple choices shown like adding new college details ,updating the existing details and list out the available colleges
 *This page is the entry page of this project "College Management System.
 */
 
public class MainPage {
	
	   // Main method, entry point of the program
	   
       public static void main(String[] args) {
		   
	   //Scanner object created to get input from user 
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Welcome to College Management System\n_____________________________________\n");
	   MainPage mainpage=new MainPage();
	   
	   //Service class  object created ,using this we will call all the implemented methods in service class
	   CollegeService serviceObj=new CollegeServiceImpl();
	   int n=1;
	   
	   /* Main loop to display menu and handle user choices
	    * This loop runs until the user want to exit this application
		* The variable "n",it's value controls this loop
		*/
	   while(n!=0){
		    System.out.println("Enter your choice :\n    1.Add college\n    2.Display\n    3.Update College    \n    0.Exit");
			int choice=sc.nextInt();
			sc.nextLine();
			
			//Switch case used for redirecting to the user particular functionality depends on the case value passing to the switch case
			switch(choice) {
			    
				/*case 1 responsible insert the new college records
				 *here the Service class insertion method calling happened
				 */
				case 1:
					mainpage.insertCollege(serviceObj);
					break;
			    
				/*case 2 responsible display the existing college records
				 *here the Service class display method calling happened
				 */
				case 2:
				    mainpage.display(mainpage,serviceObj);
					break;
					
				/*case 3 responsible update the existing college records
				 *here the update methods sub menu called and will display
				 */
				case 3:
				    mainpage.update(mainpage,serviceObj);
					break;
					
				/*case 4 responsible delete the existing college records
				 *here the Service class delete method calling happened
				 */	
			    case 4:
				    mainpage.deleteCollege(serviceObj);
					break;
				
				//case 0 for exit from the application, in this the n value is setted as 0 and the loop get terminated
				case 0:
					n=0;
					System.out.println("Exited....");
					break;
			}
        }
	}
	
	
	   /* this Method responsible for inserting new college record
	    * the user inputs for the attributes college id,name,location,type,autonomous,university are get here
		*/
	   public void insertCollege(CollegeService serviceObj){
		        
		       Scanner sc=new Scanner(System.in);
			   System.out.println("Enter College id:");
			   int collegeId=sc.nextInt();
			   sc.nextLine();
			   
			   System.out.println("Enter college name:");
			   String collegeName=sc.nextLine();
			   
			   System.out.println("Enter Location: ");
			   String location=sc.nextLine();
			   
			   System.out.println("Enter type:public/private");
			   String type=sc.nextLine();
			   
			   System.out.println("Enter counselling code:");
			   int counsellingCode=sc.nextInt();
			   sc.nextLine();
			   
			   System.out.println("Enter Autonomous:true/false");
			   boolean isAutonomous=sc.nextBoolean();
			   sc.nextLine();
			   System.out.println("Enter University Name:(if not enter none)");
			   String universityName=sc.nextLine();
			   
			   // Create a LinkedHashMap to store college information
			   LinkedHashMap <String,Object>  college=new LinkedHashMap<>(); 
			   college.put("collegeId",collegeId);
			   college.put("collegeName",collegeName);
			   college.put("location",location);
			   college.put("type",type);
			   college.put("counsellingCode",counsellingCode);
			   college.put("isAutonomous",isAutonomous);
			   college.put("universityName",universityName);
			   
			   // Call service method to insert college
			   serviceObj.insertCollege(college);
	    }
		
		
		public void display( MainPage mainpage,CollegeService serviceObj){
			
			Scanner sc=new Scanner(System.in);
			int n=1;
	        
		   while(n!=0){
				System.out.println("Display menu\nEnter your choice :\n    1.Display College By Id\n    2.Display All\n    0.Exit");
				int choice=sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
					
					case 1:
						mainpage.displayById(serviceObj);
						break;
					case 2:
						mainpage.displayAll(serviceObj);
						break;
					case 0:
						n=0;
						System.out.println("Exited Display Menu....");
						break;
				}
			}
		}
		
		
		 // Method to display college by ID
		public void displayById(CollegeService serviceObj) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the College Id:");
			int collegById=sc.nextInt();
			
			serviceObj.displayById(collegById);
        }
		
		
		// Method to display all colleges
		public void displayAll(CollegeService serviceObj) {
			 serviceObj.displayAll();
	    }
		
		// Method to handle updating college information
		public void update( MainPage mainpage,CollegeService serviceObj){
			
			Scanner sc=new Scanner(System.in);
			int n=1;
	        
		   while(n!=0){
				System.out.println("Update menu\nEnter your choice :\n    1.Update College name: Id\n    2.Update College Location:\n    3.Update College Type\n    4.Update College Counselling code\n    5.Update College Autonomous status:(true/false)\n    6.Update Record in single query\n    0.Exit");
				int choice=sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
					
					case 1:
						mainpage.updateCollegeName(serviceObj);
						break;
					case 2:
						mainpage.updateCollegeLocation(serviceObj);
						break;
					case 3:
					    mainpage.updateCollegeType(serviceObj);
						break;
					case 4:
					    mainpage.updateCollegeCode(serviceObj);
						break;
					case 5:
					    mainpage.updateCollegeAutonomous(serviceObj);
						break;
				    case 6:
					    mainpage.updateAll(serviceObj);
						break;
					case 0:
						n=0;
						System.out.println("Exited Update Menu....");
						break;
				}
			}
		}
		
		// Method to update college name
		public void updateCollegeName (CollegeService serviceObj) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the CollegeId");
			int collegeId=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the newName");
			String newName=sc.nextLine();
		    
			serviceObj.updateCollegeName(collegeId,newName);
		   }
		
		
		// Method to update college Location
		public void updateCollegeLocation (CollegeService serviceObj) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the CollegeId");
			int collegeId=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the newLocation");
			String newLocation=sc.nextLine();
		    
			serviceObj.updateCollegeLocation(collegeId,newLocation);
		   }
		   
		   // Method to update college type
		   public void updateCollegeType(CollegeService serviceObj) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the CollegeId");
			int collegeId=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the newType:");
			String newType=sc.nextLine();
		    
			serviceObj.updateCollegeType(collegeId,newType);
		   }
		   
		    // Method to update college counselling code
		   public void updateCollegeCode (CollegeService serviceObj) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the CollegeId");
			int collegeId=sc.nextInt();
			System.out.println("Enter the Update Value");
			int newCode=sc.nextInt();
		    
			serviceObj.updateCollegeCode(collegeId,newCode);
		   }
		
		    // Method to update college autonomous status
		   public void updateCollegeAutonomous(CollegeService serviceObj) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the CollegeId");
			int collegeId=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the isAutonomous:true/false");
			boolean newAutonomous=sc.nextBoolean();
		    
			serviceObj.updateCollegeAutonomous(collegeId,newAutonomous);
		   }
		   
		   
		
        //get collegeid here and pass to the service implementation to delete record		
		public void deleteCollege(CollegeService serviceObj) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the CollegeId");
			int collegeId=sc.nextInt();
			
			serviceObj.deleteCollege(collegeId);
			
			
		}
		
		public void updateAll(CollegeService serviceObj){
			Scanner sc=new Scanner(System.in);
			
			 // Create a LinkedHashMap to store updated college information
            LinkedHashMap<String,Object> college=new LinkedHashMap<>();
			
			System.out.println("Enter the CollegeId");
			int collegeId=sc.nextInt();
			sc.nextLine(); // Consume newline character
			college.put("college_id",collegeId);
			
			
			System.out.println("Enter college name(if not updated, enter \"N\"):");
			String collegeName=sc.nextLine();
			if(!collegeName.equals("N")){
			 college.put("college_name",collegeName);	
			}
			
			System.out.println("Enter updated Location (if not updated, enter \"N\"):");
			String location=sc.nextLine();
			if(!location.equals("N")){
				college.put("location",location);
			}
			
			System.out.println("Enter updated type (public/private) (if not updated, enter \"N\"):");
			String type=sc.nextLine();
			if(!type.equals("N")){
				college.put("type",type);
			}
			
			
			System.out.println("Enter updated counselling code (if not updated, enter \"N\"):");
			String counsellingCode=sc.nextLine();
			if(!counsellingCode.equals("N")){
				college.put("counselling_code",counsellingCode);
			}

			System.out.println("Enter updated Autonomous (true/false) (if not updated, enter \"N\"):");
			String isAutonomous=sc.nextLine();
			if(!isAutonomous.equals("N")){
				college.put("is_autonomous",isAutonomous);
			}
			
			System.out.println("Enter updated University Name: (if not updated, enter \"N\"):");
			String universityName=sc.nextLine();
			if(!universityName.equals("N")){
				college.put("university_name",universityName);
			}
			
			// Call service method to update college
			serviceObj.updateAll(college);
}

		
    }
	