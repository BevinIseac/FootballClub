package com.Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TicketBookingCont")
public class TicketBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String number = request.getParameter("numberofseats").trim();
		int numberofseats=Integer.parseInt(number);
		ArrayList<String> list = new ArrayList<String>();
		if(name.length()==0) 
			list.add("Enter the name");
		if(numberofseats<1)
			list.add("Enter the number of seats required");
		if(!list.isEmpty()) {
			request.setAttribute("error", list);
			RequestDispatcher rd = request.getRequestDispatcher("TicketBookingInfo");
			rd.forward(request, response);
		}
		request.setAttribute("nm", list);	
		getServletContext().getRequestDispatcher("/Ticket.html").forward(request,response);
		}

}
