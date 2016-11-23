package com.chooseacab.rest.operator;

import com.chooseacab.model.Operator;
import com.chooseacab.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
@Transactional
public class OperatorRepresentationServiceImpl implements OperatorRepresentationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    protected OperatorService operatorService;

    @Override
    public List<OperatorRepresentation> getOperators() {
        LOGGER.debug("Entering OperatorRepresentationServiceImpl.getOperators");

        List<Operator> operators = operatorService.getOperators();

        LOGGER.debug("Exiting OperatorRepresentationServiceImpl.getOperators");

        return OperatorRepresentation.toRepresentations(operators);
    }
}
