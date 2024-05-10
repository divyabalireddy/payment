package com.sat.tmf.servlet;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentwebappDAO {
	public void insert(user u)
	{
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				 
				 Connection  con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bannuuu","root","root");
				 Statement stmt = con.createStatement();
				String query = "insert into user_info(UserId,FirstName,LastName,PhoneNo,DateofBirth,Address,Password,CurrWalletBal)values('"+u.UserId+"','"+u.FirstName+"','"+u.PhoneNumber+"','"+u.LastName+"','"+u.getDateofBirth()+"','"+u.Address+"','"+u.Password+"','"+u.CurrWalletBal+"')";
				System.out.println(query);
				stmt.executeUpdate(query);
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	public boolean validlogin(String phno,String password)
	{
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				 
				 Connection  con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bannuuu","root","root");
				 Statement stmt = con.createStatement();
				String query = "select phone_number,user_password from user_info";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					if(rs.getString("phonenumber").equals(phno)&& rs.getString("password").equals(password))
					{
						return true;
					}
				}
				System.out.println(query);
				
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		    return false;
	}
	public List<Bankaccount>getBADetailsByuserID(int userId){
		List<Bankaccount> Ba= new ArrayList<Bankaccount>();
		
		return Ba;
		
		
		
	}
	public user getUserByUserPhNo(String phno) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isUserExistsWithPhoneNo(String phoneNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
