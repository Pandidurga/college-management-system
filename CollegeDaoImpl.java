import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.ArrayList;

// Implementation of CollegeDao interface
public class CollegeDaoImpl implements CollegeDao {

    // Method to insert a new college record into the database
    public int insertCollege(int collegeId, String collegeName, String location, String type, 
                              int counsellingCode, boolean isAutonomous,String universityName, String createdBy, Timestamp createdAt, String modifiedBy, Timestamp modifiedAt) {
        Connection connection = null;
		int rowsInserted=0;
        try {
			
			// Establishing database connection
            connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
            Statement stmt = connection.createStatement();
            
			 // SQL query to insert a new college record
            String query = "INSERT INTO college_details (college_id, college_name, location, college_type, counselling_code, is_autonomous,university_name, created_by, created_at,modified_by,modified_at) " +
                           "VALUES (" + collegeId + ", '" + collegeName + "', '" + location + "', '" + type + "', " + counsellingCode + ", " +
                           isAutonomous + ",'" + universityName + "','" + createdBy + "', '" + createdAt + "' , '" + modifiedBy + "', '" + modifiedAt + "')";
            
			 // Executing the SQL query
            rowsInserted = stmt.executeUpdate(query);
        } 
		
		catch (SQLException e) {
            System.out.println(e);// Handling SQL exceptions
        } 
		
		finally {
            try {
                if (connection != null) {
                    connection.close();// Closing the database connection
                }
            } catch (SQLException e) {
                System.out.println(e);// Handling SQL exceptions
            }
        }
		return rowsInserted;// Returning the number of rows inserted

		
    }
	
	
	
	public LinkedHashMap<String,Object> displayById (int collegeById){
	       
		   Connection connection = null;
		   ResultSet result=null;
		   LinkedHashMap<String,Object> college =new LinkedHashMap<>();
			try {
				connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
				Statement stmt = connection.createStatement();

				String query = "SELECT * FROM college_details WHERE college_id="+collegeById;
				result=stmt.executeQuery(query);
				
				while (result.next()) {
					
					int collegeId = result.getInt("college_id");
					String collegeName = result.getString("college_name");
					String location = result.getString("location");
					String type = result.getString("college_type");
					int code = result.getInt("counselling_code");
					boolean isAutonomous = result.getBoolean("is_autonomous");
					String createdBy = result.getString("created_by");
					Timestamp createdAt = result.getTimestamp("created_at");
					String modifiedBy = result.getString("modified_By");
					Timestamp modifiedAt = result.getTimestamp("modified_At");

	

					college.put("collegeId" , collegeId);
					college.put("collegeName" , collegeName);
					college.put("location" , location);
					college.put("type" , type);
					college.put("counsellingCode" , code);
					college.put("isAutonomous" , isAutonomous);
					college.put("createdBy" , createdBy);
					college.put("createdAt" , createdAt);
					college.put("modifiedBy" , modifiedBy);
					college.put("modifiedAt" , modifiedAt);
					
				}
				
				
			} 
			
			catch (SQLException e) {
				System.out.println(e);
			} 
			
			finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			return college;
	}
	
	// Method to retrieve all college records from the database
	public  ArrayList<LinkedHashMap<String,Object>> displayAll() {
	        // Initializing ArrayList to hold college records
		   ArrayList<LinkedHashMap<String,Object>> listOfCollege = new ArrayList<>();
			
		   Connection connection = null;
		   ResultSet result=null;
		   
			try {
				// Establishing database connection
				connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
				Statement stmt = connection.createStatement();

                // SQL query to retrieve all college records
				String query = "SELECT * FROM college_details";
				result=stmt.executeQuery(query);
				
				// Looping through the result set and adding each college record to the ArrayList
				while (result.next()) {
					LinkedHashMap<String,Object> college =new LinkedHashMap<>();
					
					int collegeId = result.getInt("college_id");
					String collegeName = result.getString("college_name");
					String location = result.getString("location");
					String type = result.getString("college_type");
					int code = result.getInt("counselling_code");
					boolean isAutonomous = result.getBoolean("is_autonomous");
					String universityName=result.getString("university_name");
					String createdBy = result.getString("created_by");
					Timestamp createdAt = result.getTimestamp("created_at");
					String modifiedBy = result.getString("modified_By");
					Timestamp modifiedAt = result.getTimestamp("modified_At");

					
                    // Adding college details to the LinkedHashMap
					college.put("collegeId" , collegeId);
					college.put("collegeName" , collegeName);
					college.put("location" , location);
					college.put("type" , type);
					college.put("counsellingCode" , code);
					college.put("isAutonomous" , isAutonomous);
					college.put("createdBy" , createdBy);
					college.put("createdAt" , createdAt);
					college.put("modifiedBy" , modifiedBy);
					college.put("modifiedAt" , modifiedAt);
					college.put("universityName",universityName);
					
					listOfCollege.add(college);// Adding college record to the ArrayList
				}
				
				
			} 
			
			catch (SQLException e) {
				System.out.println(e);// Handling SQL exceptions
			} 
			
			finally {
				try {
					if (connection != null) {
						connection.close(); // Closing the database connection
					}
				} catch (SQLException e) {
					System.out.println(e); // Handling SQL exceptions
				}
			}
			
			return listOfCollege;// Returning the list of college records
			
			
	 }
	
