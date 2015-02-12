package com.bookstore.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.bookstore.model.BookUserDetails;
import com.bookstore.model.User;

public class BookUserdetailsTransformer {

	public BookUserDetails transformFromUserToMamosUserDetails(User user) {
		BookUserDetails mamosUserDetails = new BookUserDetails();
		if (user != null) {
			mamosUserDetails.setEnabled(user.isEnabled());
			mamosUserDetails.setPassword(user.getPassword());
			mamosUserDetails.setUsername(user.getUsername());
			mamosUserDetails.setDisplayName(user.getDisplayName());
			List<GrantedAuthority> authorities =AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
			ArrayList<String> roles = new ArrayList<String>();
			for(GrantedAuthority authorityiter : authorities){
				roles.add(authorityiter.getAuthority());
			}
			mamosUserDetails.setAuthorities(roles);
		}
		return mamosUserDetails;
	}

}
