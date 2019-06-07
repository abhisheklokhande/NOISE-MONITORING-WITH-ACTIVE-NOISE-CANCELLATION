package service;

import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.json.JSONObject;
import database.ConnectionManager;
import database.ConnectionMysql;

@Path("/sound")
public class SoundLevel {
	
	private static final String ERROR = "Error";
	
	//Set up your connection here
	private static ConnectionMysql conn = new ConnectionMysql("jdbc:mysql://localhost:3306/","root","Pervasive_System_2017");
	
	//Test case to check the server status
	@Path("/hellosound")
	@GET
	@Produces("text/plain")
	public Response hello(){
		System.out.println("Some one arrives here");
		return Response.ok().entity("Sound path say hello!").build();
	}
	
	
	/*
	 * This function return a json containing the sensors list stored in the db
	 * This is used to populate the map with the static sensor
	 */
	@Path("/getSensorList")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getSensorList(){
		//Open the connection with the db
        ConnectionManager cm;
        JSONObject sensorList = new JSONObject();
		try {
			cm = new ConnectionManager(conn);
			sensorList = cm.sensorList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(sensorList.keySet().contains(ERROR)){
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(sensorList.toString()).build();
	    }
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(sensorList.toString()).build();
	}
	
	/*
	 * This function return the list with the user rilevations
	 * This is used to populate the map in the client side
	 */
	@Path("/getUserDataList")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getUserDataList(){
		//Open the connection with the db
        ConnectionManager cm;
        JSONObject sensorList = new JSONObject();
		try {
			cm = new ConnectionManager(conn);
			 sensorList = cm.userDataList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(sensorList.keySet().contains(ERROR)){
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(sensorList.toString()).build();
	    }
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(sensorList.toString()).build();
	}
	
	/*
	 * This function return all the data collected by a sensor:
	 * The sensorName is passed as a query parameter
	 * This is used to choose how to draw the graphical component in the client
	 */
	@Path("/getSensorValues")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getSensorValues(@QueryParam("sensorName") String sensorName){
		//Open the connection with the db
	    ConnectionManager cm;
	    JSONObject sensorValues = new JSONObject();
	    try {
			cm = new ConnectionManager(conn);
			sensorValues = cm.sensorValues(sensorName);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(sensorValues.keySet().contains(ERROR)){
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(sensorValues.toString()).build();
	    	
	    }
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(sensorValues.toString()).build();
	}
	
	/*
	 * This function calculate some stats on the specified sensor
	 * The sensorName is passed as a parameter and we have to specify a day too
	 * The result is a json with all the rilevations taken by the sensor in the choosen day
	 * This is used on the client side to draw the chart pie
	 * 
	 */
	@Path("/getAvgValues")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getAvgDayValues(@QueryParam("sensorName") String sensorName, @QueryParam("day") int dayOfWeek){
		//Open the connection with the db
	    ConnectionManager cm;
	    JSONObject avgValues = new JSONObject();
	    try {
			cm = new ConnectionManager(conn);
			avgValues = cm.avgPerDay(sensorName, dayOfWeek);
			}
	    catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(avgValues.keySet().contains(ERROR)){
		    return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(avgValues.toString()).build();
		    	
		 	}
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(avgValues.toString()).build();
	}
	
	/*
	 * This function calculate some logic(Average of noise, Max, Min and last rilevaion)
	 * This data are printed when the client click on a static sensor in the map
	 */
	@Path("/getSensorStats")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getSensorStats(@QueryParam("sensorName") String sensorName){
		//Open the connection with the db
	    ConnectionManager cm;
	    JSONObject sensorStats = new JSONObject();
	    try {
			cm = new ConnectionManager(conn);
			sensorStats = cm.sensorStats(sensorName);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(sensorStats.keySet().contains(ERROR)){
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(sensorStats.toString()).build();
	    	
	    }
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(sensorStats.toString()).build();
	}
	
	
	/*
	 * This function is used by the sensor to post their own data
	 * The parameter "String noise" contain a json with all the value of the sensor
	 * (sensorName, latitude, longitude, noiseLevel)
	 * It return the body in case of success
	 * 
	 */
	@Path("/sendNoiseLevel")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response postSoundLevel(String noise) throws ClassNotFoundException, SQLException{
		//Open the connection with the db
		ConnectionManager cm;
	    JSONObject sensorPost = new JSONObject();
	    try {
			cm = new ConnectionManager(conn);
			sensorPost = cm.sensorPost(noise);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	    if(sensorPost.keySet().contains(ERROR)){
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(sensorPost.toString()).build();
	    	
	    }
        return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity("Result of the the request : "+ sensorPost.toString()).build();
	}
	
	/*
	 * This function is used by the user to post their own data
	 * The parameter "String noise" contain a json with all the value of the sensor
	 * (userName, latitude, longitude, noiseLevel, noiseType)
	 * It return the body in case of success
	 * 
	 */
	@Path("/userNoiseLevel")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response userData(String noise) throws ClassNotFoundException, SQLException{
		//Open the connection with the db
		ConnectionManager cm;
	    JSONObject sensorPost = new JSONObject();
	    try {
			cm = new ConnectionManager(conn);
			sensorPost = cm.userPost(noise);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	    if(sensorPost.keySet().contains(ERROR)){
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(sensorPost.toString()).build();
	    	
	    }
	       return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity("Result of the the request : "+ sensorPost.toString()).build();
	}
	
	/*
	 * This function is used to delete one sensor from the sensorlist table
	 * Useful in the deployment stage, in order to avoid the schema drop each time
	 * 
	 */
	@Path("/deleteSensor")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response deleteSensor(@QueryParam("sensorName") String sensorName){
		//Open the connection with the db
        ConnectionManager cm;
        JSONObject operationResult = new JSONObject();
		try {
			cm = new ConnectionManager(conn);
			 operationResult = cm.deleteSensor(sensorName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(operationResult.keySet().contains(ERROR)){
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(operationResult.toString()).build();
	    }
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(operationResult.toString()).build();
		}

}
