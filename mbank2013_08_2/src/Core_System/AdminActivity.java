package Core_System;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Data_Access.AccountsDBManager;

import Data_Access.AccountsManager;
import Data_Access.ActivitysDBManager;
import Data_Access.ActivitysManager;
import Data_Access.ClientSManager;
import Data_Access.ClientsDBManager;
import Data_Access.ConnectionPoolManager;
import Data_Access.DepositsDBManager;
import Data_Access.DepositsManager;
import Data_Access.PropertiesDBManager;
import Data_Access.PropertiesManager;
import Data_Access.Type;

public class AdminActivity {
	private int id;
	private Client client;
	private Account account;
	private PropertiesDBManager pmgr;
	protected ConnectionPoolManager conn;
	public Properties properties;

	public AdminActivity(Properties p) {
		this.properties = p;
	}

	/**
	 * @throws MbankException
	 *********************************************/

	public void addNewClient(Client cl, double amount, Properties p, Account ac)
			throws MbankException {
		ConnectionPoolManager conn = new ConnectionPoolManager();
		properties.setProp_key(p.getProp_key());
		properties.setProp_value(p.getProp_value());
		p = PropertiesDBManager.getInstance().getPropertiesValues(
				conn.getConnectionFromPool(), p);
		String str = p.getProp_value();
		int Prop_value = Integer.parseInt(str);

		int regular = 0;
		int gold = 0;
		int platinum = 0;

		if (Prop_value <= 10000) {
			regular = Prop_value;
		} else if (Prop_value <= 10001) {
			gold = Prop_value;
		} else if ((Prop_value <= 100000) || (Prop_value > 1000000)) {
			platinum = Prop_value;
		}

		if (amount <= regular) {
			cl.setType(Data_Access.Type.REGULAR);

		} else if (amount >= gold) {
			cl.setType(Data_Access.Type.GOLD);

		} else if (amount >= platinum) {
			cl.setType(Data_Access.Type.PLATINUM);

		}

		// TODO Rejection saving account if the client is not valid!!! &&
		// Rejection saving client if the account is not valid !!!
		if (ac.getBalance() > 0) {
			AccountsDBManager.getInstance().createAccount(
					conn.getConnectionFromPool(), ac);
			ClientsDBManager.getInstance().createNewClient(
					conn.getConnectionFromPool(), cl);
		} else {
			throw new MbankException("illigal amount ");
		}

	}
	/*** Update client details***/
	public void updateClientDetails(Client cl) {
		// TODO Validate this method,what allowed when updating client!!
		ConnectionPoolManager conn = new ConnectionPoolManager();
		client = ClientsDBManager.getInstance().selectClient(
				conn.getConnectionFromPool(), cl.getClient_id());
		ClientsDBManager.getInstance().updateclients(
				conn.getConnectionFromPool(), cl);
		
	}

		/**removeClient**/
	public Client removeClient(int client_id) throws MbankException {
		// TODO Validate this method,what allowed when Remove client
		Client cl = new Client(client_id);
		ConnectionPoolManager conn = new ConnectionPoolManager();
		client = ClientsDBManager.getInstance().selectClient(
				conn.getConnectionFromPool(), cl.getClient_id());
		if (client != null) {
			ClientsDBManager.getInstance().deleteClient(
					conn.getConnectionFromPool(), cl);
			System.out.println("\nclient to remove   " + client);
			return client;
		} else {
			throw new MbankException("Client not found ");
		}

	}

		/**removeAccount**/
	public Account removeAccount(int account_id) throws MbankException {
		// TODO Validate this method,what allowed when Remove account
		Account ac = new Account(account_id);
		ConnectionPoolManager conn = new ConnectionPoolManager();
		account = AccountsDBManager.getInstance().getAccount(conn.getConnectionFromPool(), ac.getAccount_id());
		if (account != null) {
			AccountsDBManager.getInstance().deleteAccount(
					conn.getConnectionFromPool(), ac);
			System.out.println("\nAccount to remove " + account);
			return account;
		} else {
			throw new MbankException("\nno Account found");
		}

	}
	
