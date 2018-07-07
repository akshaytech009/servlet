package daoOperation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.TreeSet;

import connection.ConnectionFactory;
import connection.ConnectionI;
import entityPojo_customer.Customer;


public class InsertToDb implements InsertDao {
	Customer customer;
	Connection conn = null;
	ConnectionI c = null;
	PreparedStatement ps = null;
	int rowsAffected = 0;
	
	//creating connection

	public Connection connection(String server) {
		c = ConnectionFactory.factoryIntial(server);
		conn = c.myConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return conn;
	}

	//Condition check rejection level
	
	
	// fetching data to check uniqueness
	
	public TreeSet<String> fetch_customer_code(String server)	
	{
		TreeSet<String> ts=new TreeSet<String>();
		
		try 
		{
			Connection conn=connection(server);
			Statement stmt=null;
			ResultSet rs=null;
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select customer_code from acustomer_master");
			
			while(rs.next())
			{
				String code=rs.getString(1);
				
				ts.add(code);
			}
		
	}
		catch(Exception e)
		{}
		return ts;
	}

	//-----------------------------------------------------------------------
	//Inserting to database.
	public int inputbd(String server, Customer customer, Connection conn) {
		try {

			ps = conn.prepareStatement("insert into acustomer_master values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, customer.getCustomer_id());
			ps.setString(2, customer.getCustomer_code());
			ps.setString(3, customer.getCustomer_name());
			ps.setString(4, customer.getCustomer_address1());
			ps.setString(5, customer.getCustomer_address2());
			ps.setInt(6, customer.getCustomer_pinCode());
			ps.setString(7, customer.getEmail_address());
			ps.setString(8, customer.getContact_number());
			ps.setString(9, customer.getPrimaryConatctPerson());
			ps.setString(10, customer.getRecord_status());
			ps.setString(11, customer.getActive_inactiveFlag());
			ps.setString(12, customer.getCreate_date());
			ps.setString(13, customer.getCreated_by());
			ps.setString(14, customer.getModified_date());
			ps.setString(15, customer.getModified_by());
			ps.setString(16, customer.getAuthorized_date());
			ps.setString(17, customer.getAuthorized_by());

			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERROR OCCURED");
		}

		return rowsAffected;
	}
	//-----------------------------------------------------------------------------

}
