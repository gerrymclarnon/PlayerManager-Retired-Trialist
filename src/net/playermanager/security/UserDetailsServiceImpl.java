package net.playermanager.security;

import net.playermanager.games.dao.UserDAO;
import net.playermanager.games.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;
	
	public UserDetailsServiceImpl()
	{
		super();
	}
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
				
		User user = userDAO.findByName(username);
		if (user == null)
			throw new UsernameNotFoundException("user not found");
		
		return user;
	}
}