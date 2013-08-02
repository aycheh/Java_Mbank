package Data_Access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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

	@Override
	public boolean updatepropertiesvalues(Connection con, PropertiesManager p) {
		// TODO Auto-generated method stub
		return true;
	}

	/** select properties value **/
	@Override
	public Properties selectPropertiesValues(Connection con, Properties p) {

		try {
			PreparedStatement pstmt = con
					//.prepareStatement("select * from properties where prop_key=?;");
			         .prepareStatement("select * from properties where prop_key = ? and prop_value = ?");
			pstmt.setString(1, p.getProp_key());
			pstmt.setString(2, p.getProp_value());
//			pstmt.setDouble(3, p.getCommission_rate());
//			pstmt.setDouble(4, p.getGold_credit_limit());
//			pstmt.setDouble(5, p.getGold_daily_interest());
//			pstmt.setDouble(6, p.getGold_deposit_commission());
//			pstmt.setDouble(7, p.getGold_deposit_rate());
//			pstmt.setDouble(8, p.getPlatinum_credit_limit());
//			pstmt.setDouble(9, p.getPlatinum_daily_interest());
//			pstmt.setDouble(10, p.getPlatinum_deposit_commission());
//			pstmt.setDouble(11, p.getPlatinum_deposit_rate());
//			pstmt.setDouble(12, p.getPre_open_fee());
//			pstmt.setDouble(13, p.getRegular_credit_limit());
//    		pstmt.setDouble(14, p.getRegular_daily_interest());
//			pstmt.setDouble(15, p.getRegular_deposit_commission());
//			pstmt.setDouble(16, p.getRegular_deposit_rate());
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p.setProp_key(rs.getString(1));
				p.setProp_value(rs.getString(2));
//				p.setProp_value(rs.getString(3));
//				p.setProp_value(rs.getString(4));
//				p.setProp_value(rs.getString(5));
//				p.setProp_value(rs.getString(6));
//				p.setProp_value(rs.getString(7));
//				p.setProp_value(rs.getString(8));
//				p.setProp_value(rs.getString(9));
//				p.setProp_value(rs.getString(10));
//				p.setProp_value(rs.getString(11));
//				p.setProp_value(rs.getString(12));
//				p.setProp_value(rs.getString(13));
//				p.setProp_value(rs.getString(14));
//				p.setProp_value(rs.getString(15));
//				p.setProp_value(rs.getString(16));
				//System.out.println( "FROM PROPERTISdbM  :>>>>"+p);
				return p;
			} else {

				System.err.println("No Properties founed");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
/** End of class **/

// Properties p1 = new Properties("admin_password", "admin_username", 4, 5, 6,7,
// 8, 9,1,2,3, 4, 5, 6, 7, 8);
// p1.setAdmin_password(rs.getString(1));
// //p1.setAdmin_username(rs.getString(2));
// //p1.setCommission_rate(rs.getDouble(3));
// //p1.setGold_credit_limit(rs.getDouble(4));
// //p1.setGold_daily_interest(rs.getDouble(5));
// //p1.setGold_deposit_commission(rs.getDouble(6));
// //p1.setGold_deposit_rate(rs.getDouble(7));
// //p1.setPlatinum_credit_limit(rs.getDouble(8));
// //p1.setPlatinum_daily_interest(rs.getDouble(9));
// //p1.setPlatinum_daily_interest(rs.getDouble(10));
// //p1.setPlatinum_deposit_rate(rs.getDouble(11));
// //p1.setPre_open_fee(rs.getDouble(12));
// //p1.setRegular_credit_limit(rs.getDouble(13));
// //p1.setRegular_daily_interest(rs.getDouble(14));
// //p1.setRegular_deposit_commission(rs.getDouble(15));
// //p1.setRegular_deposit_rate(rs.getDouble(16));
// System.out.println(p1);
