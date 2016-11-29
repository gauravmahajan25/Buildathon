package com.chooseacab.repository.impl;

import com.chooseacab.model.Operator;
import com.chooseacab.repository.OperatorJpaRepository;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperatorAbstractJpaRepositoryImpl extends AbstractJpaRepositoryImpl<Operator> implements OperatorJpaRepository {

    /**
     *
     * @return list of operators.
     */
    @Override
    public final List<Operator> getOperators(){
        Criteria criteria = createCriteria();

        return criteria.list();
    }
}
