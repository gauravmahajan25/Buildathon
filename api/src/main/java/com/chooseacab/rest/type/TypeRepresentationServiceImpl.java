package com.chooseacab.rest.type;

import com.chooseacab.model.Type;
import com.chooseacab.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
@Transactional
public class TypeRepresentationServiceImpl implements TypeRepresentationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    protected TypeService typeService;

    @Override
    public List<TypeRepresentation> getTypes() {
        LOGGER.debug("Entering TypeRepresentationServiceImpl.getTypes");

        List<Type> types = typeService.getTypes();

        LOGGER.debug("Exiting TypeRepresentationServiceImpl.getTypes");

        return TypeRepresentation.toRepresentations(types);
    }
}
