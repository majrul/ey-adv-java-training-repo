package com.ey.api;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ey.dao.TradeDao;
import com.ey.entity.MyBean;
import com.ey.entity.Status;
import com.ey.entity.Trade;

@Path("/example")
public class LearningRestApi {

	//http://localhost:8080/MyRestApp/api/example/01/1001/John/10000
	@GET
	@Path("/01/{empno}/{name}/{salary}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example01(
			@PathParam("empno") int empno,
			@PathParam("name") String name,
			@PathParam("salary") double salary) {
		
		System.out.println(empno + " , " + name + " , " + salary);
		return "Response from example01";
	}
	
	//http://localhost:8080/MyRestApp/api/example/02?empno=1001&name=John&salary=10000
	@GET
	@Path("/02")
	@Produces(MediaType.TEXT_PLAIN)
	public String example02(
			@QueryParam("empno") int empno,
			@QueryParam("name") String name,
			@QueryParam("salary") double salary) {
		
		System.out.println(empno + " , " + name + " , " + salary);
		return "Response from example02";
	}

	//http://localhost:8080/MyRestApp/api/example/03;empno=1001;name=John;salary=10000
	@GET
	@Path("/03")
	@Produces(MediaType.TEXT_PLAIN)
	public String example03(
			@MatrixParam("empno") int empno,
			@MatrixParam("name") String name,
			@MatrixParam("salary") double salary) {
		
		System.out.println(empno + " , " + name + " , " + salary);
		return "Response from example03";
	}

	//http://localhost:8080/MyRestApp/api/example/04/1001/John
	@GET
	@Path("/04/{empno : \\d+}/{name : [a-zA-Z]*}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example04(
			@PathParam("empno") int empno,
			@PathParam("name") String name) {
		
		System.out.println(empno + " , " + name);
		return "Response from example04";
	}

	//http://localhost:8080/MyRestApp/api/example/05/1001/1002/1003/1004/1005/action/sendEmail
	//http://localhost:8080/MyRestApp/api/example/05/1001/1002;sendSMSAsWell=true/1003/1004;sendSMSAsWell=true;doubleCheck=true/1005/action/sendEmail
	@GET
	@Path("/05/{empnos : .+}/action/{someAction}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example05(
			//@PathParam("empnos") String empnos,
			//@PathParam("empnos") List<String> empnos, //this doesn't work
			@PathParam("empnos") List<PathSegment> empnos,
			@PathParam("someAction") String action) {

		for(PathSegment empno : empnos) {
			System.out.println(empno.getPath());
			System.out.println(empno.getMatrixParameters());
		}
		System.out.println(action);
		return "Response from example05";
	}
	
	//http://localhost:8080/MyRestApp/api/example/06/abc/xyz;param4=123?param3=456
	@GET
	@Path("/06/{param1}/{param2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example06(@BeanParam MyBean myBean) {
		
		System.out.println(myBean);
		return "Response from example06";
	}

	@GET
	@Path("/07/{param1}/{param2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example07(@Context UriInfo uriInfo) {
		
		System.out.println(uriInfo.getPath());
		System.out.println(uriInfo.getAbsolutePath());
		System.out.println(uriInfo.getBaseUri());
		System.out.println(uriInfo.getRequestUri());
		
		return "Response from example07";
	}

	@POST
	@Path("/08")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String example08(Trade trade) {
		System.out.println(trade);
		
		TradeDao dao = new TradeDao();
		dao.add(trade);
		
		return "Trade record created successfully!";
	}
	
	@POST
	@Path("/09")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status example09(Trade trade) {
		System.out.println(trade);
		
		TradeDao dao = new TradeDao();
		dao.add(trade);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Trade record created successfully!");
		
		return status;
	}


	@POST
	@Path("/10")
	public Response example10(Trade trade) {
		System.out.println(trade);
		
		TradeDao dao = new TradeDao();
		dao.add(trade);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Trade record created successfully!");
		
		return Response
				//.status(200)
				.ok()
				.entity(status)
				.type(MediaType.APPLICATION_JSON)
				.header("app-key", "ABCD12345")
				.build();
	}
}
