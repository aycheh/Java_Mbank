package Data_Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Core_System.Account;
import Core_System.Client;

public class AccountsDBManager implements AccountsManager {
	private static AccountsDBManager instance;

	private AccountsDBManager() {
	}

	public static AccountsDBManager getInstance() {
		if (instance == null) {
			instance = new AccountsDBManager();
		}
		return instance;
	}

	/** Insert new account to DB (It works good:) */
	@Override
	public void createAccount(Connection con, Account a) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into accounts value (?,?,?,?,?)");
			pstmt.setLong(1, a.getAccount_id());
			pstmt.setLong(2, a.getClient_id());
			pstmt.setDouble(3, a.getBalance());
			pstmt.setDouble(4, a.getCredit_limit());
			pstmt.setString(5, a.getComment());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/** update account to DB (It works good:) */

	@Override
	public void updateAccount(Connection con, Account a) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update accounts set client_id=? ,balace = ?, credit_limit = ?, comment = ? where account_id = ?");
			pstmt.setInt(1, a.getClient_id());
			pstmt.setDouble(2, a.getBalance());
			pstmt.setDouble(3, a.getCredit_limit());
			pstmt.setString(4, a.getComment());
			pstmt.setInt(5, a.getAccount_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/** delete Account from table (It works good) */
	@Override
	public boolean deleteAccount(Connection con, Account a) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("delete from accounts where account_id =?");
			pstmt.setLong(1, a.getAccount_id());
			int success = pstmt.executeUpdate();
			if (success == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	/** selecting from account table -> (It works :) */
	@Override
	public Account getAccount(Connection con, int account_id) {
		Account AccountToReturn = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from accounts where account_id =? ");
			pstmt.setInt(1, account_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				AccountToReturn = new Account(rs.getInt(1));
				AccountToReturn.setAccount_id(rs.getInt(1));
				AccountToReturn.setClient_id(rs.getInt(2));
				AccountToReturn.setBalance(rs.getDouble(3));
				AccountToReturn.setCredit_limit(rs.getDouble(4));
				AccountToReturn.setComment(rs.getString(5));
				System.out.println("AccountToReturn    : >>> "+AccountToReturn);
				return AccountToReturn;
			} else {
				System.err.println("No Account founed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	


	@Override
	public List<Account> getAllAccounts(Connection con) {
		// TODO Auto-generated method stub
		
		Statement stmt = null;
	    String query =
	        "select account_id, client_id, balace, credit_limit, comment "  + "from "  + " accounts";
	    List<Account> accounts = new ArrayList<Account>();
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            int account_id = rs.getInt("account_id");
	            int client_id = rs.getInt("client_id");
	            Double balace = rs.getDouble("balace");
	            Double credit_limit = rs.getDouble("credit_limit");
	            String comment = rs.getString("comment");
	            
//	            System.out.println(account_id + "\t" + client_id +
//	                               "\t" + balace + "\t" + credit_limit +
//	                               "\t" + comment);
	 

	            accounts.add(new Account(account_id, client_id, balace, credit_limit, comment));
	        }
	       
	    } catch (SQLException e ) {
	    	System.out.println(query);
	    
	    }
 
		return accounts;
	}

	@Override
	public Account getAccountByClientId(Connection con, int client_id) {
		System.out.println("AccountToReturnByClientId    111111111111: >>> ");
		Account AccountToReturnByClientId = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from accounts where client_id=? ");
			pstmt.setInt(1, client_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				AccountToReturnByClientId = new Account(rs.getInt(1));
				AccountToReturnByClientId.setAccount_id(rs.getInt(1));
				AccountToReturnByClientId.setClient_id(rs.getInt(2));
				AccountToReturnByClientId.setBalance(rs.getDouble(3));
				AccountToReturnByClientId.setCredit_limit(rs.getDouble(4));
				AccountToReturnByClientId.setComment(rs.getString(5));
				
				System.out.println("AccountToReturnByClientId    : >>> "+AccountToReturnByClientId);
				return AccountToReturnByClientId;
			} else {
				System.err.println("No client_id founed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbb by acoient_id :" + AccountToReturnByClientId);
		return null; 
		
	}
	
	
	

}
