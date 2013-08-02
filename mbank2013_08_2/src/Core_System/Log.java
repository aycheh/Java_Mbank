package Core_System;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	
	private long timestamp;
	private int clientId;
	private String description;
	private float amount;
	
	
	public Log(long timestamp, int clientId, String description, float amount) {
		super();
		this.timestamp = timestamp;
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
	}

	public String getData() {
		return toString();
		// ELDAR my tag: Window > Preferences > Java > Compiler > Task Tags
	}

	@Override
	public String toString() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
		String formatedDate = df.format(new Date(this.timestamp));

		return "Log [timestamp=" + formatedDate + ", clientId=" + clientId
				+ ", description=" + description + ", amount=" + amount + "]";
	}

}
