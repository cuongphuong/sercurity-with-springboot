package cpg.sr.security.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FunctionPermissionFillter implements Filter {
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// parse token from request to username
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String user = TokenAuthenticationService.getUser(httpRequest);
		
		String url = httpRequest.getRequestURI();
		// check permistion
		System.out.println("Function user: " + user);
		System.out.println("Function url: " + url);
		chain.doFilter(request, response);
	}

}
