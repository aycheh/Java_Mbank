package Core_System;

import java.util.Date;

import Data_Access.Type;

public class Deposit {
	private int deposit_id;
	private int client_id;
	private double balance;
	private Type type;
	private double estimated_balance;
	private Date opening_date;
	private String closing_date;

	public Deposit(int deposit_id, int client_id, double balance, Type type,
			long estimated_balance, Date opening_date, String closing_date) {
		super();
		this.deposit_id = deposit_id;
		this.client_id = client_id;
		this.balance = balance;
		this.type = type;
		this.estimated_balance = estimated_balance;
		this.opening_date = opening_date;
		this.closing_date = closing_date;
	}

	 public Deposit (){
	
	 }
	 
	 public Deposit (int deposit_id ){
		 this.deposit_id = deposit_id;
	 }
	 
	 
	 
	

	public int getDeposit_id() {
		return deposit_id;
	}

	public void setDeposit_id(int deposit_id) {
		this.deposit_id = deposit_id;
	}

	public long getClient_id() {
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getEstimated_balance() {
		return estimated_balance;
	}

	public void setEstimated_balance(double estimated_balance) {
		this.estimated_balance = estimated_balance;
	}

	public Date getOpening_date() {
		return opening_date;
	}

	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}

	public String getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(String closing_date) {
		this.closing_date = closing_date;
	}

	@Override
	public String toString() {
		return "\nDeposit [deposit_id=" + deposit_id + ", \nclient_id="
				+ client_id + ", \nbalance=" + balance + ", \ntype=" + type
				+ ", \nestimated_balance=" + estimated_balance
				+ ", \nopening_date=" + opening_date + ", \nclosing_date="
				+ closing_date + "]";
	}

}
