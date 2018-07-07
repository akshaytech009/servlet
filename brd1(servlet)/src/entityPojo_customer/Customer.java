package entityPojo_customer;



public class Customer extends Person 
{
	private int customer_id;
	private String customer_code;
	private String primaryConatctPerson;
	private String record_status;
	private String active_inactiveFlag;
	private String create_date;
	private String created_by;
	private String modified_date;
	private String modified_by;
	private String authorized_date;
	private String authorized_by;
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	
	public String getPrimaryConatctPerson() {
		return primaryConatctPerson;
	}
	public void setPrimaryConatctPerson(String primaryConatctPerson) {
		this.primaryConatctPerson = primaryConatctPerson;
	}
	public String getRecord_status() {
		return record_status;
	}
	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}
	public String getActive_inactiveFlag() {
		return active_inactiveFlag;
	}
	public void setActive_inactiveFlag(String active_inactiveFlag) {
		this.active_inactiveFlag = active_inactiveFlag;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public String getAuthorized_date() {
		return authorized_date;
	}
	public void setAuthorized_date(String authorized_date) {
		this.authorized_date = authorized_date;
	}
	public String getAuthorized_by() {
		return authorized_by;
	}
	public void setAuthorized_by(String authorized_by) {
		this.authorized_by = authorized_by;
	}
	
	
	
}
