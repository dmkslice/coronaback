package covid.back.kandidat.rest.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.*;
import java.util.*;
import java.util.List;

import covid.back.kandidat.rest.model.Location;

public class Locationservice {
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
	
	
    public ArrayList<Location> getAllLocations(String timestamp){
        ArrayList<Location> locationList = new ArrayList<Location>();
        int symptomLocationID = 0;
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(URL, databaseUsername, databasePassword);  
            //here DatabaseCoronaApp is the database name, root is username and password  
            java.sql.Statement stmt= con.createStatement();  
            ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from SymptomLocation");  
            while(rs.next()) {
                symptomLocationID = rs.getInt(1);
                longitude = rs.getString(2);
                latitude = rs.getString(3);
                userTimestamp = rs.getString(4);
                LocalDateTime convertedTimestamp = LocalDateTime.parse(userTimestamp);
                userDate = rs.getString(5);
                LocalDate convertedDate = LocalDate.parse(userDate);
                headache = rs.getInt(6);
                nasalCongestion = rs.getInt(7);
                soreThroat = rs.getInt(8);
                breathingDifficulties = rs.getInt(9);
                cough = rs.getInt(10);
                runnyNose = rs.getInt(11);
                fever = rs.getInt(12);
                diarrhea = rs.getInt(13);
                tiredness = rs.getInt(14);
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
	
	
		
	public ArrayList<Location> getUserLocation(String email){
        ArrayList<Location> locationList = new ArrayList<Location>();
        int userID = 0;
        List<Integer> locationIDList = new ArrayList<>();
        int symptomLocationID = 0;
        int rowsOfLocationID = 0;
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(URL, databaseUsername, databasePassword);  
            //here DatabaseCoronaApp is the database name, root is username and password  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select ID from User where email='" + email + "'");  
            while(rs.next()) {
                userID= rs.getInt(1);
            } 
            ResultSet num= stmt.executeQuery("select COUNT(*) from User_Location where User_Id ='"+userID+"'");
            while(num.next()) {  
            	rowsOfLocationID=num.getInt(1);
                System.out.println(rowsOfLocationID);
            }
            ResultSet findLocationID = stmt.executeQuery("select SymptomLocation_Id from User_Location where User_Id ='"+userID+"'");
            
                for (int i = 1; i<=rowsOfLocationID; i++){
                    while (findLocationID.next()) {
                    locationIDList.add(findLocationID.getInt(i));
                    System.out.println(locationIDList);
                }
            }
            for (int i = 0; i<rowsOfLocationID; i++){
                ResultSet findLocations = stmt.executeQuery("select * from SymptomLocation where Id='"+locationIDList.get(i)+"'");
                while(findLocations.next()) {
                    symptomLocationID = findLocations.getInt(1);
                    longitude = findLocations.getString(2);
                    latitude = findLocations.getString(3);
                    userTimestamp = findLocations.getString(4);
                    LocalDateTime convertedTimestamp = LocalDateTime.parse(userTimestamp);
                    userDate = findLocations.getString(5);
                    LocalDate convertedDate = LocalDate.parse(userDate);
                    headache = findLocations.getInt(6);
                    nasalCongestion = findLocations.getInt(7);
                    soreThroat = findLocations.getInt(8);
                    breathingDifficulties = findLocations.getInt(9);
                    cough = findLocations.getInt(10);
                    runnyNose = findLocations.getInt(11);
                    fever = findLocations.getInt(12);
                    diarrhea = findLocations.getInt(13);
                    tiredness = findLocations.getInt(14);
                    Location location = new Location (longitude, latitude, convertedDate, symptomLocationID, headache, nasalCongestion, soreThroat, breathingDifficulties, cough, runnyNose, fever, diarrhea, tiredness, convertedTimestamp);
                    locationList.add(location);
                }
            }
            
            con.close(); 
        }
        catch(Exception e){
            System.out.println(e);
        }  
        return locationList;
    }

	
	public boolean createUserLocation(String email, String longitude, String latitude, String userTimestamp, String userDate, int headache, int nasalCongestion, int soreThroat, int breathingDifficulties, int cough, int runnyNose, int fever, int diarrhea, int tiredness){
        boolean validUserCreated = false;
		ArrayList<Location> locationList = new ArrayList<Location>();
        int userID = 0;
        int SymptomLocationID = 0;
        List<Integer> locationIDList = new ArrayList<>();
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(URL, databaseUsername, databasePassword);  
            //here DatabaseCoronaApp is the database name, root is username and password  
            Statement stmt=con.createStatement(); 
            ResultSet num= stmt.executeQuery("select COUNT(*) from SymptomLocation");
            while(num.next()) {  
            	SymptomLocationID=num.getInt(1);
                System.out.println("Hej");
            }
            SymptomLocationID++;
            ResultSet rs=stmt.executeQuery("select ID from User where email='" + email + "'");  
            System.out.println("Tja");
            if (rs.next()) {
                userID= rs.getInt(1);
                System.out.println(userID);
                stmt.executeUpdate("INSERT into SymptomLocation values('"+SymptomLocationID +"','"+longitude+"','"+latitude+"','"+userTimestamp+"','"+userDate+"','"+headache+"','"+nasalCongestion+"','"+soreThroat+"','"+breathingDifficulties+"','"+cough+"','"+runnyNose+"','"+fever+"','"+diarrhea+"','"+tiredness+"')");
                stmt.executeUpdate("INSERT into User_Location values('"+userID+"','"+SymptomLocationID+"')");
                validUserCreated = true;
            } 
            con.close(); 
        }
        catch(Exception e){
            System.out.println(e);
        }  
        return validUserCreated;
    }
	
	
public Location updateLocation(Location userslocations){
		
		
		return null;
		
	}

public List<Location> updateuserLocations(List<Location> userslocations){
	
	
	return null;
	
}

public List<Location> removeUserLocations(List<Location> removelocations){
	
	
	return null;
	
}


public Location  removeLocation(Location removelocations){
	
	
	return null;
	
}

	

}
