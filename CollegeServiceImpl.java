import java.util.LinkedHashMap;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.SQLException;
import java.util.ArrayList;

// Implementation class for CollegeService interface
public class CollegeServiceImpl implements CollegeService {
	    
		// Method to insert a new college record
		public void insertCollege(LinkedHashMap  <String,Object> college ) { 
	        
			// Extracting values from the LinkedHashMap
			int collegeId=Integer.parseInt(college.get("collegeId").toString());
			String collegeName=college.get("collegeName").toString();
			String location=college.get("location").toString();
			String type=college.get("type").toString();
			int counsellingCode=Integer.parseInt(college.get("counsellingCode").toString());
			boolean isAutonomous=Boolean.valueOf(college.get("isAutonomous").toString());
			String universityName=college.get("universityName").toString();
			
			// Setting universityName to null if it's "none"
			if(universityName.equals("none")){
			    universityName=null;
			}
			
			// Setting createdBy and createdAt timestamps
            String createdBy="durga";
			Timestamp createdAt=new Timestamp(System.currentTimeMillis());
			
			// Setting modifiedBy and modifiedAt timestamps
			String modifiedBy="durga";
			Timestamp modifiedAt=new Timestamp(System.currentTimeMillis());
			
			// Creating CollegeDaoImpl object
			CollegeDao DaoObj=new CollegeDaoImpl();
			int check=DaoObj.insertCollege(collegeId,collegeName,location,type,counsellingCode,isAutonomous,universityName,createdBy,createdAt,modifiedBy,modifiedAt);
			
			// Checking if insertion was successful
			if (check> 0) {
                System.out.println("Record is inserted successfully");
            } else {
                System.out.println("Failed to insert");
            }
		}
		
		// Method to display college details by ID
	    public void displayById(int collegeById) {
			
			// Creating CollegeDaoImpl object
			CollegeDao DaoObj = new CollegeDaoImpl();
			// Retrieving college details by ID
		    LinkedHashMap<String,Object> college=DaoObj.displayById(collegeById);
			
			
			 // Extracting values from the returned LinkedHashMap
			int collegeId = Integer.parseInt(college.get("collegeId").toString());
			String collegeName = college.get("collegeName").toString();
			String location = college.get("location").toString();
			String type = college.get("type").toString();
			int counsellingCode = Integer.parseInt(college.get("counsellingCode").toString()); 
			boolean isAutonomous = Boolean.parseBoolean(college.get("isAutonomous").toString());

			String createdBy = college.get("createdBy").toString();
			Timestamp createdAt = Timestamp.valueOf(college.get("createdAt").toString());

			String modifiedBy = college.get("modifiedBy").toString();
			Timestamp modifiedAt = Timestamp.valueOf(college.get("modifiedAt").toString());

			// Formatting timestamps
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
			LocalDateTime createdDateTime = createdAt.toLocalDateTime();
			String formattedCreatedAt = createdDateTime.format(formatter).toUpperCase();
			LocalDateTime modifiedDateTime = modifiedAt.toLocalDateTime();
			String formattedModifiedAt = modifiedDateTime.format(formatter).toUpperCase();
			
			 // Displaying college details
			System.out.println("College ID: " + collegeId);
			System.out.println("College Name: " + collegeName);
			System.out.println("Location: " + location);
			System.out.println("Type: " + type);
			System.out.println("Counselling Code: " + counsellingCode);
			System.out.println("Is Autonomous: " + isAutonomous);
			System.out.println("Created By: " + createdBy);
			System.out.println("Created At: " + formattedCreatedAt);
			System.out.println("Modified By: " + modifiedBy);
			System.out.println("Modified At: " + formattedModifiedAt);
			
			
		}
		
		// Method to display all colleges
		public void displayAll() {
			 // Creating CollegeDaoImpl object
		    CollegeDao DaoObj = new CollegeDaoImpl();
			// Retrieving list of all colleges
            ArrayList<LinkedHashMap<String,Object>> listOfCollege =DaoObj.displayAll();
            
			// Checking if there are no records
			if(listOfCollege.size()==0) {
			    System.out.println("No Records");
				
			   }
			   
			else{
			//Displaying details for each college
		    System.out.println("Collge Details");
			for (LinkedHashMap<String, Object> college : listOfCollege) {
				
				// Extracting values from the LinkedHashMap
				int collegeId = Integer.parseInt(college.get("collegeId").toString());
				String collegeName = college.get("collegeName").toString();
				String location = college.get("location").toString();
				String type = college.get("type").toString();
				int counsellingCode = Integer.parseInt(college.get("counsellingCode").toString()); 
				boolean isAutonomous = Boolean.parseBoolean(college.get("isAutonomous").toString());
                String universityName = (college.get("universityName") != null) ? college.get("universityName").toString() : "none";

				
				String createdBy = college.get("createdBy").toString();
				Timestamp createdAt = Timestamp.valueOf(college.get("createdAt").toString());

				String modifiedBy = college.get("modifiedBy").toString();
				Timestamp modifiedAt = Timestamp.valueOf(college.get("modifiedAt").toString());
                
				 // Formatting timestamps
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
				LocalDateTime createdDateTime = createdAt.toLocalDateTime();
				String formattedCreatedAt = createdDateTime.format(formatter).toUpperCase();
				LocalDateTime modifiedDateTime = modifiedAt.toLocalDateTime();
				String formattedModifiedAt = modifiedDateTime.format(formatter).toUpperCase();
				
				 // Displaying college details
				System.out.println("College ID: " + collegeId);
				System.out.println("College Name: " + collegeName);
				System.out.println("Location: " + location);
				System.out.println("Type: " + type);
				System.out.println("Counselling Code: " + counsellingCode);
				System.out.println("Is Autonomous: " + isAutonomous);
				System.out.println("university Name:"+universityName);
				System.out.println("Created By: " + createdBy);
				System.out.println("Created At: " + formattedCreatedAt);
				System.out.println("Modified By: " + modifiedBy);
				System.out.println("Modified At: " + formattedModifiedAt);
				
				System.out.println("\n\n");
			}			
          }					
		}
		
