package Data_Access;

import java.sql.Connection;
import java.util.List;

import Core_System.Account;
import Core_System.Client;


public interface ClientSManager {
	
	/**insert new client to DB*/
	public boolean createNewClient(Connection con, Client c);
	
	/**update client data*/
	public void updateclients(Connection con, Client c);
	
	/**Selecting query from  Client using client_id*/
	public Client selectClient(Connection con, Client c);
	

	/**delete Account from table*/
	public boolean deleteClient(Connection con, Client c);
	//public List<Account> getAllAccounts(Connection con);
	public List<Client> getAllClients(Connection con);

}
