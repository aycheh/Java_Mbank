package Core_System;

public class Admin {
    private	String prop_key,  prop_value;
    
	public Admin(String admin_prop_key, String admin_prop_value) {
		this.prop_key = admin_prop_key;
		this.prop_value =  admin_prop_value;
	}

	public String getProp_key() {
		return prop_key;
	}

	public void setProp_key(String prop_key) {
		this.prop_key = prop_key;
	}

	public String getProp_value() {
		return prop_value;
	}

	public void setProp_value(String prop_value) {
		this.prop_value = prop_value;
	}
  
	
	
}
