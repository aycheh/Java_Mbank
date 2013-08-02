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
		p = PropertiesDBManager.getInstance().selectPropertiesValues(
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
				conn.getConnectionFromPool(), cl);
		ClientsDBManager.getInstance().updateclients(
				conn.getConnectionFromPool(), cl);
		
	}

	public Client removeClient(int client_id) throws MbankException {
		// TODO Validate this method,what allowed when Remove client
		Client cl = new Client(client_id);
		ConnectionPoolManager conn = new ConnectionPoolManager();
		client = ClientsDBManager.getInstance().selectClient(
				conn.getConnectionFromPool(), cl);
		if (client != null) {
			ClientsDBManager.getInstance().deleteClient(
					conn.getConnectionFromPool(), cl);
			System.out.println("\nclient to remove   " + client);
			return client;
		} else {
			throw new MbankException("Client not found ");
		}

	}

	public Account removeAccount(int account_id) throws MbankException {
		// TODO Validate this method,what allowed when Remove account
		Account ac = new Account(account_id);
		ConnectionPoolManager conn = new ConnectionPoolManager();
		account = AccountsDBManager.getInstance().getAccount(conn.getConnectionFromPool(), ac);
		if (account != null) {
			AccountsDBManager.getInstance().deleteAccount(
					conn.getConnectionFromPool(), ac);
			System.out.println("\nAccount to remove " + account);
			return account;
		} else {
			throw new MbankException("\nno Account found");
		}

	}

	public Client viewClientDetails(int client_id) throws MbankException {
		// TODO view Client Details
		Client cl = new Client(client_id);
		ConnectionPoolManager conn = new ConnectionPoolManager();
		client = ClientsDBManager.getInstance().selectClient(
				conn.getConnectionFromPool(), cl);
		if (client != null) {
			System.out.println("\nfrom view client : " + client);
			return client;
		} else {

			throw new MbankException("\nNo Client found");
		}
	}

	/**View all clients details**/
	public Client viewAllClientsDetails() {
//		// TODO View all clients details
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
		// TODO 
		List<Account> accounts = new ArrayList<Account>();
		ConnectionPoolManager con = new ConnectionPoolManager();
		accounts = AccountsDBManager.getInstance().getAllAccounts(con.getConnectionFromPool());
		
		for (Account a : accounts) {
			System.out.println(a);
		}
		return accounts;
	}
	

	public Deposit viewDeposit(int deposit_id) {
		// TODO View client deposits
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

	
	
	public List<Client> ViewClientActivities(int Client_id) {
		// TODO View all activities
		// TODO Fix This and get client activities using client_id !!!!!
		ConnectionPoolManager con = new ConnectionPoolManager();
		List<Client> clients = new ArrayList<Client>(Client_id);
		ActivitysDBManager.getInstance().getClientActivities(con.getConnectionFromPool(),Client_id);
		for (Client c : clients){
			
			System.out.println(c);
		}
		return clients;
	}
	
	

	public void updateSystemProperty() {

	}

	public Properties viewSystemproperty() {
		return null;
	}

}
