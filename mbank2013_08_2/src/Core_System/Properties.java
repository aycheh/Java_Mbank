package Core_System;

public class Properties {

	private String prop_key;
	private String prop_value;
//	private double commission_rate;
//	private double gold_daily_interest;
//	private double gold_credit_limit;
//	private double gold_deposit_commission;
//	private double gold_deposit_rate;
//	private double platinum_daily_interest;
//	private double platinum_credit_limit;
//	private double platinum_deposit_commission;
//	private double platinum_deposit_rate;
//	private double pre_open_fee;
//	private double regular_credit_limit;
//	private double regular_daily_interest;
//	private double regular_deposit_commission;
//	private double regular_deposit_rate;
	
	
//	public Properties(String prop_key, String prop_value,
//			double commission_rate, double gold_daily_interest,
//			double gold_credit_limit, double gold_deposit_commission,
//			double gold_deposit_rate, double platinum_daily_interest,
//			double platinum_credit_limit, double platinum_deposit_commission,
//			double platinum_deposit_rate, double pre_open_fee,
//			double regular_credit_limit, double regular_daily_interest,
//			double regular_deposit_commission, double regular_deposit_rate) {
//		super();
//		this.prop_key = prop_key;
//		this.prop_value = prop_value;
//		this.commission_rate = commission_rate;
//		this.gold_daily_interest = gold_daily_interest;
//		this.gold_credit_limit = gold_credit_limit;
//		this.gold_deposit_commission = gold_deposit_commission;
//		this.gold_deposit_rate = gold_deposit_rate;
//		this.platinum_daily_interest = platinum_daily_interest;
//		this.platinum_credit_limit = platinum_credit_limit;
//		this.platinum_deposit_commission = platinum_deposit_commission;
//		this.platinum_deposit_rate = platinum_deposit_rate;
//		this.pre_open_fee = pre_open_fee;
//		this.regular_credit_limit = regular_credit_limit;
//		this.regular_daily_interest = regular_daily_interest;
//		this.regular_deposit_commission = regular_deposit_commission;
//		this.regular_deposit_rate = regular_deposit_rate;
//	}

/**********/
	
	public Properties (String prop_key,String  prop_value){
		this.prop_key = prop_key;
		this.prop_value = prop_value;
	}
	
	public Properties (String prop_key){
		this.prop_key = prop_key;
		
	}
	
	public Properties(){
		
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
//
//public double getCommission_rate() {
//	return commission_rate;
//}
//
//public void setCommission_rate(double commission_rate) {
//	this.commission_rate = commission_rate;
//}
//
//public double getGold_daily_interest() {
//	return gold_daily_interest;
//}
//
//public void setGold_daily_interest(double gold_daily_interest) {
//	this.gold_daily_interest = gold_daily_interest;
//}
//
//public double getGold_credit_limit() {
//	return gold_credit_limit;
//}
//
//public void setGold_credit_limit(double gold_credit_limit) {
//	this.gold_credit_limit = gold_credit_limit;
//}
//
//public double getGold_deposit_commission() {
//	return gold_deposit_commission;
//}
//
//public void setGold_deposit_commission(double gold_deposit_commission) {
//	this.gold_deposit_commission = gold_deposit_commission;
//}
//
//public double getGold_deposit_rate() {
//	return gold_deposit_rate;
//}
//
//public void setGold_deposit_rate(double gold_deposit_rate) {
//	this.gold_deposit_rate = gold_deposit_rate;
//}
//
//public double getPlatinum_daily_interest() {
//	return platinum_daily_interest;
//}
//
//public void setPlatinum_daily_interest(double platinum_daily_interest) {
//	this.platinum_daily_interest = platinum_daily_interest;
//}
//
//public double getPlatinum_credit_limit() {
//	return platinum_credit_limit;
//}
//
//public void setPlatinum_credit_limit(double platinum_credit_limit) {
//	this.platinum_credit_limit = platinum_credit_limit;
//}
//
//public double getPlatinum_deposit_commission() {
//	return platinum_deposit_commission;
//}
//
//public void setPlatinum_deposit_commission(double platinum_deposit_commission) {
//	this.platinum_deposit_commission = platinum_deposit_commission;
//}
//
//public double getPlatinum_deposit_rate() {
//	return platinum_deposit_rate;
//}
//
//public void setPlatinum_deposit_rate(double platinum_deposit_rate) {
//	this.platinum_deposit_rate = platinum_deposit_rate;
//}
//
//public double getPre_open_fee() {
//	return pre_open_fee;
//}
//
//public void setPre_open_fee(double pre_open_fee) {
//	this.pre_open_fee = pre_open_fee;
//}
//
//public double getRegular_credit_limit() {
//	return regular_credit_limit;
//}
//
//public void setRegular_credit_limit(double regular_credit_limit) {
//	this.regular_credit_limit = regular_credit_limit;
//}
//
//public double getRegular_daily_interest() {
//	return regular_daily_interest;
//}
//
//public void setRegular_daily_interest(double regular_daily_interest) {
//	this.regular_daily_interest = regular_daily_interest;
//}
//
//public double getRegular_deposit_commission() {
//	return regular_deposit_commission;
//}
//
//public void setRegular_deposit_commission(double regular_deposit_commission) {
//	this.regular_deposit_commission = regular_deposit_commission;
//}
//
//public double getRegular_deposit_rate() {
//	return regular_deposit_rate;
//}
//
//public void setRegular_deposit_rate(double regular_deposit_rate) {
//	this.regular_deposit_rate = regular_deposit_rate;
//}
//
//
//
//
//@Override
//public String toString() {
//	return "\nProperties \n[\nprop_key=" + prop_key + ", \nprop_value=" + prop_value
//			+ ", \ncommission_rate=" + commission_rate + ", \ngold_daily_interest="
//			+ gold_daily_interest + ", \ngold_credit_limit=" + gold_credit_limit
//			+ ", \ngold_deposit_commission=" + gold_deposit_commission
//			+ ", \ngold_deposit_rate=" + gold_deposit_rate
//			+ ", \nplatinum_daily_interest=" + platinum_daily_interest
//			+ ", \nplatinum_credit_limit=" + platinum_credit_limit
//			+ ", \nplatinum_deposit_commission=" + platinum_deposit_commission
//			+ ", \nplatinum_deposit_rate=" + platinum_deposit_rate
//			+ ", \npre_open_fee=" + pre_open_fee + ", \nregular_credit_limit="
//			+ regular_credit_limit + ", \nregular_daily_interest="
//			+ regular_daily_interest + ", \nregular_deposit_commission="
//			+ regular_deposit_commission + ", \nregular_deposit_rate="
//			+ regular_deposit_rate + "\n]";
//}
//	

@Override
public String toString() {
	return "Properties [prop_key=" + prop_key + ", prop_value=" + prop_value
			+ "]";
}
	
/**********/
	
	
	
	
	
}/** end of class**/
