package Core_System;

import java.sql.Time;


public class Account {
	
	private int client_id;
	private int account_id;
	private double balance;
	private double credit_limit;
	private String comment;
	
	
	public Account(int account_id, int client_id, double balance,
			double credit_limit, String comment) {
		super();
		this.account_id = account_id;
		this.client_id = client_id;
		this.balance = balance;
		this.credit_limit = credit_limit;
		this.comment = comment;
		
		
	}
	
	public Account(double balance ,double credit_limit) {
		 this.balance = balance;
		 this.credit_limit=credit_limit;
	}
	
	 public Account(int account_id) {
		 this.account_id = account_id;
	}

	 
	 /**deposit*/
//	 public void deposit(double amount){
//		 this.balance += amount;
//		// getCommission = amount * commission_rate;
//			this.balance -= amount;
//		 System.out.println("from Class account");
//	 }

	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public int getClient_id() {
		return client_id;
	}


	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getCredit_limit() {
		return credit_limit;
	}


	public void setCredit_limit(double credit_limit) {
		this.credit_limit = credit_limit;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}




	@Override
	public String toString() {
		return "\nAccount [\naccount_id=" + account_id + ", \nclient_id=" + client_id
				+ ",\nbalance=" + balance + ", \ncredit_limit=" + credit_limit
				+ ", \ncomment=" + comment + "]";
	}
	
	
	
	
	
	
	
}


