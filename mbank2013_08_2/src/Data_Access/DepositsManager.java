package Data_Access;

import java.sql.Connection;
import java.util.List;

import Core_System.Account;
import Core_System.Client;
import Core_System.Deposit;

public interface DepositsManager {

	/** create New Deposit **/
	public void createNewDeposit(Connection con, Deposit d);

	/** Updating Deposit details */
	public boolean updateDeposit(Connection con, Deposit d);

	public Deposit getDeposit(Connection con, Deposit d);

	/** get all deposits using client_id **/
	public List<Deposit> getAllDiposits(Connection con);
	
	public List<Deposit> getAllClientDeposits(Connection con, int client_id);

}
