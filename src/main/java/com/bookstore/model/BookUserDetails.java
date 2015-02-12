package com.bookstore.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("deprecation")
public class BookUserDetails implements UserDetails {
	
	private String username;
	private boolean enabled = false ; 
	private Collection<GrantedAuthority> authorities;
    private String displayName;
    private String password; 


	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAuthorities(List<String> roles) {
		
		 List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
	        for (String role : roles) {
	            listOfAuthorities.add(new GrantedAuthorityImpl(role));
	        }
	        this.authorities = listOfAuthorities;
	    }
	

	public Collection<GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isCredentialsNonExpired() {

		return true;
	}

	public boolean isEnabled() {
		
		return enabled;
	}

	public String getPassword() {
		
		return password;
	}

	public boolean isAccountNonLocked() {

		return true;
	}
}
