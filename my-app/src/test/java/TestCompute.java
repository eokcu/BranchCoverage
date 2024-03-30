import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void zeroMQSize() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    String e = "hello";
    when(mq.size()).thenReturn(0);
    assertEquals(-1, c.countNumberOfOccurrences(e));
  }
  @Test
  public void notIncludingOccurences(){
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    String e = "hello";
    when(mq.size()).thenReturn(1);
    when(mq.contains(e)).thenReturn(false);
    assertEquals(0, c.countNumberOfOccurrences(e));
  }
  @Test
  public void countOneOccurence(){
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    String e = "hello";
    when(mq.size()).thenReturn(2);
    when(mq.contains(e)).thenReturn(true);
    when(mq.getAt(0)).thenReturn(e);
    assertEquals(1, c.countNumberOfOccurrences(e));
  }
}