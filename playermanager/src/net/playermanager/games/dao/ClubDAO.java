package net.playermanager.games.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import net.playermanager.games.model.Club;
import net.playermanager.games.model.Player;
import net.playermanager.games.model.User;

import org.hibernate.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("clubDAO")
@Transactional
public class ClubDAO extends AbstractDAOImpl< Club > {

	public ClubDAO() {
		super();
	    setClazz(Club.class );
	}
	
	public List<Player> getPlayers(Long id) {
		Club club = getById(id);
		return new ArrayList<Player>(club.getPlayers());
	}

	public List<Player> getPlayers(Club club) {
		return new ArrayList<Player>(getById(club.getId()).getPlayers());
	}


	/*
	 * Gets all the Clubs that the user has permission to view.
	 * This method should perform better than using the ACL @PostFilter method,
	 * assuming there are more than a handful of clubs.
	 * 
	 * Use NamedQuery?
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Club> getAll() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String findClubsByUsernameSQL = 
		"select acl_object_identity.object_id_identity " +
        "from acl_object_identity " + 
        "left join acl_sid acli_sid on acli_sid.id = acl_object_identity.owner_sid " + 
        "left join acl_class on acl_class.id = acl_object_identity.object_id_class " +   
        "left join acl_entry on acl_object_identity.id = acl_entry.acl_object_identity " + 
        "left join acl_sid on acl_entry.sid = acl_sid.id " + 
        "where acl_class.class = 'net.playermanager.games.model.Club' " +
        "and acl_sid.sid = :username";
		
		Query query = getCurrentSession().createSQLQuery(findClubsByUsernameSQL);
		query.setParameter("username", user.getUsername());
		List<BigInteger> clubIDs = query.list();
		
		List<Club> clubs = new ArrayList<Club>();
        for (BigInteger id:clubIDs) {
        	clubs.add(getById(id.longValue()));
        }		
		return clubs;
	}	
}
