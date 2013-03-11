package net.playermanager.games.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDAO<T extends Serializable> {
	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	public void setClazz(final Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public T getById(final Long id) {
		return (T) this.getCurrentSession().get(this.clazz, id);
	}

	@SuppressWarnings("unchecked")
	public T getByUri(String uri) {
		String hql = "from " + this.clazz.getName() + " where uri = :uri";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter("uri", uri);

		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> getByUri() {
		return this.getCurrentSession()
				.createQuery("from " + this.clazz.getName() + " order by uri").list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return this.getCurrentSession()
				.createQuery("from " + this.clazz.getName() + " order by uri").list();
	}

	public void create(final T entity) {
		this.getCurrentSession().persist(entity);
	}

	public void update(final T entity) {
		this.getCurrentSession().merge(entity);
	}

	public void save(final T entity) {
		this.getCurrentSession().save(entity);
	}

	public void delete(final T entity) {
		this.getCurrentSession().delete(entity);
	}

	public void deleteById(final Long entityId) {
		final T entity = this.getById(entityId);
		this.delete(entity);
	}

	protected final Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
}