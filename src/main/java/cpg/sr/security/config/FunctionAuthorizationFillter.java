package cpg.sr.security.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import cpg.sr.security.commons.ApplicationContextUtils;
import cpg.sr.security.commons.StringUtils;

@Configuration
public class FunctionAuthorizationFillter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//
		ApplicationContext context = ApplicationContextUtils.getApplicationContext();
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// get URL from request and parse to arr
		final String URL_REQUEST = httpRequest.getRequestURI();
		String[] arrURL = StringUtils.parseURL(URL_REQUEST);

		// String urlServer =
		// context.getBean(FunctionService.class).getURLFunction(1033);
		System.err.println("do fillter");
		chain.doFilter(request, response);
	}
}
