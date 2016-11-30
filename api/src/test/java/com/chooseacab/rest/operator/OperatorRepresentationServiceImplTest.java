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
  private static OperatorService operatorService;

  private static OperatorRepresentationService operatorRepresentationService;

  /**
   * Setup before test.
   */
  @BeforeClass
  public final void beforeTest() {
    MockitoAnnotations.initMocks(this);
    operatorRepresentationService = new OperatorRepresentationServiceImpl();
    ReflectionTestUtils.setField(operatorRepresentationService, "operatorService", operatorService);
  }

  /**
   * Test Get Operators.
   */
  @Test
  public final void testGetOperators() {

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
