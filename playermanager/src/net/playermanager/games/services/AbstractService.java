package net.playermanager.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.playermanager.games.dao.DAO;

public abstract class AbstractService<T> implements Service<T> {

	private DAO<T> dao;
	
	@Autowired
	protected SecurityService securityService;

	public AbstractService() {
		super();
	}

	public DAO<T> getDao() {
		return dao;
	}

	public void setDao(DAO<T> dao) {
		this.dao = dao;
	}

	public List<T> getAll() {
		return dao.getAll();
	}

	public T getById(Long id) {
		return dao.getById(id);
	}

	public T getByUri(String id) {
		return dao.getByUri(id);
	}

	public T create(T entity) {
		return dao.create(entity);
	}
	
	public T update(T entity) {
		return dao.update(entity);
	}
	
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

}