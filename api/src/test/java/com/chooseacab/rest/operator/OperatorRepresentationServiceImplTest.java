package com.chooseacab.rest.operator;

import com.chooseacab.model.Operator;
import com.chooseacab.service.OperatorService;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Test case for Operator Representation Service Implementations.
 */
public class OperatorRepresentationServiceImplTest {

  @Mock
  private OperatorService operatorService;

  private OperatorRepresentationService operatorRepresentationService;

  @BeforeClass
  public void beforeTest() {
    MockitoAnnotations.initMocks(this);
    operatorRepresentationService = new OperatorRepresentationServiceImpl();
    ReflectionTestUtils.setField(operatorRepresentationService, "operatorService", operatorService);
  }

  @Test
  public void testGetOperators() {

    final Operator operator = new Operator();
    operator.setName("OP1");

    final List<Operator> operators = new ArrayList<>();
    operators.add(operator);

    final Collection<OperatorRepresentation> actual = OperatorRepresentation.toRepresentations(operators);

    when(operatorService.getOperators()).thenReturn(operators);

    final Collection<OperatorRepresentation>
        expected =
        operatorRepresentationService.getOperators();

    Assert.assertEquals(actual.size(), expected.size());
  }
}
