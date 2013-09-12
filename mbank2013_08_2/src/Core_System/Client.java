package Core_System;

import Data_Access.Type;


public class Client {
	private int client_id;
	private String client_name;
	private String password;
	private Type type;
	private String address;
	private String email;
	private String phone;
	private String comment;

	public Client(int client_id, String client_name, String password,
			Type type, String address, String email, String phone,
			String comment) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.password = password;
		this.type = type;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.comment = comment;
	}
	
////
	public Client(String client_name, String password,
			 String address, String email, String phone,
			String comment) {
		super();
		this.client_name = client_name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.comment = comment;
	}
///
	// This constructor use to create Client login 
	public Client(int client_id, String password){
		this.client_id = client_id;
		this.password = password;
	}
	
	public Client(String client_name, String password){
		this.client_name = client_name;
		this.password = password;
	}
	

	public Client(int client_id) {
		this.client_id = client_id;
	}


	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "\nClient [\nclient_id=" + client_id + ", \nclient_name="
				+ client_name + ", \npassword=" + password + ", \naddress="
				+ address + ", \nemail=" + email + ", \nphone=" + phone
				+ ", \ncomment=" + comment + "]";
	}

}
