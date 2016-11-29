package com.chooseacab.repository.impl;

import com.chooseacab.model.Type;
import com.chooseacab.repository.TypeJpaRepository;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeAbstractJpaRepositoryImpl extends AbstractJpaRepositoryImpl<Type> implements TypeJpaRepository {

    @Override
    public List<Type> getTypes(){
        Criteria criteria = createCriteria();

        List<Type> types = criteria.list();

        return types;
    }
}
