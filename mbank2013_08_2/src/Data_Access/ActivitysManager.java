package Data_Access;

import java.sql.Connection;
import java.util.List;

import Core_System.Activity;
import Core_System.Client;

public interface ActivitysManager {

	/** insert new Activity to DB */
	public void createNewActivity(Connection con, Activity activ);
	
	/***select Client activity's***/
	public List<Activity> getClientActivities(Connection conn, int Client_id);
	
	/***select list of activity's property***/
	public List<Activity> getAllClientsActivitys(Connection conn);

}
