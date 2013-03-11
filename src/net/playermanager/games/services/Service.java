package net.playermanager.games.services;

import java.util.List;

public interface Service<T> {
	public List<T> getAll();
	public T getById(Long id);
	public T getByUri(String id);
	public T create(T entity);
	public T update(T entity);
	public void deleteById(Long id);
}
