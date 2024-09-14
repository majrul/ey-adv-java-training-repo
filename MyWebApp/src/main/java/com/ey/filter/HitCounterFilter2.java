package com.ey.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class HitCounterFilter
 */
@WebFilter("/*")
public class HitCounterFilter2 extends HttpFilter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		
		ServletContext sCtx = getServletContext();
		Map<String, Integer> hitCounterMap = (Map<String, Integer>) sCtx.getAttribute("hitCounterMap");
		if(hitCounterMap == null)
			hitCounterMap = new HashMap<String, Integer>();
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		Integer hitCounter = hitCounterMap.get(uri);
		if(hitCounter == null)
			hitCounter = 0;
		
		hitCounter++;
		hitCounterMap.put(uri, hitCounter);
		
		sCtx.setAttribute("hitCounterMap", hitCounterMap);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
