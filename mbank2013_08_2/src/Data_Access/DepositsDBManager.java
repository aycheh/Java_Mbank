package Data_Access;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Core_System.Client;
import Core_System.Deposit;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DepositsDBManager implements DepositsManager {
	private static DepositsDBManager instance;

	private DepositsDBManager() {

	}

	public static DepositsDBManager getInstance() {
		if (instance == null) {
			instance = new DepositsDBManager();
		}
		return instance;
	}

	
	/** insert into Deposit table - It works with Auto RETURN_GENERATED_KEYS */
	@Override
	public void createNewDeposit(Connection con, Deposit d) {
		System.out.println("\nfrom the bigning >>> depositDBmanager : >>>>> " + d);
		try {

			//int key = (int) -1L;
			String sql = "insert into deposit value (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, (int) d.getDeposit_id());
			pstmt.setInt(2, (int) d.getClient_id());
			pstmt.setDouble(3, (int) d.getBalance());
			pstmt.setString(4, d.getType().name());
			pstmt.setDouble(5, d.getEstimated_balance());
			pstmt.setString(6, (String) d.getOpening_date());
			pstmt.setString(7, (String) d.getClosing_date());
			pstmt.setString(7, d.getClosing_date());
			ResultSet rs = pstmt.getGeneratedKeys();
				pstmt.executeUpdate();
				rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean updateDeposit(Connection con, Deposit d) {

		try {
			PreparedStatement pstmt = con
					.prepareStatement("update deposit set type=?, estimated_balance =?, opning_date = ?, closing_date = ?, balance= ? where deposit_id = ?");
			pstmt.setString(1, d.getType().name());
			pstmt.setDouble(2, d.getEstimated_balance());
			pstmt.setString(3, (String) d.getOpening_date());
			//pstmt.setDate(4, (Date) d.getClosing_date());
			pstmt.setString(4, d.getClosing_date());
			pstmt.setDouble(5, d.getBalance());
			pstmt.setInt(6, d.getDeposit_id());
			pstmt.executeUpdate();
			System.out.println("updating Deposit");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	
	
	@Override
	public Deposit getDeposit(Connection con, Deposit d) {
		// TODO Auto-generated method stub
		Deposit depositToReturn = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from deposit where deposit_id = ?");
			pstmt.setInt(1, (int) d.getDeposit_id());
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				depositToReturn = new Deposit(rs.getInt(1));
				depositToReturn.setDeposit_id(rs.getInt(1));
				depositToReturn.setClient_id(rs.getInt(2));
				depositToReturn.setBalance(rs.getDouble(3));
				//TODO fix returning value of ENUM for Type
			    depositToReturn.setType(Type.valueOf(rs.getString(4)));
				depositToReturn.setEstimated_balance(rs.getDouble(5));
				depositToReturn.setOpening_date((String) rs.getString(6));
				depositToReturn.setClosing_date(rs.getString(7));
			}} catch (SQLException e) {
				System.out.println("No Deposit found");
			e.printStackTrace();
		}
		return depositToReturn;	
	}
	
	

	@Override
	public List<Deposit> getAllDiposits(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
	    String query =
	        "select deposit_id, client_id, balance, type, estimated_balance,opning_date,closing_date "  + "from "  + " deposit";
	    List<Deposit> deposits = new ArrayList<Deposit>();
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            int deposit_id = rs.getInt("deposit_id");
	            int client_id = rs.getInt("client_id");
	            Double balance = rs.getDouble("balance");
	            Type type = Type.valueOf(rs.getString("type"));
	            Double estimated_balance = rs.getDouble("estimated_balance");
	            String opning_date = rs.getString("opning_date");
	            String closing_date = rs.getString("closing_date");
	    
//	            System.out.println("\n"+deposit_id + "\t" + client_id +
//	                               "\t" + balance + "\t" + type +
//	                               "\t" + estimated_balance + "\t" + opning_date + "\t" + closing_date);
	            deposits.add(new Deposit(deposit_id,client_id,balance,type,estimated_balance.longValue(),opning_date,closing_date));
	            //deposits.add(new Deposit(deposit_id, client_id, balance,type, estimated_balance.longValue(),opning_date, closing_date  ));
	        }  
	    } catch (SQLException e ) {
	    	System.out.println(query);
	    }
		return deposits;
	}

	@Override
	public List<Deposit> getAllClientDeposits(Connection con, int client_id) {
		// TODO Auto-generated method stub
	    String query =
	        "select * from deposit where client_id = ?";
		
	    List<Deposit> deposits = new ArrayList<Deposit>();
	    try {
	    	PreparedStatement pstmt = con.prepareStatement(query);
	    	pstmt.setInt(1, client_id );
	    	ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int deposit_id = rs.getInt("deposit_id");
	            int client_id1 = rs.getInt("client_id");
	            Double balance = rs.getDouble("balance");
	            Type type = Type.valueOf(rs.getString("type"));
	            Double estimated_balance = rs.getDouble("estimated_balance");
	            String opning_date = rs.getString("opning_date");
	            String closing_date = rs.getString("closing_date");
	    
//	            System.out.println("\n"+deposit_id + "\t" + client_id +
//	                               "\t" + balance + "\t" + type +
//	                               "\t" + estimated_balance + "\t" + opning_date + "\t" + closing_date);           
	            deposits.add(new Deposit(deposit_id, client_id1, balance,type, estimated_balance.longValue(),opning_date, closing_date  ));
	        }  
	    } catch (SQLException e ) {
	    	System.out.println(query);
	    }
		return deposits;
	}

	@Override
	public Deposit getDepositById(Connection con, int deposit_id) {
		Deposit depositToReturn = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from deposit where deposit_id = ?");
			pstmt.setInt(1,  deposit_id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				depositToReturn = new Deposit(rs.getInt(1));
				depositToReturn.setDeposit_id(rs.getInt(1));
				depositToReturn.setClient_id(rs.getInt(2));
				depositToReturn.setBalance(rs.getDouble(3));
				depositToReturn.setType(Type.valueOf(rs.getString(4)));
				depositToReturn.setEstimated_balance(rs.getDouble(5));
				depositToReturn.setOpening_date(rs.getString(6));
				//depositToReturn.setClosing_date((String)rs.getString(7));
				depositToReturn.setClosing_date(rs.getString(7));
			}} catch (SQLException e) {
				System.out.println("No Deposit found");
			e.printStackTrace();
		}
		return depositToReturn;

	}
		


}/** End of class DepositsDBManager **/
