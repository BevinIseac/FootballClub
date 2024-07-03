package com.Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddMAtchInfoCont")
public class AddMAtchInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title").trim();
		String place = request.getParameter("place").trim();
		String dt = request.getParameter("date").trim();
		ArrayList<String> list = new ArrayList<String>();
		
		if(title.length()==0) 
			list.add("");
		if(place.length()==0)
			list.add("");
		if(dt.length()==0)
			list.add("");
		if(!list.isEmpty()) {
			request.setAttribute("error", list);
			RequestDispatcher rd = request.getRequestDispatcher("AddMatchInfo");
			rd.forward(request, response);
		}
		Match m = new Match(title,place,dt);
		MatchDao md = new MatchDao();
		 md.Storedata(m);
		RequestDispatcher rd1 = request.getRequestDispatcher("Acknowledgement.html");
		rd1.forward(request, response);
		
		
	}


}
