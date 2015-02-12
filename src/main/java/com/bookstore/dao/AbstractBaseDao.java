package com.bookstore.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class AbstractBaseDao<T , PK extends Serializable> implements BaseDao<T , PK> {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> domainClass;
	
	public long count() {
		Query q = getSession()
			.createQuery("select count(*) from " + getDomainClassName());
		return (Long) q.uniqueResult();
	}
	public void save(T persistentObject) {
		getSession().saveOrUpdate(persistentObject);
		//getSession().merge(persistentObject);
		getSession().flush();
	}
	
	@SuppressWarnings("unchecked")
	public T get(Long id) {
		return (T) getSession().get(getDomainClass(), id);
	}
	@SuppressWarnings("unchecked")
	public T find(Class<T> klass, PK id) {
		T o = (T) sessionFactory.getCurrentSession().get(klass, id);
		return o;
	}
	
	public void update(T t) {
		getSession().update(t);
	}
	
	public void deleteById(Long id) {
		getSession().delete(get(id));
	}
	public void delete(T persistentObject) {
		getSession().delete(persistentObject);
		getSession().flush();
	}
	public void deleteAll() {
		Query q = getSession().createQuery("delete " + getDomainClassName());
		q.executeUpdate();
	}
	
	//List queries
	@SuppressWarnings("unchecked")
	public List<T> getList() {
		Query q = getSession().createQuery("from " + getDomainClassName());
		return q.list();
	}
	@SuppressWarnings("unchecked")
	public List<T> loadAll(Class<T> klass) {
		Criteria criteria = getCriteria(klass);
		prepareCriteria(criteria);
		return criteria.list();
	}
	
	public List<?> find(String queryString, Object value) {
		Object[] values = null;
		if(value != null){
			values = new Object[] {value};
		}
		return find(queryString, values);
	}
	
	public List<?> find(String queryString, Object[] values)  {
		return find(queryString, values, true);
	}
	
	public List<?> find(final String queryString, final Object[] values, boolean isDistinct) throws DataAccessException {
		Query queryObject = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}
		
		if(isDistinct){
			queryObject.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		}
		return queryObject.list();
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Criteria getCriteria(Class<?> klass) {
		return getSession().createCriteria(klass);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	public Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
	public  Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	protected void prepareCriteria(Criteria criteria) {
		SessionFactoryUtils.applyTransactionTimeout(criteria, sessionFactory);
	}
	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
	    if (domainClass == null) {
	    	ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
	        this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
	    }
	    return domainClass;
	}
	
	private String getDomainClassName() {
		return getDomainClass().getName();
	}
	
	
}
