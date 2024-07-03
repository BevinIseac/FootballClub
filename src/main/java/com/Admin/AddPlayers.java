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

@WebServlet("/AddPlayers")
public class AddPlayers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ArrayList<String> list = (ArrayList<String>)request.getAttribute("error");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel ='stylesheet' href='player.css'>");
		out.println("</head>");
		out.println("<body>");

		if(list!=null){
		Iterator<String> itr = list.iterator();
		out.println("<ul>");
		
		while(itr.hasNext()) {
			out.println("<li>"+itr.next()+"</li>");
		}
			out.println("</ul>");
		}
		out.println("<center>");
		out.println("<h2><marquee><label class='ise'>Add Player's Detail</marquee><h2><br><br><br><br>");
		
		out.println("<form action = 'RegisterPlayersCont' method = 'post' enctype = 'multipart/form-data'>");
		out.println("<input type='text' name ='name'placeholder='Name' ><br><br>");
		out.println("<input type = 'text' name ='age'placeholder='Age'><br><br>");
		out.println("<input type ='text' name ='district'placeholder='District '><br><br>");
		out.println("<input type = 'text' name ='position'placeholder='Position'><br><br>");
		out.println("Profile<input type = 'file' name ='profile'><br><br>");
		out.println("<input type='submit' name ='Submit'>");
		out.println("</center></form></body></html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
