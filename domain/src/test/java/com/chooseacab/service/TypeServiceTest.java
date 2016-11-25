package com.chooseacab.service;

import com.chooseacab.model.Type;
import com.chooseacab.repository.TypeJpaRepository;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test for Type Service.
 */
public class TypeServiceTest {

	private TypeJpaRepository typeJpaRepository;
	
	@BeforeTest
	  public void setup() {
		typeJpaRepository = mock(TypeJpaRepository.class);
	  }

	@Test
	  public void testGetTypes() {
	    final Type type = new Type();
	    type.setName("OLA");

	    List<Type> expected= new ArrayList<>();
	    expected.add(type);

	    when(typeJpaRepository.getTypes()).thenReturn(expected);

	    final Collection<Type> actual = typeJpaRepository.getTypes();

	    Assert.assertEquals(actual.size(), expected.size());
	  }
}
