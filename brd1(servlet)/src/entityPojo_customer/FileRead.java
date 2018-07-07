package entityPojo_customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import daoOperation.InsertDao;
import daoOperation.InsertToDb;

public class FileRead
{
	//Customer customer=new Customer();
	static public int noOfrows=0;
	int count=0;
	ArrayList <Customer> customerlist=new ArrayList<Customer>();
	public ArrayList<Customer> read(String location,String fileName,String fileExtention)
	{
		String str;

		try {
			//file writer and reader object
			
			FileReader fr = new FileReader(location + ":/" + fileName + "." + fileExtention);
			BufferedReader br = new BufferedReader(fr);
			//reading data from file

			while ((str = br.readLine()) != null) {
				String st[] = new String[20];
				Customer customer=new Customer();
				noOfrows=+1;
				st = str.split("~");
				try {
					customer.setCustomer_id(count);
					count = count + 1;
					customer.setCustomer_code(st[0]);
					customer.setCustomer_name(st[1]);
					customer.setCustomer_address1(st[2]);
					customer.setCustomer_address2(st[3]);
					customer.setCustomer_pinCode(Integer.parseInt(st[4]));
					customer.setEmail_address(st[5]);
					customer.setContact_number(st[6]);
					customer.setPrimaryConatctPerson(st[7]);
					customer.setRecord_status(st[8]);
					customer.setActive_inactiveFlag(st[9]);
					customer.setCreate_date(st[10]);
					customer.setCreated_by(st[11]);
					customer.setModified_date(st[12]);
					customer.setModified_by(st[13]);
					customer.setAuthorized_date(st[14]);
					customer.setAuthorized_by(st[15]);
					
				}

				catch (ArrayIndexOutOfBoundsException e) {}
				finally
				{
					customerlist.add(customer);
				}
			}

		} catch (Exception e) {
			System.out.println("file not found");
			
		}
		
		return customerlist;
	}
}
