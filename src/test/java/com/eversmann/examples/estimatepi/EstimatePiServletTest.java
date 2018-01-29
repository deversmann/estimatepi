package com.eversmann.examples.estimatepi;

import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EstimatePiServletTest {
	
	@Mock
	HttpServletRequest req;
	
	@Mock
	HttpServletResponse res;
	
	StringWriter stringWriter;
	
	@Before 
	public void initMocks() throws Exception {
        MockitoAnnotations.initMocks(this);
		when(req.getParameter(anyString())).thenReturn("1000000");
		stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		when(res.getWriter()).thenReturn(printWriter);
	}
	
	@Test
	public void testDoGet() throws Exception {
		
		EstimatePiServlet servlet = new EstimatePiServlet();
		servlet.doGet(req, res);
		
		verify(req, times(2)).getParameter(anyString());
		
		String response = stringWriter.toString();
		assert(response.contains("<html>"));
	}

	@Test
	public void testDoPost() throws Exception {
		
		EstimatePiServlet servlet = new EstimatePiServlet();
		servlet.doPost(req, res);
		
		verify(req, times(2)).getParameter(anyString());
		
		String response = stringWriter.toString();
		assert(response.contains("<html>"));
	}
}
