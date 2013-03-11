package net.playermanager.games.services;

import net.playermanager.games.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("securityService")
public class SecurityService  {

	@Autowired
	private MutableAclService aclService;

	public SecurityService()
	{
		super();
	}
	
	public boolean hasPermission(Long clubId, String role) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		/*
		if (!user.hasClub(clubId, role))
		{
			throw new AccessDeniedException("Get: User '" + user.getUsername() + "' access denied for club " + clubId);
		}
		*/
		
		return true;
	}
	
	public void updateAcl(Object object)
	{
		ObjectIdentity oi = new ObjectIdentityImpl(object);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Sid sid = new PrincipalSid(user.getUsername());
		Permission p = BasePermission.WRITE;

		// Create or update the relevant ACL
		MutableAcl acl = null;
		try {
		  acl = (MutableAcl) aclService.readAclById(oi);
		} catch (NotFoundException nfe) {
		  acl = aclService.createAcl(oi);
		}

		// Now grant some permissions via an access control entry (ACE)
		acl.insertAce(acl.getEntries().size(), p, sid, true);
		aclService.updateAcl(acl);
	}
}