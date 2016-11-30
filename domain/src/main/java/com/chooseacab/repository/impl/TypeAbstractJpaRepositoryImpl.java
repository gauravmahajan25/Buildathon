package com.chooseacab.repository.impl;

import com.chooseacab.model.Type;
import com.chooseacab.repository.TypeJpaRepository;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Type Repository class.
 * 
 */
@Repository
public class TypeAbstractJpaRepositoryImpl extends AbstractJpaRepositoryImpl<Type> implements TypeJpaRepository {

	/**
	 * Get Types.
	 * @return List of types.
	 */
    @Override
    public List<Type> getTypes(){
        final Criteria criteria = createCriteria();
        return criteria.list();
   }
}
