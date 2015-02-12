package com.bookstore.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.bookstore.model.BookUserDetails;




public class CustomSimpleUrlAuthenticationSuccessHandler extends   SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//role&URLs stuff for admin
		
		List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) authentication.getAuthorities();
		String outcome = null;
		//setting displayName session attribute 
		
		BookUserDetails bookUserDetails = (BookUserDetails)authentication.getPrincipal();
		logger.info("is the session new "+request.getSession(false).isNew());
		if(request.getSession(false)!=null){
		request.getSession(false).setAttribute("displayName", bookUserDetails.getDisplayName());
		}
		logger.info("hello in the onauthenticationsuccess custom :"+authentication);
		super.onAuthenticationSuccess(request, response, authentication);
	}
	

}
