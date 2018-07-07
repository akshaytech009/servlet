package controller;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoOperation.InsertDao;
import daoOperation.InsertToDb;
import entityPojo_customer.Customer;
import entityPojo_customer.FileRead;



@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServiceClass sc=new ServiceClass();
		
		FileWriter fw = new FileWriter("d:/errorLogFil.txt",true);
		PrintWriter pw=response.getWriter();
		String server=request.getParameter("database");
	/*	if(server.equalsIgnoreCase("MySql")||server.equalsIgnoreCase("SqlServer"))
		{
			pw.println("					Select correct database");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		else*/
		
		String location = request.getParameter("location");
		String fileName = request.getParameter("name");
		String fileExtention = request.getParameter("extention");
		String rejection=request.getParameter("rejection");
		FileRead fr=new FileRead();
		
		InsertDao dao=new InsertToDb();
		ArrayList<Customer> customer=new ArrayList<Customer>();
		int count=0;
		
		
		if(fileExtention.equalsIgnoreCase("txt")) 
		{
			customer=fr.read(location,fileName,fileExtention);		//calling file reading class
			
			int length=customer.size();
			
			fw.append("NEW ENTRY");
			for(Customer ob:customer)
			{
			TreeSet<String> set=dao.fetch_customer_code(server);
			boolean condition=sc.check(ob,set);					//checking rejection level
			
			if(condition==true)
			{
				//count=count+2;
				if(rejection.equalsIgnoreCase("r"))
				{
					//System.out.println(server);
					sc.recordLevel(server, ob);
				}
				else 
				{
					sc.fileLevel(server, ob,length);
				}
			}
			else
			{
				sc.writeErrorFile(fw,ob);				
				count=count+1;
			}
			
			
		}//for closed
			if(count==0&&length>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("validate.html");
						rd.forward(request, response);
			}
			else if(length>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("nonValidate.jsp");
				request.setAttribute("count", count);
				rd.forward(request, response);
			}
			else
			{
				pw.println("FILE NOT FOUND");
			}
		}	
		else
		{
			
			pw.println("Enter correct file extention");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
		
		fw.close();
	
	}
}
