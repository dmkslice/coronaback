package covid.back.kandidat.rest.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.*;
import java.util.*;
import java.util.List;

import covid.back.kandidat.rest.model.Location;

public class Locationservice {
	
	
	public ArrayList<Location> getAllLocations(String timestamp){
        ArrayList<Location> locationList = new ArrayList<Location>();
        int symptomLocationID = 0;
        String longitude = null;
        String latitude = null;
        String userTimestamp = null;
        String userDate = null;
        int headache = 0;
        int nasalCongestion = 0;
        int soreThroat = 0;
        int breathingDifficulties = 0;
        int cough = 0;
        int runnyNose = 0;
        int fever = 0;
        int diarrhea = 0;
        int tiredness = 0;
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(URL, databaseUsername, databasePassword);  
            //here DatabaseCoronaApp is the database name, root is username and password  
            java.sql.Statement stmt= con.createStatement();  
            ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from SymptomLocationsNew");  
            while(rs.next()) {
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3));
                symptomLocationID = rs.getInt(1);
                longitude = rs.getString(2);
                latitude = rs.getString(3);
                userTimestamp = rs.getString(4);
                LocalDateTime convertedTimestamp = LocalDateTime.parse(userTimestamp);
                userDate = rs.getString(5);
                LocalDate convertedDate = LocalDate.parse(userDate);
                headache = rs.getInt(5);
                nasalCongestion = rs.getInt(6);
                soreThroat = rs.getInt(7);
                breathingDifficulties = rs.getInt(8);
                cough = rs.getInt(9);
                runnyNose = rs.getInt(10);
                fever = rs.getInt(11);
                diarrhea = rs.getInt(12);
                tiredness = rs.getInt(13);
                Location location = new Location (longitude, latitude, convertedDate, symptomLocationID, headache, nasalCongestion, soreThroat, breathingDifficulties, cough, runnyNose, fever, diarrhea, tiredness, convertedTimestamp);
                locationList.add(location);
                }
            con.close();
            }
        catch(Exception e){
            System.out.println(e);
        }  
        return locationList;
    }
	
	
public List<Location> GetuserLocations(String email){	
		
		return null;
		
	}
	
	
public Location updateLocation(Location userslocations){
		
		
		return null;
		
	}

public List<Location> updateuserLocations(List<Location> userslocations){
	
	
	return null;
	
}

public List<Location> removeLocations(List<Location> removelocations){
	
	
	return null;
	
}


public Location  removeLocation(Location removelocations){
	
	
	return null;
	
}

	

}
