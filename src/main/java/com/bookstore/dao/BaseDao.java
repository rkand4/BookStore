package com.bookstore.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BaseDao<T , PK extends Serializable> {
		
	public T get(Long id);
	public T find(Class<T> klass, PK id);
	public List<T> getList();
	public void update(T t);
	public void deleteById(Long id);
	public void deleteAll();
	public long count();
	public void save(T persistentObject) ;
	public void delete(T persistentObject) ;
	public List<T> loadAll(Class<T> klass);
	public List<?> find(String queryString, Object value);
	public List<?> find(String queryString, Object[] values) ;
	public List<?> find(final String queryString, final Object[] values, boolean isDistinct) throws DataAccessException ;
	
	

}
