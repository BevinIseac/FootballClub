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


@WebServlet("/AddMatchInfo")

public class AddMatchInformation extends HttpServlet {
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
		
		out.println("<h2><marquee><div class = 'ss'><label class='ise'>Add Match Info</div></marquee><h2><br><br><br><br>");
		
		out.println("<form class='bevin' action = 'AddMAtchInfoCont' method = 'post'>");
		out.println("<input type='text' name ='title' placeholder='Title'required ><br><br>");
		out.println("<input type = 'text' name ='place' placeholder='Place'required><br><br>");
		out.println("<input type ='date' name ='date' placeholder='Date'required><br><br>");
		out.println("<input type='submit' name ='Submit' id='bharath'>");
		out.println("</center></form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
