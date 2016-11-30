package com.chooseacab.service.impl;

import com.chooseacab.model.Type;
import com.chooseacab.repository.TypeJpaRepository;
import com.chooseacab.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Type Service Implementation class.
 * Provides api to get all Types.
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	/**
	 * Property for TypeJpaRepository
	 */
    private TypeJpaRepository typeJpaRepository;

    /**
     * Constructor to initialize TypeJpaRepository.
     * @param TypeJpaRepository
     */
    @Autowired
    public TypeServiceImpl(final TypeJpaRepository typeJpaRepository) {
        this.typeJpaRepository = typeJpaRepository;
    }

    /**
     * Get Types.
     * @return List - list of types.
     */
    @Override
    public List<Type> getTypes(){
        return typeJpaRepository.getTypes();
    }
}
