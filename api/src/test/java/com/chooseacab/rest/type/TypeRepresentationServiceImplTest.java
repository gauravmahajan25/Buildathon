package com.chooseacab.rest.type;

import com.chooseacab.model.Type;
import com.chooseacab.service.TypeService;

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
 * A test class for Type Representation. This class unit tests the name and id for a type.
 */
public class TypeRepresentationServiceImplTest {

  @Mock
  private TypeService typeService;

  private TypeRepresentationService typeRepresentationService;

  @BeforeClass
  public void beforeTest() {
    MockitoAnnotations.initMocks(this);
    typeRepresentationService = new TypeRepresentationServiceImpl();
    ReflectionTestUtils.setField(typeRepresentationService, "typeService", typeService);
  }

  /**
   * A test to test the type retrieval.
   */
  @Test
  public void getTypesTest() {

    final Type type = new Type();
    type.setName("TYP1");

    final List<Type> types = new ArrayList<>();
    types.add(type);

    final Collection<TypeRepresentation> actual = TypeRepresentation.toRepresentations(types);

    when(typeService.getTypes()).thenReturn(types);
    final Collection<TypeRepresentation> expected = typeRepresentationService.getTypes();
    Assert.assertEquals(actual.size(), expected.size());

  }

}
