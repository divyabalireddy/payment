package com.sat.tmf.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Dashboardservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Dashboardservlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bankacctno=request.getParameter("bankacctno");
		String bankname=request.getParameter("bankname");
		String bankacttypeID=request.getParameter("bankacttypeID");
		String bankIFSCcode=request.getParameter("bankIFSCcode");
		String BankAcctPin=request.getParameter("BankAcctPin");
		String UserId=request.getParameter("UserId");
		String CurrBankAcctBalance =request.getParameter("CurrBankAcctBalance ");
		System.out.println("done");
		Bankaccount ba= new Bankaccount();
		ba.setBankacctno(bankacctno); 
		ba.setBankname(bankname);
		ba.setBankacttypeID(bankacttypeID);
		ba.setBankIFSCcode(bankIFSCcode);
		ba.setBankAcctPin(BankAcctPin);
		ba.setUserId(UserId);
		ba.setCurrBankAcctBalance(CurrBankAcctBalance);
		PaymentwebappDAO pd=new PaymentwebappDAO();
		//pd.insert(ba);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
