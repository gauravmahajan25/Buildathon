package com.chooseacab.utl;

import com.chooseacab.platform.exception.SystemMessage;
import com.chooseacab.platform.exception.SystemMessageException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SystemMessageExceptionTest {

  private static final SystemMessage systemMessage = new SystemMessage("test message");

  /**
   * Test case with message only.
   */
  @Test
  public final void testWithMessageOnly() {
    try {
      throw new SystemMessageException(systemMessage);
    } catch (SystemMessageException e) {
      Assert.assertEquals(e.getSystemMessage().getMessage(), "test message");
      Assert.assertNull(e.getCause());
    }
  }

  /**
   * Test case for with cause.
   */
  @Test
  public final void testWithCause() {
    try {
      throw new SystemMessageException(new IllegalArgumentException("wrong"), systemMessage);
    } catch (SystemMessageException e) {
      Assert.assertEquals(e.getSystemMessage().getMessage(), "test message");
      Assert.assertNotNull(e.getCause());
      Assert.assertEquals(e.getCause().getMessage(), "wrong");
    }
  }
}
