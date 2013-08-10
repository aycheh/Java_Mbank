package Data_Access;

import java.sql.Connection;
import java.util.List;
import Core_System.Properties;

public interface PropertiesManager {

	
	/**get Properties**/
	public  Properties getPropertiesValues(Connection con, Properties p);
	/**update System Property **/
	public void updateSystemProperty(Connection con, Properties p);
	/**getAllProperties**/
	public List<Properties> getAllProperties(Connection con);

	
}/**end of interface*/
