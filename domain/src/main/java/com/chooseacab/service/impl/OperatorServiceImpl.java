package com.chooseacab.service.impl;

import com.chooseacab.model.Operator;
import com.chooseacab.repository.OperatorJpaRepository;
import com.chooseacab.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    private OperatorJpaRepository operatorJpaRepository;

    @Autowired
    public OperatorServiceImpl(final OperatorJpaRepository operatorJpaRepository) {
        this.operatorJpaRepository = operatorJpaRepository;
    }

    @Override
    public List<Operator> getOperators(){
        return operatorJpaRepository.getOperators();
    }
}
