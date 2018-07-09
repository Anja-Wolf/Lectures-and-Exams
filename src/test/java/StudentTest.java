import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class StudentTest {

  @Test
  public void students() {
    String[] names =
        new String[] {"hadsh", "Kjahds", "kjhd", "kdhds asda sa", "kdsjha", "kjhkjhs", "dkjhskj"};
    Set<Integer> matrikels = new HashSet<>();
    int count = 0;
    for (String s : names) {
      Student stud = new Student(s);
      assertEquals(s, stud.getName());
      assertEquals(s, stud.toString());
      matrikels.add(stud.getMatrikel());
      count++;
    }
    assertEquals(count, matrikels.size());
  }
}
