package com.chooseacab.service.impl;

import com.chooseacab.model.Operator;
import com.chooseacab.repository.OperatorJpaRepository;
import com.chooseacab.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Operator Service Implementation class.
 * Provides api to get all Operators.
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

	/**
	 * Property for OperatorJpaRepository.
	 */
    private OperatorJpaRepository operatorJpaRepository;

    /**
     * Constructor to initialize OperatorJpaRepository.
     * @param OperatorJpaRepository
     */
    @Autowired
    public OperatorServiceImpl(final OperatorJpaRepository operatorJpaRepository) {
        this.operatorJpaRepository = operatorJpaRepository;
    }

    /**
     * Method to get Operators.
     * @return List - list of operators.
     */
    @Override
    public List<Operator> getOperators(){
        return operatorJpaRepository.getOperators();
    }
}
