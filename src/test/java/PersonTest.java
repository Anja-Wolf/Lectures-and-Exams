import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class PersonTest {

  @Test
  public void persons() {
    String[] names = new String[] {"hadsh", "Kjahds", "kjhd", "kdhds asda sa"};
    for (String s : names) {
      assertEquals(s, new Person(s).getName());
      assertEquals(s, new Person(s).toString());
    }
  }
}