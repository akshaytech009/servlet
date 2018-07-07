package controller;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.TreeSet;

import daoOperation.InsertDao;
import daoOperation.InsertToDb;
import entityPojo_customer.Customer;

import validation.ValidateMethods;
import validation.ValidationI;

public class ServiceClass
{
	ValidationI vm = new ValidateMethods();
	
	InsertDao dao = new InsertToDb();
	
	boolean code,name,pinCode,record,flag,email,address1;
	int c=0;
	
	
	boolean check(Customer customer,TreeSet<String> set)
	{	
		boolean conditionCheck=false;
		code = vm.validCustomerCode(customer, set);
		set.add(customer.getCustomer_code());
		name = vm.validCustomerName(customer);
		  pinCode = vm.validPinCode(customer);
		record = vm.validRecordStatus(customer);
		flag = vm.validFlag(customer);
		 email = vm.validEmail(customer);
		  address1=vm.validadress(customer);
		 if (code && name && record && pinCode && flag && email && address1) 
		{
			conditionCheck=true;
		}
		return conditionCheck;
		
	}
	
public int recordLevel(String server,  Customer customer) throws IOException {
		
	        Connection conn = dao.connection(server);
	     

			int rowsAffected = dao.inputbd(server, customer, conn);

			if (rowsAffected > 0){
				System.out.println("done");

			try {
				conn.commit();
				} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	return rowsAffected;		
}

public void fileLevel(String server,Customer customer,int length)
{
	InsertDao dao = new InsertToDb();
	
	Connection conn = dao.connection(server);
	  dao.inputbd(server, customer, conn);
	c=c+1;
	if(length==c)
	{
		try {
			conn.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	}

public void writeErrorFile(FileWriter bw,Customer customer)
	{
	String newLine = System.getProperty("line.separator");
	try {
		bw.append(newLine+customer.getCustomer_code()+"~"+customer.getCustomer_name()+"~"+customer.getCustomer_address1()+"~"
				+customer.getCustomer_address2()+"~"+customer.getCustomer_pinCode()+"~"+customer.getEmail_address()+"~"
				+customer.getContact_number()+"~"+customer.getPrimaryConatctPerson()+"~"+customer.getRecord_status()
				+"~"+customer.getActive_inactiveFlag()+"~"+customer.getCreated_by()+"~"+customer.getCreate_date()
				+"~"+customer.getAuthorized_by()+"~"+customer.getAuthorized_date()+"~"+customer.getModified_by()
				+"~"+customer.getModified_date()+newLine);
		if(code==false)
		{
		bw.append("Error in code"+newLine);
		
		bw.flush();
		}
		if(name==false)
		{
			bw.append("Error in name"+newLine);
			bw.flush();
		}
		if(pinCode==false)
		{
			
			bw.append("Error in pincode"+newLine);
		
			bw.flush();
		}
		if(record==false)
		{
			
			bw.append("Error in record"+newLine);
		
			bw.flush();
		}
		if(flag==false)
		{
			
			bw.append("Error in flag value"+newLine);
			
			bw.flush();
		}
		if(email==false)
		{
		
			bw.append("Error in email format"+newLine);
			
			bw.flush();
		}
		if(address1==false)
		{
			
			bw.append("Error in address 1"+newLine);
			
			bw.flush();
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	}



