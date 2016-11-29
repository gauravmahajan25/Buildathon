package com.chooseacab.repository.impl;

import com.chooseacab.repository.JpaRepository;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class AbstractJpaRepositoryImpl<T> implements JpaRepository<T> {

	/**
	 * JPA persistent unit name configured in persistence.xml.
	 */
	public static final String DNA_JPA_PERSISTENT_UNIT_NAME = "chooseacab-domain";

	private static final String FIND_ALL_CLAUSE = "from {0}";	

	@PersistenceContext(unitName = DNA_JPA_PERSISTENT_UNIT_NAME)
	private transient EntityManager entityManager;

	@SuppressWarnings("rawtypes")
	private static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());

	@Autowired(required = false)
	private final Dialect dialect = null;

	private final Class<T> elementType; // entity type

	/**
	 * Default constructor.
	 */
	@SuppressWarnings({ "unchecked" })
	public AbstractJpaRepositoryImpl() {
		elementType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Get Element type.
	 * @return elementType
     */
	protected final Class<T> getElementType() {
		return elementType;
	}

	/**
	 *
	 * @param id primary key object
	 * @return t Entity
     */
	public final T findById(final Object id) {
		return entityManager.find(getElementType(), id);
	}

	/**
	 *
	 * @param entity entity to be made persistent.
	 * @return t Merged entity
     */
	public final T makePersist(T entity) {
		return entityManager.merge(entity);
	}

	/**
	 * @return the entityManager
	 */
	public final EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 *
	 * @param pSalias
	 * @return criteria Criteria
     */
	public final Criteria createCriteria(final String pSalias) {
		Criteria criteria;
		if (StringUtils.isBlank(pSalias)) {
			criteria = createCriteria();
		} else {
			criteria = ((Session) getEntityManager().getDelegate()).createCriteria(elementType, pSalias);
		}

		return criteria;
	}

	/**
	 * Create Criteria.
	 * @return criteria Criteria
     */
	public final Criteria createCriteria() {
		return ((Session) getEntityManager().getDelegate()).createCriteria(elementType);
	}

	/**
	 * Given a SQL query string, return a Hibernate SQLQuery object that can be
	 * populated with query parameters.
	 * 
	 * @param query SQL Query.
	 * @return Hibernate SQLQuery
	 */
	public final SQLQuery createSQLQuery(final String query) {
		return ((Session) getEntityManager().getDelegate()).createSQLQuery(query);
	}

}