import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExamtypeTest {

  @Test
  public void values() {
    Examtype[] expected = new Examtype[] {Examtype.Oral, Examtype.Written};
    assertArrayEquals(expected, Examtype.values());
  }

}
