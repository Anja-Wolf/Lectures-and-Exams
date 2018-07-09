import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TitleTest {

  @Test
  public void values() {
    Title[] expected = new Title[] {Title.Dr, Title.Prof, Title.ProfDr};
    assertArrayEquals(expected, Title.values());
  }

  @Test
  public void string() {
    assertEquals("Dr.", Title.Dr.toString());
    assertEquals("Prof.", Title.Prof.toString());
    assertEquals("Prof. Dr.", Title.ProfDr.toString());
  }
}
