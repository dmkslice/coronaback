package covid.back.kandidat.rest.resources;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import covid.back.kandidat.rest.model.Location;
import covid.back.kandidat.rest.service.Locationservice;

@Path("location")
public class locationResources {
	
	Locationservice locationservice=new Locationservice();
	
	@GET
	@Path("/{timestamp}")
	@Produces(MediaType.TEXT_PLAIN)
	public ArrayList<Location> GetLocations(@PathParam ("timestamp")String timestamp) {
		
	ArrayList<Location> listLocation;
	return listLocation=locationservice.getAllLocations(timestamp);
	}

}
