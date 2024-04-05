import java.util.LinkedHashMap;
public interface CollegeService {
        public void insertCollege(LinkedHashMap <String,Object> college);
        public void displayById(int collegeById);
		public void displayAll();
		public void updateCollegeName (int collegeId,String newName);
		public void updateCollegeLocation(int collegeId,String newLocation);
		public void updateCollegeType(int collegeId,String newType);
		public void updateCollegeCode (int collegeId,int newCode);
		public void updateCollegeAutonomous(int collegeId,boolean newAutonomous);
		public void deleteCollege(int collegId);
		public void updateAll(LinkedHashMap <String,Object> college);
		
		
} 

