package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketBookingInformation
 */
@WebServlet("/TicketBookingInfo")
public class TicketBookingInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel ='stylesheet' href='player.css'>");
		out.println("/head");
		out.println("<body>");
		ArrayList<String> list = (ArrayList<String>)request.getAttribute("error");
		if(list!=null){
			Iterator<String> itr = list.iterator();
			out.println("<ul>");
			
			while(itr.hasNext()) {
				out.println("<li>"+itr.next()+"</li>");
			}
				out.println("</ul>");
			}
		out.println("<h2><marquee><label class='ise'>Book Ticket Here</marquee><h2>");
		out.println("<center>");
		out.println("<form action = 'TicketBookingCont' method = 'post'>");
		out.println("<input type='text' name ='name' placeholder='Name' ><br><br>");
		out.println("<input type = 'text' name ='numberofseats' placeholder='No.of Seats Required' ><br><br>");
		out.println("<input type='submit' name ='Submit' id='bharath'>");
		out.println("</center></form></body></html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
