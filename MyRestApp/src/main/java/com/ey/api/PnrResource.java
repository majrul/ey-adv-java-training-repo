package com.ey.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ey.entity.Passenger;
import com.ey.entity.Passenger.Gender;
import com.ey.entity.Passenger.Status;
import com.ey.entity.Pnr;

@Path("/pnr-status")
public class PnrResource {

	//URI: http://localhost:8080/MyRestApp/api/pnr-status?pnrNo=1111111111
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Pnr getStatus(@QueryParam("pnrNo") int pnrNo) {*/
	
	//URI: http://localhost:8080/MyRestApp/api/pnr-status/11111111
	/*@GET
	@Path("/{pnrNo}")
	public Pnr getStatus(@PathParam("pnrNo") int pnrNo) {*/
	
	//URI: http://localhost:8080/MyRestApp/api/pnr-status;pnrNo=1111111111
	//@GET
	//public Pnr getStatus(@MatrixParam("pnrNo") int pnrNo) {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Pnr getStatus(@QueryParam("pnrNo") int pnrNo) {
		//for the time being we will hardcode some data
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2024, 9, 20));
		
		List<Passenger> passengers = new ArrayList<>();
		Passenger p1 = new Passenger();
		p1.setName("Ram");
		p1.setGender(Gender.MALE);
		p1.setStatus(Status.WAITING);
		Passenger p2 = new Passenger();
		p2.setName("Shyam");
		p2.setGender(Gender.MALE);
		p2.setStatus(Status.RAC);
		passengers.add(p1);
		passengers.add(p2);
		pnr.setPassengers(passengers);
		
		return pnr;
	}
}
