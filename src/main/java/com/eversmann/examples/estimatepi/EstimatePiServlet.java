package com.eversmann.examples.estimatepi;

import static com.eversmann.examples.estimatepi.EstimatePiUtils.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/EstimatePi")
public class EstimatePiServlet extends HttpServlet {
		
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numTrials = 0;
		int maxNumber = 0;
		double result = 0.0;
		boolean success = false;
		try {
			numTrials = Integer.parseInt(request.getParameter("numTrials"));
			maxNumber = Integer.parseInt(request.getParameter("maxNumber"));
			result = estimatePi(numTrials, maxNumber);
			success = true;
		}
		catch (Exception e) {
			success = false;
		}
		response.getWriter().append("<html><title>Estimate Pi</title><body><h2>Estimate Pi</h2><form>");
		response.getWriter().append("Number of Trials:<input name='numTrials' value='"+(success?numTrials:"")+"' /><br />");
		response.getWriter().append("Max Random Number:<input name='maxNumber' value='"+(success?maxNumber:"")+"' /><br />");
		
		response.getWriter().append("<input type='submit' /><br />");
		response.getWriter().append("Pi Estimate: " + (success?result:"") + "<br />");
		response.getWriter().append("% Error: " + (success?Math.abs((Math.PI-result)/Math.PI)*100.0+"%":"") + "<br />");
		response.getWriter().append("Served at: ").append(System.getenv("HOSTNAME"));
		response.getWriter().append("</html>");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private double estimatePi(int numTries, int maxNumber) {
		int numFoundCoprimes = 0;
		for (int i=0; i<numTries; i++) {
			if (gcd (randomWithMax(maxNumber), randomWithMax(maxNumber))==1) {
				numFoundCoprimes++;
			}
		}
		return Math.sqrt(6.0 * (double)numTries / (double)numFoundCoprimes);
	}
	
}
