package net.playermanager.games.dao;

import java.util.List;

import net.playermanager.games.model.User;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAO extends AbstractHibernateDAO< User > {

	public UserDAO() {
		super();
	    setClazz(User.class );
	}
	
	@SuppressWarnings("unchecked")
	public User findByName(String name) {
		String hql = "from User u where u.username = :username";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("username", name);
		List<User> result = query.list();
		
		return result.get(0);
	}
}