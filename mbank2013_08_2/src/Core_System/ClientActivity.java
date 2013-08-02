package Core_System;

//import java.sql.Connection;
//import java.util.Date;
//import java.sql.Date;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Data_Access.AccountsDBManager;
//import Data_Access.AccountsManager;
import Data_Access.ActivitysDBManager;
//import Data_Access.ClientSManager;
import Data_Access.ClientsDBManager;
import Data_Access.ConnectionPoolManager;
import Data_Access.DepositsDBManager;

//import Data_Access.PropertiesDBManager;

public class ClientActivity {
	private int id;
	private Client client;
	private Account account;
	protected ConnectionPoolManager conn;

	public ClientActivity(Client client) {
		this.client = client;

	}
	
	/** View client details **/
	public Client getClientDetails(Client cl) {
		//TODO validate if the client exist if not throw Mbank exception 
		ConnectionPoolManager connn = new ConnectionPoolManager();
		cl = ClientsDBManager.getInstance().selectClient(
				connn.getConnectionFromPool(), cl);
		System.out.println("your client details is , getClientDetails:   " + cl);
		return client;
	}

	/**view Account Details**/
	public Account viewAccountDetails(Account account)  throws MbankException {	 
		ConnectionPoolManager connn = new ConnectionPoolManager();
		client = ClientsDBManager.getInstance().selectClient(
				connn.getConnectionFromPool(), client);
		account = AccountsDBManager.getInstance().getAccount(
				connn.getConnectionFromPool(), account);
		if (account.getClient_id() == client.getClient_id()) {
System.out.println("\n your account deails is : >>> " + account);
			return account;
		} else {
		}
		throw new MbankException("  No account Found  :(");
	}

	/**update Client Details**/
	public void updateClientDetails(Client cl) {
		ConnectionPoolManager connn = new ConnectionPoolManager();
		ClientsDBManager.getInstance().updateclients(
				connn.getConnectionFromPool(), cl);
		System.out.println("\n your Client Details is updated  :" + cl);
	}

	/**withdraw from account**/
	public void withdraw(Account account, double amount) throws MbankException {
		ConnectionPoolManager con = new ConnectionPoolManager();
		account = AccountsDBManager.getInstance().getAccount(
				con.getConnectionFromPool(), account);
		if (amount <= 0) {
			throw new MbankException("illegal amount: " + amount);
		}
		if (account.getBalance() - amount > account.getCredit_limit()) {
			account.setBalance(account.getBalance() - amount);
			AccountsDBManager.getInstance().updateAccount(
					con.getConnectionFromPool(), account);
		} else {
			throw new MbankException("you don't have sufficient credit");
		}
	}

	/**createNewDeposit in to Deposit Table**/
	/***** @throws MbankException**/
	public void createNewDeposit(Deposit deposit, double amnout)
			throws MbankException {
		ConnectionPoolManager connn = new ConnectionPoolManager();
		client = ClientsDBManager.getInstance().selectClient(
				connn.getConnectionFromPool(), client);

		deposit.setClient_id(client.getClient_id());
		deposit.setType(client.getType());
		if (amnout <= 0) {
			throw new MbankException("illegal amount: " + amnout);
		}
		DepositsDBManager.getInstance().createNewDeposit(
				connn.getConnectionFromPool(), deposit);
		// TODO close the client Deposits when the closing date is arrive.
		// TODO Calculate the commission and the Interest FOR the deposits
	}

	/** deposit depositInToAccount balance **/
	public void depositInToAccount(Account account, double amnout)
			throws MbankException {
		ConnectionPoolManager con = new ConnectionPoolManager();
		account = AccountsDBManager.getInstance().getAccount(
				con.getConnectionFromPool(), account);
		if (amnout <= 0) {
			throw new MbankException("illegal amount: " + amnout);
		}
		account.setBalance(account.getBalance() + amnout);
		AccountsDBManager.getInstance().updateAccount(
				con.getConnectionFromPool(), account);
	}
	
	/** View client deposits**/
		// TODO View client deposits, validation ... 
		public List<Deposit> viewAllDiposits(){
			List<Deposit> deposits = new ArrayList<Deposit>();
			ConnectionPoolManager con = new ConnectionPoolManager();
			deposits = DepositsDBManager.getInstance().getAllDiposits(con.getConnectionFromPool());
			for (Deposit d : deposits){
			System.out.println(d);	
			}
		return null;
	}
	
	/**close Deposit it should be automatic**/
	public void closeDeposit() {
		// TODO closeDeposit it should be automatic
	}

	/**pre Open Deposit**/
	public void preOpenDeposit() {
		// TODO "Money is transferred after charging a commission"
	}


	
	public double getClientBalance() {
		// TODO Auto-generated method stub
		return this.account.getBalance();
	}
}
