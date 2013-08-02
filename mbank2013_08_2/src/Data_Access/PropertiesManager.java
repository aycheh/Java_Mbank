package Data_Access;

import java.sql.Connection;

import Core_System.Properties;

public interface PropertiesManager {

		/**edit properties table **/
	public boolean updatepropertiesvalues(Connection con, PropertiesManager p);
	
	/**select Properties from table **/
	public  Properties selectPropertiesValues(Connection con, Properties p);
		
	
	
	
	
	
	
	
}/**end of interface*/
