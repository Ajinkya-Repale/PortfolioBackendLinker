package com.MainApp.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Admin;
import com.MainApp.Repository.AdminRepository;

@Service
public class CustomAdminDetailsService implements UserDetailsService{

	
	private final AdminRepository aRepo;
	
	public CustomAdminDetailsService(AdminRepository aRepo)
	{
		super();
		this.aRepo=aRepo;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException 
	{
		Admin admin=aRepo.findByAdminName(username)
				 .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));
				return  new CustomAdminDetails(admin);
	}

}
