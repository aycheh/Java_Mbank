package Data_Access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Core_System.Client;
import Core_System.Properties;

public class PropertiesDBManager implements PropertiesManager {
	private static PropertiesDBManager instance;

	private PropertiesDBManager() {

	}

	public static PropertiesDBManager getInstance() {
		if (instance == null) {
			instance = new PropertiesDBManager();
		}
		return instance;
	}

	/** select properties value **/
	@Override
	public Properties getPropertiesValues(Connection con, Properties p) {

		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from properties where prop_key = ? and prop_value = ?");
			pstmt.setString(1, p.getProp_key());
			pstmt.setString(2, p.getProp_value());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p.setProp_key(rs.getString(1));
				p.setProp_value(rs.getString(2));
				return p;
			} else {

				System.err.println("No Properties founed");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateSystemProperty(Connection con, Properties p) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update  properties set prop_value = ? where prop_key = ?");
			pstmt.setString(1, p.getProp_value());
			pstmt.setString(2, p.getProp_key());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No Properties founed");
			e.printStackTrace();
		}

	}

	@Override
	public List<Properties> getAllProperties(Connection con) {
		String query = "select prop_key,prop_value from  properties ";
		List<Properties> properties = new ArrayList<Properties>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String prop_key = rs.getString("prop_key");
				String prop_value = rs.getString("prop_value");

				// System.out.println(prop_key + "\t" + prop_value);

				properties.add(new Properties(prop_key, prop_value));
			}
		} catch (SQLException e) {
			System.err.println("No Properties founed");

		}

		for (Properties p : properties) {
			System.out.println(p);
		}
		return properties;
	}

}
/** End of class **/
