package Data_Access;

import java.sql.Connection;
import java.util.List;

import Core_System.Account;

public interface AccountsManager {
	
	/**Creating new Account and insert it to DB*/
	public void createAccount(Connection con, Account a);
	
	/**Updating Account details*/
	public void updateAccount(Connection con, Account a);
	
	/**delete Account from table*/
	public boolean deleteAccount(Connection con, Account a);
	
	/**Selecting query on Accounts*/
	public Account getAccount(Connection con, Account a);
	/**get all Accounts**/
	public List<Account> getAllAccounts(Connection con);
}
