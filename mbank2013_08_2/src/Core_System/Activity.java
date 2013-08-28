package Core_System;


import java.util.Date;


public class Activity  {
	private int id;
	private int client_id;
	private double amount;
	private Date activity_date;
	private double commission;
	private String description;


	public Activity(int id,int client_id, double amount, Date activity_date,
			double commission, String description) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.amount = amount;
		this.activity_date = activity_date;
		this.commission = commission;
		this.description = description;
	}

	public Activity (int client_id){
		this.client_id = client_id;
	}


	
	

	public int getClient_id() {
		return client_id;
	}
	


	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getActivity_date() {
		return activity_date;
	}

	public void setActivity_date(Date activity_date) {
		this.activity_date = activity_date;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// //////////////////////////

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	////////////////////////

	@Override
	public String toString() {
		return "Activity [id=" + id + ", client_id=" + client_id + ", amount="
				+ amount + ", activity_date=" + activity_date + ", commission="
				+ commission + ", description=" + description + "]";
	}
}



	
	
	