		// Method to delete a college record
		public void deleteCollege(int collegeId) {
		    
			CollegeDao DaoObj = new CollegeDaoImpl();
			int check=DaoObj.deleteCollege(collegeId);
			
			if(check>0) {
			    System.out.println("Record deleted successfully"); 
			}
			else {
				System.out.println("Record delete failed"); 
			}
				
		}
		
		// Method to update college name
		public void updateCollegeName (int collegeId,String newName) {
		     // Creating CollegeDaoImpl object
			 CollegeDao DaoObj = new CollegeDaoImpl();
			 String modifiedBy="Reena";
			 // Setting modifiedBy and modifiedAt timestamps
			 Timestamp modifiedAt=new Timestamp(System.currentTimeMillis());
			 
			 
			int check=DaoObj.updateCollegeName(collegeId,newName,modifiedBy,modifiedAt);
			 
			if(check>0) {
			    System.out.println("Record updated successfully"); 
			   }
			else {
				System.out.println("Record updated failed"); 
			}
			System.out.println(newName);
	    }
		
		// Method to update college location
		public void updateCollegeLocation(int collegeId,String newLocation){
		     // Creating CollegeDaoImpl object
			 CollegeDao DaoObj = new CollegeDaoImpl();
             // Setting modifiedBy and modifiedAt timestamps			
			 String modifiedBy="Reena";
			 Timestamp modifiedAt=new Timestamp(System.currentTimeMillis());
			 
			 // Updating college location in the database
			 int check=DaoObj.updateCollegeLocation(collegeId,newLocation,modifiedBy,modifiedAt);
			 
			 // Checking if update was successful
			 if(check>0) {
			    System.out.println("Record updated successfully"); 
			   }
			else {
				System.out.println("Record updated failed"); 
			}
		}
		
		// Method to update college type
	    public void updateCollegeType(int collegeId,String newType){
			 // Creating CollegeDaoImpl object
		     CollegeDao DaoObj = new CollegeDaoImpl();
			 // Setting modifiedBy and modifiedAt timestamps
			 String modifiedBy="Reena";
			 Timestamp modifiedAt=new Timestamp(System.currentTimeMillis());
			 
			 // Updating college type in the database
			 int check=DaoObj.updateCollegeType(collegeId,newType,modifiedBy,modifiedAt);
			 
			 // Checking if update was successful
			 if(check>0) {
			    System.out.println("Record updated successfully"); 
			   }
			else {
				System.out.println("Record updated failed"); 
			}
		}
		
		// Method to update college code
		public void updateCollegeCode (int collegeId,int newCode) {
		     // Creating CollegeDaoImpl object
			 CollegeDao DaoObj = new CollegeDaoImpl();
			 // Setting modifiedBy and modifiedAt timestamps
			 String modifiedBy="Reena";
			 Timestamp modifiedAt=new Timestamp(System.currentTimeMillis());
			 
			 // Updating college code in the database
			 int check=DaoObj.updateCollegeCode(collegeId,newCode,modifiedBy,modifiedAt);
			 
			 // Checking if update was successful
			 if(check>0) {
			    System.out.println("Record updated successfully"); 
			   }
			 else {
				System.out.println("Record updated failed"); 
			}
	    }
		
		// Method to update college autonomous status
		public void updateCollegeAutonomous(int collegeId,boolean newAutonomous){
		    // Creating CollegeDaoImpl object
			CollegeDao DaoObj = new CollegeDaoImpl();
			// Setting modifiedBy and modifiedAt timestamps
			String modifiedBy="Reena";
			Timestamp modifiedAt=new Timestamp(System.currentTimeMillis());
			
			// Updating college autonomous status in the database
			int check=DaoObj.updateCollegeAutonomous(collegeId,newAutonomous,modifiedBy,modifiedAt);
			 
			 // Checking if update was successful 
			if(check>0) {
			    System.out.println("Record updated successfully"); 
			   }
			else {
				System.out.println("Record updated failed"); 
			}
		}
		
		public void updateAll(LinkedHashMap <String,Object> college){
			
			
			String modifiedBy="Reena";
			Timestamp modifiedAt=new Timestamp(System.currentTimeMillis());
			int check=DaoObj.updateAll(collegeId,modifiedBy,modifiedAt);
			
		}
		
}
