package com.chooseacab.service.impl;

import com.chooseacab.model.Type;
import com.chooseacab.repository.TypeJpaRepository;
import com.chooseacab.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    private TypeJpaRepository typeJpaRepository;

    @Autowired
    public TypeServiceImpl(final TypeJpaRepository typeJpaRepository) {
        this.typeJpaRepository = typeJpaRepository;
    }

    @Override
    public List<Type> getTypes(){
        return typeJpaRepository.getTypes();
    }
}
