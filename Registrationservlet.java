package com.sat.tmf.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaymentwebappDAO pd=new PaymentwebappDAO();
       
    
    public Registrationservlet() {
        super();
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String userID=request.getParameter("UserId");
		String FirstName=request.getParameter("FirstName");
		String LastName=request.getParameter("LastName");
		String PhoneNo=request.getParameter("PhoneNo");
		String DateOfBirth=request.getParameter("DateOfBirth");
		String Address=request.getParameter("Address");
		String PassWord=request.getParameter("PassWord"); 
		String CurrWalletBal=request.getParameter("CurrWalletBal");
		if(pd.isUserExistsWithPhoneNo(PhoneNo)) {
			response.setContentType("text/html");  
			response.getWriter().write("User Account Exists with Phone Number:"+PhoneNo+".Please try with another Phone Numeber");
			RequestDispatcher rd =  request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);
			System.out.println("Done");
		}
		else {
		
		user u=new user();
		u.setFirstName(FirstName);
		u.setLastName(LastName);
		u.setPhoneNumber(PhoneNo);
		u.setDateofBirth(DateOfBirth);
		u.setAddress(Address);
		u.setPassword(PassWord);
		u.setCurrWalletBal(CurrWalletBal);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date dateOfBirth;
		try {
			dateOfBirth = df.parse(DateOfBirth);
			user.setDob(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PaymentwebappDAO pd=new PaymentwebappDAO();
		pd.insert(u);

	}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
