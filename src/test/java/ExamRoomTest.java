import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExamRoomTest {

  @Test
  public void examRoom() {
    ExamRoom r = new ExamRoom("R1.006", 60,30);
    assertEquals("R1.006", r.getName());
    assertEquals(60, r.getSeats());
    assertEquals(30, r.getSeatsForExam());
  }

  @Test
  public void examRoomFromRoom() {
    ExamRoom r = new ExamRoom(new Room("R1.006", 60),30);
    assertEquals("R1.006", r.getName());
    assertEquals(60, r.getSeats());
    assertEquals(30, r.getSeatsForExam());
  }

  @Test
  public void examRoomIsRoom() {
    ExamRoom r = new ExamRoom(new Room("R1.006", 60),30);
    assertTrue(r instanceof Room);
  }

}