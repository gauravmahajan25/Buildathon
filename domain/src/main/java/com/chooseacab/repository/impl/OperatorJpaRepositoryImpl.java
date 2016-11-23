package com.chooseacab.repository.impl;

import com.chooseacab.model.Operator;
import com.chooseacab.repository.OperatorJpaRepository;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperatorJpaRepositoryImpl extends JpaRepositoryImpl<Operator> implements OperatorJpaRepository {

    @Override
    public List<Operator> getOperators(){
        Criteria criteria = createCriteria();

        List<Operator> operators = criteria.list();

        return operators;
    }
}
