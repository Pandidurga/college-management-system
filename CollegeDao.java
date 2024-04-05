import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.ArrayList;
public interface CollegeDao {
        public int insertCollege(int collegeId,String collegeName,String Location,String type,int counsellingCode,boolean isAutonomous,String universityName,String createdBy,Timestamp createdAt,String modifiedBy,Timestamp modifiedAt);
        public LinkedHashMap<String,Object> displayById(int collegeById);
		public ArrayList<LinkedHashMap<String,Object>> displayAll();
		public int deleteCollege(int collegeId);
		public int updateCollegeName (int collegeId,String newName,String modifiedBy,Timestamp modifiedAt);
		public int updateCollegeLocation(int collegeId,String newLocation,String modifiedBy,Timestamp modifiedAt);
		public int updateCollegeType(int collegeId,String newType,String modifiedBy,Timestamp modifiedAt);
		public int updateCollegeCode(int collegeId,int newCode,String modifiedBy,Timestamp modifiedAt);
		public int updateCollegeAutonomous(int collegeId,boolean newAutonomous,String modifiedBy,Timestamp modifiedAt);
		
		
}