import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class GroupTest {

  @Test
  public void values() {
    Group[] expected = new Group[] {Group.IB, Group.IC, Group.IF, Group.IG, Group.IN, Group.IS};
    assertArrayEquals(expected, Group.values());
  }

  @Test
  public void bachelor() {
    assertTrue(Group.IB.isBachelor());
    assertTrue(Group.IC.isBachelor());
    assertTrue(Group.IF.isBachelor());
    assertFalse(Group.IG.isBachelor());
    assertFalse(Group.IN.isBachelor());
    assertFalse(Group.IS.isBachelor());
  }

  @Test
  public void master() {
    assertFalse(Group.IB.isMaster());
    assertFalse(Group.IC.isMaster());
    assertFalse(Group.IF.isMaster());
    assertTrue(Group.IG.isMaster());
    assertTrue(Group.IN.isMaster());
    assertTrue(Group.IS.isMaster());
  }

  @Test
  public void string() {
    assertEquals("Wirtschaftsinformatik (Bachelor)", Group.IB.toString());
    assertEquals("Scientific Computing (Bachelor)", Group.IC.toString());
    assertEquals("Informatik (Bachelor)", Group.IF.toString());
    assertEquals("Informatik (Master)", Group.IG.toString());
    assertEquals("Wirtschaftsinformatik (Master)", Group.IN.toString());
    assertEquals("Stochastic Engineering (Master)", Group.IS.toString());
  }

  @Test
  public void bachelors() {
    Set<Group> expected = new HashSet<>();
    expected.add(Group.IB);
    expected.add(Group.IC);
    expected.add(Group.IF);
    assertEquals(expected, Group.getBachelors());
  }

  @Test
  public void masters() {
    Set<Group> expected = new HashSet<>();
    expected.add(Group.IG);
    expected.add(Group.IN);
    expected.add(Group.IS);
    assertEquals(expected, Group.getMasters());
  }
}
