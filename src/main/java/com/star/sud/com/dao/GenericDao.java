
package com.star.sud.com.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<E, K> {

	// Interface
	////////////
	void add(E entity) throws Exception;

	void saveOrUpdate(E entity) throws Exception;

	void update(E entity) throws Exception;

	void remove(E entity) throws Exception;

	E find(K key) throws Exception;

	List<E> getAll() throws Exception;

	List<E> getAll(List<String> fieldsAsc, List<String> fieldsDesc) throws Exception;

	List<E> getByLikeCriteria(Map<String, Object> criterias, Map<String, Object> fieldDateStartCriteria,
			Map<String, Object> fieldDateEndCriteria, List<String> fieldsAsc, List<String> fieldsDesc, int limit,
			int offset) throws Exception;

	List<E> getByQuery(String hql) throws Exception;

	List<E> getByQuery(String hql, Map<String, Object> parameters) throws Exception;

	List<E> getByQuery(String hql, Map<String, Object> parameters, int limit, int offset) throws Exception;

	int executeNativeSQL(String nativeSQL) throws Exception;

	List<E> getByNativeSQL(String nativeSQL);

}