package com.chooseacab.utl;

import com.chooseacab.platform.exception.NoSuchEntityException;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class NoSuchEntityExceptionTest {

  @Test
  public void testWithMessageOnly() {

    try {
      throw new NoSuchEntityException("test message");
    } catch (NoSuchEntityException e) {
      Assert.assertEquals(e.getMessage(), "test message");
      Assert.assertNull(e.getCause());
    }
  }
}
