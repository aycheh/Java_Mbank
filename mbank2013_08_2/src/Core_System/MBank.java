package Core_System;

import Core_System.Properties;
import Data_Access.ClientsDBManager;
import Data_Access.ConnectionPoolManager;
import Data_Access.PropertiesDBManager;

public class MBank {

	private double balance;
	private static MBank instance = new MBank();
	protected ConnectionPoolManager conn;

	public static MBank getInstance() {
		return instance;
	}

	private MBank() {
		conn = new ConnectionPoolManager();
		// TODO Auto-generated constructor stub
	}

	/** Client Login **/
	public ClientActivity login(int client_id, String password) {
		Client cl = new Client(client_id, password);
		cl = ClientsDBManager.getInstance().selectClient(
				conn.getConnectionFromPool(), cl.getClient_id());
		if (cl != null && client_id == (cl.getClient_id())
				&& password.equals(cl.getPassword())) {
			cl.getClient_name();
			System.out.println(" Wellcame   : " + cl.getClient_name());
			return new ClientActivity(cl);
		} else {
			System.err.println("Invalid email/password combination, try again");
			return null;
		}
	}

	/** Admin Login **/
	public AdminActivity AdminLogin(String prop_key, String prop_value) {
		Properties p = new Properties(prop_key, prop_value);
		p = PropertiesDBManager.getInstance().getPropertiesValues(
				conn.getConnectionFromPool(), p);
		if (p != null && p.getProp_key().equals(prop_key)
				&& p.getProp_value().equals(prop_value)) {
			System.out.println("\nWellcame Admin : what would you like to do? "
					+ "getProp_value() => " + p.getProp_value()
					+ " , getProp_key() => " + p.getProp_key());
			return new AdminActivity(p);
		} else {
			System.err.println("\nlogin fiald");
		}
		return null;
	}
	
	

	public double getBalance() {
		//TODO get Mbank balance
		return balance;
	}

	public void setBalance(double balance) {
		// TODO update Mbank balanceS
		this.balance = balance;
	}

}
