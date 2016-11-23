package com.chooseacab.repository.impl;

import com.chooseacab.repository.JpaRepository;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

public abstract class JpaRepositoryImpl<T> implements JpaRepository<T> {

    /**
     * JPA persistent unit name configured in persistence.xml
     */
    public static final String DNA_JPA_PERSISTENT_UNIT_NAME = "chooseacab-domain";

    private static final String FIND_ALL_CLAUSE = "from {0}";

    private static final Logger LOGGER = LoggerFactory.getLogger(JpaRepositoryImpl.class);

    @PersistenceContext(unitName = DNA_JPA_PERSISTENT_UNIT_NAME)
    protected EntityManager entityManager;

    @SuppressWarnings("rawtypes")
    private static final  List EMPTY_LIST = Collections
            .unmodifiableList(new ArrayList<T>());

    @Autowired(required = false)
    private Dialect dialect = null;

    private final Class<T> elementType; // entity type

    @SuppressWarnings({ "unchecked" })
    public JpaRepositoryImpl() {
        elementType = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @PostConstruct
    public void initialize() {
    }

    protected Class<T> getElementType() {
        return elementType;
    }

    @SuppressWarnings({ "unchecked" })
    public Collection<T> findAll() {
        String findQueryStr = MessageFormat.format(FIND_ALL_CLAUSE,
                new Object[] { getElementType().getName() });

        Query findQuery = entityManager.createQuery(findQueryStr);
        return findQuery.getResultList();        
    }

    public T findById(Object id) {
    	return entityManager.find(getElementType(), id);        
    }

    public T makePersist(T entity) {
        return entityManager.merge(entity);
    }

    public void makeRemove(T entity) {
        entityManager.remove(entity);
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    // @NotNull
    public final Criteria createCriteria(final String pSalias) {
        if (StringUtils.isBlank(pSalias)) {
            return createCriteria();
        } else {
            return ((Session)getEntityManager().getDelegate()).createCriteria(elementType, p_sAlias);
        }
    }

    public Criteria createCriteria() {
        return ((Session)getEntityManager().getDelegate()).createCriteria(elementType);
    }

    /**
     * Given a SQL query string, return a Hibernate SQLQuery object that can be populated with
     * query parameters.
     * @param query SQL Query
     * @return Hibernate SQLQuery
     */
    public SQLQuery createSQLQuery(final String query) {
        return ((Session)getEntityManager().getDelegate()).createSQLQuery(query);
    }

}