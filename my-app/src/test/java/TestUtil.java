import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void lengthOne() {
    assertFalse(c.compute(1));
  }
  @Test
  public void lengthEven(){
    assertFalse(c.compute(1, 2, 3, 4));
  }
  @Test(expected = RuntimeException.class)
  public void zeroValue(){
    c.compute(0, 1, 2);
  }
  @Test
  public void oddValues(){
    assertTrue(c.compute(1, 3, 5));
  }
  @Test
  public void primeValues(){
    assertFalse(c.compute(7, 11, 13));
  }
}