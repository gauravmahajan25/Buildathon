package com.chooseacab.utl;

import com.chooseacab.platform.exception.SystemMessage;
import com.chooseacab.util.ResourceBundleEnum;
import org.springframework.context.support.StaticMessageSource;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

@Test
public class SystemMessageTest {

  private static StaticMessageSource staticMessageSource = null;

  @BeforeClass
  public final void before(){
    staticMessageSource = new StaticMessageSource();
    staticMessageSource.addMessage("code", Locale.getDefault(), "message");
    staticMessageSource.addMessage(ResourceBundleEnum.DEFAULT.getMessageId(), Locale.getDefault(), "the default");
  }

  /**
   * Test case for short initialization.
   */
  @Test
  public final void testShortInitialization() {
    SystemMessage m = new SystemMessage("test message");

    Assert.assertNull(m.getId());
    Assert.assertNull(m.getCode());
    Assert.assertNotNull(m.getMessage());
    Assert.assertEquals(m.getMessage(), "test message");
  }

  /**
   * Test case for initialization.
   */
  @Test
  public final void testInitialization() {
    SystemMessage m = new SystemMessage("ID", "CODE", "test message");

    Assert.assertNotNull(m.getId());
    Assert.assertNotNull(m.getCode());
    Assert.assertNotNull(m.getMessage());

    Assert.assertEquals(m.getId(), "ID");
    Assert.assertEquals(m.getCode(), "CODE");
    Assert.assertEquals(m.getMessage(), "test message");
  }

  /**
   * Test case for test options.
   */
  @Test
  public final void testOptions() {
    SystemMessage m = new SystemMessage("ID", "CODE", "test message");

    Assert.assertNotNull(m.getId());
    Assert.assertNotNull(m.getCode());
    Assert.assertNotNull(m.getMessage());

    Assert.assertEquals(m.getId(), "ID");
    Assert.assertEquals(m.getCode(), "CODE");
    Assert.assertEquals(m.getMessage(), "test message");
  }

  /**
   * Test case for create system message with bad enum.
   */
  @Test
  public final void testCreateSystemMessageWithBadEnum() {
    ResourceBundleEnum nullEnum = null;
    SystemMessage m = SystemMessage.createSystemMessage(staticMessageSource, nullEnum);

    Assert.assertNotNull(m.getId());
    Assert.assertNotNull(m.getCode());
    Assert.assertNotNull(m.getMessage());

    Assert.assertEquals(m.getId(), ResourceBundleEnum.DEFAULT.getMessageId());
    Assert.assertEquals(m.getCode(), ResourceBundleEnum.DEFAULT.name());
    Assert.assertEquals(m.getMessage(), "the default");
  }
}