		/**view Client Details**/
	public Client viewClientDetails(int client_id) throws MbankException {

		Client cl = new Client(client_id);
		ConnectionPoolManager conn = new ConnectionPoolManager();
		client = ClientsDBManager.getInstance().selectClient(
				conn.getConnectionFromPool(), cl.getClient_id());
		if (client != null) {
			System.out.println("\nfrom view client : " + client);
			return client;
		} else {

			throw new MbankException("\nNo Client found");
		}
	}

	/**View all clients details**/
	public Client viewAllClientsDetails() {
		List<Client> clients = new ArrayList<Client>();
		ConnectionPoolManager con = new ConnectionPoolManager();
		clients = ClientsDBManager.getInstance().getAllClients(con.getConnectionFromPool());
		
		for (Client c : clients) {
			System.out.println(c);
		}
		return client;
	}

	
	/**View accounts details**/
	public List<Account> viewAllAccounts() { 
		List<Account> accounts = new ArrayList<Account>();
		ConnectionPoolManager con = new ConnectionPoolManager();
		accounts = AccountsDBManager.getInstance().getAllAccounts(con.getConnectionFromPool());
		
		for (Account a : accounts) {
			System.out.println(a);
		}
		return accounts;
	}
	
		/**View client deposits**/
	public Deposit viewDeposit(int deposit_id) {
		ConnectionPoolManager con = new ConnectionPoolManager();
		Deposit deposit = new Deposit(deposit_id);
		deposit = DepositsDBManager.getInstance().getDeposit(con.getConnectionFromPool(), deposit);
		System.out.println("\nviewDeposit()"+deposit);
		return deposit;
	}
	
	/** View all Deposits**/
	public List<Deposit> viewAllDiposits(){
		List<Deposit> deposits = new ArrayList<Deposit>();
		ConnectionPoolManager con = new ConnectionPoolManager();
		deposits = DepositsDBManager.getInstance().getAllDiposits(con.getConnectionFromPool());
		for (Deposit d : deposits){
		System.out.println(d);	
		}
		return deposits;
	}
	
	/** View all clients Deposits**/
	public List<Deposit> viewAllClientDeposits(int client_id){
		List<Deposit> deposits = new ArrayList<Deposit>();
		ConnectionPoolManager con = new ConnectionPoolManager();
		deposits = DepositsDBManager.getInstance().getAllClientDeposits(con.getConnectionFromPool(), client_id);
		for (Deposit d : deposits){
		System.out.println("\ndeposits ........"+d);	
		}
		return deposits;
	}
	
	
	
	/**View view All Activities**/
	public List<Activity> viewAllActivities() {
		ConnectionPoolManager con = new ConnectionPoolManager();
		List<Activity> activitys = new ArrayList<Activity>();
		activitys = ActivitysDBManager.getInstance().getAllClientsActivitys(con.getConnectionFromPool());
		for (Activity c : activitys){
		System.out.println(c);
		}
		return activitys;
	}

	
	
	public List<Activity> ViewClientActivities(int Client_id) throws MbankException{
		ConnectionPoolManager con = new ConnectionPoolManager();
		List<Activity> activitys = new ArrayList<Activity>(Client_id);
		activitys = ActivitysDBManager.getInstance().getClientActivities(con.getConnectionFromPool(),Client_id);
		if (activitys !=null){
		for (Activity c : activitys){
			System.out.println(c);
		}
		return activitys;
		}else {

			throw new MbankException("\nNo Client found");
		}
	}
	
	

	public void updateSystemProperty(Properties p) throws MbankException {
		if(p !=null){
		ConnectionPoolManager conn = new ConnectionPoolManager();
		Properties p1 = new Properties(p.getProp_key(),p.getProp_value());
		PropertiesDBManager.getInstance().updateSystemProperty(conn.getConnectionFromPool(),p1);
		System.out.println(p);
		}else {
			throw new MbankException("\nNo Syste mproperty found");
		}
	}

	public List<Properties> viewSystemproperty() throws MbankException {
		ConnectionPoolManager con = new ConnectionPoolManager();
		List<Properties> properties = new ArrayList<Properties>();
		properties = PropertiesDBManager.getInstance().getAllProperties(con.getConnectionFromPool());
		if (properties != null){
			for(Properties p : properties){
				System.out.println(p);
			}
			return properties;
		}else {
			throw new MbankException("\nNo Syste mproperty found");	
		}
	}

}
