package com.chooseacab.utl;

import com.chooseacab.platform.exception.NoSuchEntityException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class NoSuchEntityExceptionTest {

  /**
   * Test case for with message only.
   */
  @Test
  public final void testWithMessageOnly() {
    try {
      throw new NoSuchEntityException("test message");
    } catch (NoSuchEntityException e) {
      Assert.assertEquals(e.getMessage(), "test message");
      Assert.assertNull(e.getCause());
      throw e;
    }
  }
}
