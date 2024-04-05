import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GetDbConnection {
    public static Connection getConnect() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_management_system", "root", "mysql123");
            System.out.println("Connected to database");
		
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	return connect;		
}}

//path=C:\Program Files\Java\jdk-19\bin
//set classpath=%classpath%;C:\Users\pramo\OneDrive\Desktop\SUNWARE TRAINING\CollegeManagementSystem\mysql-connector-j-8.3.0.jar;