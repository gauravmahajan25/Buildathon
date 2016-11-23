package com.chooseacab.utl;

import com.chooseacab.platform.exception.SystemMessage;
import com.chooseacab.platform.exception.SystemMessageException;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SystemMessageExceptionTest {

  @Test
  public void testWithMessageOnly() {
    SystemMessage m = new SystemMessage("test message");

    try {
      throw new SystemMessageException(m);
    } catch (SystemMessageException e) {
      Assert.assertEquals(e.getSystemMessage().getMessage(), "test message");
      Assert.assertNull(e.getCause());
    }
  }

  @Test
  public void testWithCause() {
    SystemMessage m = new SystemMessage("test message");

    try {
      throw new SystemMessageException(new IllegalArgumentException("wrong"), m);
    } catch (SystemMessageException e) {
      Assert.assertEquals(e.getSystemMessage().getMessage(), "test message");
      Assert.assertNotNull(e.getCause());
      Assert.assertEquals(e.getCause().getMessage(), "wrong");
    }
  }
}
