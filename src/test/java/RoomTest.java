import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RoomTest {

  @Test
  public void room() {
    Room r = new Room("R1.006", 60);
    assertEquals("R1.006", r.getName());
    assertEquals(60, r.getSeats());
  }

  @Test
  public void equalsNull() {
    Room r = new Room("R1.006", 60);
    assertFalse(r.equals(null));
  }

  @Test
  public void equalsOtherClass() {
    Room r = new Room("R1.006", 60);
    assertFalse(r.equals("R1.006"));
  }

  @Test
  public void equalsOtherName() {
    Room r = new Room("R1.006", 60);
    Room other = new Room("R1.008", 60);
    assertFalse(r.equals(other));
  }

  @Test
  public void equalsSameName() {
    Room r = new Room("R1.006", 60);
    Room other = new Room("R1.006", 10);
    assertTrue(r.equals(other));
  }

  @Test
  public void equalsSymmetry() {
    Room r = new Room("R1.006", 60);
    Room other = new Room("R1.006", 10);
    assertTrue(other.equals(r));
  }


  @Test
  public void hashCodeDifferentName() {
    Room r = new Room("R1.006", 60);
    Room other = new Room("R1.008", 60);
    assertNotEquals(r.hashCode(), other.hashCode());
  }

  @Test
  public void hashCodeSameName() {
    Room r = new Room("R1.006", 60);
    Room other = new Room("R1.006", 10);
    assertEquals(r.hashCode(), other.hashCode());
  }

}