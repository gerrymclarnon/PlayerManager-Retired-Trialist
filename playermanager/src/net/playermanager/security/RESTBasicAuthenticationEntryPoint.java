package net.playermanager.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public final class RESTBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
   
	@Override
   public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
           throws IOException, ServletException {
       //response.addHeader("WWW-Authenticate", "Basic realm=\"" + realmName + "\"");
       response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
   }

}
