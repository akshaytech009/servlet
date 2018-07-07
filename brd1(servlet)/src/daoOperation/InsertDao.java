package daoOperation;


import java.sql.Connection;

import java.util.TreeSet;

import entityPojo_customer.Customer;

public interface InsertDao {
	
	public int inputbd(String server, Customer customer, Connection conn);
	public Connection connection(String server);
	public TreeSet<String> fetch_customer_code(String server);
}