	 // Method to delete a college record from the database based on college ID
	public int deleteCollege(int collegeId) {
	        Connection connection = null;
			int rowsdeleted=0;
			try {
				// Establishing database connection
				connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
				Statement stmt = connection.createStatement();
                
				// SQL query to delete a college record
				String query = "DELETE FROM college_details WHERE college_id="+collegeId;

                // Executing the SQL query
				rowsdeleted = stmt.executeUpdate(query);

			} 
			
			catch (SQLException e) {
				System.out.println(e);// Handling SQL exceptions
			} 
			
			finally {
				try {
					if (connection != null) {
						connection.close(); // Closing the database connection
					}
				} catch (SQLException e) {
					System.out.println(e);// Handling SQL exceptions
				}
			}
			// Returning the number of rows deleted
			return rowsdeleted;
		
	}
	
	 // Method to update college name in the database based on college ID
	public int updateCollegeName(int collegeId, String newName,String modifiedBy,Timestamp modifiedAt){
	
	        Connection connection = null;
			int rowsupdated=0;
			try {
				// Establishing database connection
				connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
				Statement stmt = connection.createStatement();
                
				// SQL query to update college name
                String query = "UPDATE college_details SET college_name = '"+ newName +"', " + "modified_by = '" + modifiedBy + "', " + "modified_at = '" + modifiedAt + "' " + "WHERE college_id = " + collegeId;
				rowsupdated = stmt.executeUpdate(query);

			} 
			
			catch (SQLException e) {
				System.out.println(e);// Handling SQL exceptions
			} 
			
			finally {
				try {
					if (connection != null) {
						connection.close();// Closing the database connection
					}
				} catch (SQLException e) {
					System.out.println(e);// Handling SQL exceptions
				}
			}
			return rowsupdated;
	}
	
	// Method to update college location in the database based on college ID
	public int updateCollegeLocation(int collegeId,String newLocation,String modifiedBy,Timestamp modifiedAt){
	
	        Connection connection = null;
			int rowsupdated=0;
			try {
				// Establishing database connection
				connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
				Statement stmt = connection.createStatement();

                // SQL query to update location
                String query = "UPDATE college_details SET location= '"+ newLocation +"', " + "modified_by = '" + modifiedBy + "', " + "modified_at = '" + modifiedAt + "' " + "WHERE college_id = " + collegeId;
				rowsupdated = stmt.executeUpdate(query);

			} 
			
			catch (SQLException e) {
				System.out.println(e);// Handling SQL exceptions
			} 
			
			finally {
				try {
					if (connection != null) {
						connection.close();// Closing the database connection
					}
				} catch (SQLException e) {
					System.out.println(e);// Handling SQL exceptions
				}
			}
			return rowsupdated;
	}
	
	// Method to update college type in the database based on college ID
	public int updateCollegeType(int collegeId, String newType,String modifiedBy,Timestamp modifiedAt){
	
	        Connection connection = null;
			int rowsupdated=0;
			try {
				connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
				Statement stmt = connection.createStatement();
                
				// SQL query to update college type
                String query = "UPDATE college_details SET college_type= '"+ newType +"', " + "modified_by = '" + modifiedBy + "', " + "modified_at = '" + modifiedAt + "' " + "WHERE college_id = " + collegeId;
				rowsupdated = stmt.executeUpdate(query);

			} 
			
			catch (SQLException e) {
				System.out.println(e);// Handling SQL exceptions
			} 
			
			finally {
				try {
					if (connection != null) {
						connection.close();// Closing the database connection
					}
				} catch (SQLException e) {
					System.out.println(e);// Handling SQL exceptions
				}
			}
			return rowsupdated;
	}
	
	// Method to update college code in the database based on college ID
	public int updateCollegeCode(int collegeId,int newCode,String modifiedBy,Timestamp modifiedAt){
	
	        Connection connection = null;
			int rowsupdated=0;
			try {
				connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
				Statement stmt = connection.createStatement();
                
				// SQL query to update college code
				String query = "UPDATE college_details SET " + "counselling_code = " + newCode + ", " + "modified_by = '" + modifiedBy + "', " + "modified_at = '" + modifiedAt + "' " + "WHERE college_id = " + collegeId;

				rowsupdated = stmt.executeUpdate(query);

			} 
			
			catch (SQLException e) {
				System.out.println(e);
			} 
			
			finally {
				try {
					if (connection != null) {
						connection.close();// Closing the database connection
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			return rowsupdated;
	}
	
	// Method to update college autonomous status in the database based on college ID
	public int updateCollegeAutonomous(int collegeId,boolean newAutonomous,String modifiedBy,Timestamp modifiedAt){
	
	        Connection connection = null;
			int rowsupdated=0;
			try {
				connection = GetDbConnection.getConnect(); // Obtain connection from GetDbConnection
				Statement stmt = connection.createStatement();

                // SQL query to update college autonomous
                String query = "UPDATE college_details SET " + "is_autonomous = " + newAutonomous+ ", " + "modified_by = '" + modifiedBy + "', " + "modified_at = '" + modifiedAt + "' " + "WHERE college_id = " + collegeId;
                 
				rowsupdated = stmt.executeUpdate(query);

			} 
			
			catch (SQLException e) {
				System.out.println(e);
			} 
			
			finally {
				try {
					if (connection != null) {
						connection.close();// Closing the database connection
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			return rowsupdated;
	}
	
	public void updateAllInOne(){
		
	}
	
}

/* public static void main(String argsh[]){
		CollegeDaoImpl obj=new CollegeDaoImpl();
		Timestamp createdAt=new Timestamp(System.currentTimeMillis());
	    obj.displayAll();
		//obj.deleteCollege(1);
		obj.updateCollegeName(1,"KIT","Reena",createdAt);
		//obj.insertCollege(11,"Siet","cbe","public",122,true,"durga",createdAt,"durga",createdAt);
	}*/