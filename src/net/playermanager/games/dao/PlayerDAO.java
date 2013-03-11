package net.playermanager.games.dao;

import java.util.List;

import net.playermanager.games.model.Player;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("playerDAO")
@Transactional
public class PlayerDAO extends AbstractDAOImpl< Player > {

	public PlayerDAO() {
		super();
	    setClazz(Player.class );
	}

	@SuppressWarnings("unchecked")
	public List<Player> searchPlayers(String lastName) {
		Criteria criteria = getCurrentSession().createCriteria(
				Player.class);
		criteria.add(Restrictions.ilike("lastName", lastName + "%"));

		return criteria.list();
	}
}
