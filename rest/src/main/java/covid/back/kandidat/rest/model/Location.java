package covid.back.kandidat.rest.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Location {
	  	String latitude;
	    String longitude;
	    LocalDate date;
	    int id;
	    int diarrheaRatingBar;
	    int runnyNoseRatingBar;
	    int nasalCongestionRatingBar;
	    int headacheRatingBar;
	    int throatRatingBar;
	    int breathingRatingBar;
	    int tirednessRatingBar;
	    int coughRatingBar;
	    int feverRatingBar;
	    LocalDateTime regTime;
	    public Location() {
	    	
	    }
	 
	    public Location(String latitude, String longitude, LocalDate date, int id, int diarrheaRatingBar, int runnyNoseRatingBar, int nasalCongestionRatingBar, int headacheRatingBar, int throatRatingBar, int breathingRatingBar, int tirednessRatingBar, int coughRatingBar, int feverRatingBar, LocalDateTime regTime) {
	        this.latitude = latitude;
	        this.longitude = longitude;
	        this.date = date;
	        this.id = id;
	        this.diarrheaRatingBar = diarrheaRatingBar;
	        this.runnyNoseRatingBar = runnyNoseRatingBar;
	        this.nasalCongestionRatingBar = nasalCongestionRatingBar;
	        this.headacheRatingBar = headacheRatingBar;
	        this.throatRatingBar = throatRatingBar;
	        this.breathingRatingBar = breathingRatingBar;
	        this.tirednessRatingBar = tirednessRatingBar;
	        this.coughRatingBar = coughRatingBar;
	        this.feverRatingBar = feverRatingBar;
	        this.regTime = regTime;
	    }
	 
	    public String getLatitude() {
	        return latitude;
	    }
	 
	    public void setLatitude(String latitude) {
	        this.latitude = latitude;
	    }
	 
	    public String getLongitude() {
	        return longitude;
	    }
	 
	    public void setLongitude(String longitude) {
	        this.longitude = longitude;
	    }
	 
	    public LocalDate getDate() {
	        return date;
	    }
	 
	    public void setDate(LocalDate date) {
	        this.date = date;
	    }
	 
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public int getDiarrheaRatingBar() {
	        return diarrheaRatingBar;
	    }
	 
	    public void setDiarrheaRatingBar(int diarrheaRatingBar) {
	        this.diarrheaRatingBar = diarrheaRatingBar;
	    }
	 
	    public int getRunnyNoseRatingBar() {
	        return runnyNoseRatingBar;
	    }
	 
	    public void setRunnyNoseRatingBar(int runnyNoseRatingBar) {
	        this.runnyNoseRatingBar = runnyNoseRatingBar;
	    }
	 
	    public int getNasalCongestionRatingBar() {
	        return nasalCongestionRatingBar;
	    }
	 
	    public void setNasalCongestionRatingBar(int nasalCongestionRatingBar) {
	        this.nasalCongestionRatingBar = nasalCongestionRatingBar;
	    }
	 
	    public int getHeadacheRatingBar() {
	        return headacheRatingBar;
	    }
	 
	    public void setHeadacheRatingBar(int headacheRatingBar) {
	        this.headacheRatingBar = headacheRatingBar;
	    }
	 
	    public int getThroatRatingBar() {
	        return throatRatingBar;
	    }
	 
	    public void setThroatRatingBar(int throatRatingBar) {
	        this.throatRatingBar = throatRatingBar;
	    }
	 
	    public int getBreathingRatingBar() {
	        return breathingRatingBar;
	    }
	 
	    public void setBreathingRatingBar(int breathingRatingBar) {
	        this.breathingRatingBar = breathingRatingBar;
	    }
	 
	    public int getTirednessRatingBar() {
	        return tirednessRatingBar;
	    }
	 
	    public void setTirednessRatingBar(int tirednessRatingBar) {
	        this.tirednessRatingBar = tirednessRatingBar;
	    }
	 
	    public int getCoughRatingBar() {
	        return coughRatingBar;
	    }
	 
	    public void setCoughRatingBar(int coughRatingBar) {
	        this.coughRatingBar = coughRatingBar;
	    }
	 
	    public int getFeverRatingBar() {
	        return feverRatingBar;
	    }
	 
	    public void setFeverRatingBar(int feverRatingBar) {
	        this.feverRatingBar = feverRatingBar;
	    }
	 
	    public LocalDateTime getRegTime() {
	        return regTime;
	    }
	 
	    public void setRegTime(LocalDateTime regTime) {
	        this.regTime = regTime;
	    }

}
