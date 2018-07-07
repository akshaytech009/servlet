package entityPojo_customer;

import java.io.Serializable;

public class Person implements Serializable
{
	private String customer_name;
	private String customer_address1;
	private String customer_address2;
	private int customer_pinCode;
	private String email_address;
	private String contact_number;
	
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address1() {
		return customer_address1;
	}
	public void setCustomer_address1(String customer_address1) {
		this.customer_address1 = customer_address1;
	}
	public String getCustomer_address2() {
		return customer_address2;
	}
	public void setCustomer_address2(String customer_address2) {
		this.customer_address2 = customer_address2;
	}
	public int getCustomer_pinCode() {
		return customer_pinCode;
	}
	public void setCustomer_pinCode(int customer_pinCode) {
		this.customer_pinCode = customer_pinCode;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	
	
}
