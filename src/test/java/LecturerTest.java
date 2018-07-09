import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class LecturerTest {

  @Test
  public void lecturerWithoutTitle() {
    String[] names =
        new String[] {"hadsh", "Kjahds", "kjhd", "kdhds asda sa", "kdsjha", "kjhkjhs", "dkjhskj"};
    for (String s : names) {
      Lecturer l = new Lecturer(s);
      assertEquals(s, l.toString());
    }
  }

  @Test
  public void lecturerWithTitle() {
    String[] names =
        new String[] {"hadsh", "Kjahds", "kjhd", "kdhds asda sa", "kdsjha", "kjhkjhs", "dkjhskj"};
    for (String s : names) {
      for (Title t : Title.values()) {
        Lecturer l = new Lecturer(t, s);
        assertEquals(t + " " + s, l.toString());
      }
    }
  }

  @Test
  public void lecturerWithoutTitleSetTitle() {
    String[] names =
        new String[] {"hadsh", "Kjahds", "kjhd", "kdhds asda sa", "kdsjha", "kjhkjhs", "dkjhskj"};
    for (String s : names) {
      Lecturer l = new Lecturer(s);
      for (Title t : Title.values()) {
        l.setTitle(t);
        assertEquals(t + " " + s, l.toString());
      }
    }
  }

  @Test
  public void lecturerWithTitleSetTitle() {
    String[] names =
        new String[] {"hadsh", "Kjahds", "kjhd", "kdhds asda sa", "kdsjha", "kjhkjhs", "dkjhskj"};
    for (String s : names) {
      for (Title t : Title.values()) {
        Lecturer l = new Lecturer(t, s);
        assertEquals(t + " " + s, l.toString());
        for (Title tnew : Title.values()) {
          l.setTitle(tnew);
          assertEquals(tnew + " " + s, l.toString());
        }
      }
    }
  }

}
