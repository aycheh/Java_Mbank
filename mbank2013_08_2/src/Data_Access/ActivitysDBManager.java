package Data_Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Core_System.Account;
import Core_System.Activity;
import Core_System.Client;

public class ActivitysDBManager implements ActivitysManager {
private static ActivitysDBManager instance;
	
	private ActivitysDBManager() {
	}
	
	public static ActivitysDBManager getInstance(){
		if (instance == null) {
			instance = new ActivitysDBManager();
		}
		return instance;
	}


	@Override
	public void createNewActivity(Connection con, Activity activ) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into activity value (?,?,?,?,?,?)");
			pstmt.setLong(1, activ.getId());
			pstmt.setLong(2, activ.getClient_id());
			pstmt.setDouble(3, activ.getAmount());
			pstmt.setDate(4, (Date) activ.getActivity_date());
			pstmt.setDouble(5, activ.getCommission());
			pstmt.setString(6, activ.getDescription());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("problem with sql");
			e.printStackTrace();
		}
	}
	
	
	

	
	@Override
	public List<Activity> getClientActivities(Connection con, int Client_id) {
		// TODO Fix This and get client activities using client_id !!!!!
		Statement stmt = null;
	    String query = "select id, client_id, amount, activity_date, commission,description "  + "from "  + " activity"; 
	    		//("select * from activity where client_id = ?" );
	       // ("select id, client_id, amount, activity_date, commission,description from activity  where  client_id  = ?");
	    List<Activity> clientActivitys = new ArrayList<Activity>(Client_id);
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            int client_id = rs.getInt("client_id");
	            Double amount = rs.getDouble("amount");
	            Date activity_date = rs.getDate("activity_date");
	            Double commission = rs.getDouble("commission");
	            String description = rs.getString("description");
//	            
//	            System.out.println(id + "\t" + client_id +
//	                               "\t" + amount + "\t" + activity_date +
//	                               "\t" + commission + "\t" + description + "\t" );
	           	
	            clientActivitys.add(new Activity(id ,client_id, amount, activity_date,commission,description));
	        }  
	    } catch (SQLException e ) {
	    	System.err.println("No Date to return >>>>>>>> : "+query);
	    }
	    
		return clientActivitys;
	
		}
	
	
	
	
	
	
	

	@Override
	public List<Activity> getAllClientsActivitys(Connection con) {
				Statement stmt = null;
			    String query =
			        "select id, client_id, amount, activity_date, commission,description "  + "from "  + " activity";
			    List<Activity> activitys = new ArrayList<Activity>();
			    try {
			        stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next()) {
			            int id = rs.getInt("id");
			            int client_id = rs.getInt("client_id");
			            Double amount = rs.getDouble("amount");
			            Date activity_date = rs.getDate("activity_date");
			            Double commission = rs.getDouble("commission");
			            String description = rs.getString("description");
			            
			            System.out.println(id + "\t" + client_id +
			                               "\t" + amount + "\t" + activity_date +
			                               "\t" + commission + "\t" + description + "\t" );
			           	
			            activitys.add(new Activity(id ,client_id, amount, activity_date,commission,description));
			        }  
			    } catch (SQLException e ) {
			    	System.err.println("No Data to return   >>> :");
			    }
		return activitys;
	}	
	}

