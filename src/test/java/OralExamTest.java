import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;
import org.junit.Test;

public class OralExamTest {

  @Test
  public void oralExam() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    assertEquals(90, exam.getDuration());
    assertEquals(Title.ProfDr + " " + "Oliver Braun", exam.getExaminer().toString());
    assertEquals(new HashSet<Room>(), exam.getExamRooms());
    assertEquals(new HashSet<Student>(), exam.getStudents());
    assertNull(exam.getStartDateTime(null));
    assertNull(exam.getExamRoom(null));
    assertTrue(exam.validate());
  }

  @Test
  public void addNotExamRoom() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    exam.addRoom(LocalDateTime.of(2018, 7, 2, 8, 00), new Room("R1.006", 60));
    assertEquals(new HashSet<Room>(), exam.getExamRooms());
    assertTrue(exam.validate());
  }

  @Test
  public void addExamRoom() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(LocalDateTime.of(2018, 7, 2, 8, 00), r);
    HashSet<ExamRoom> rooms = new HashSet<>();
    rooms.add(r);
    assertEquals(rooms, exam.getExamRooms());
    assertFalse(exam.validate());
  }

  @Test
  public void addExamRoomAndNonExamRoom() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(LocalDateTime.of(2018, 7, 2, 8, 00), r);
    exam.addRoom(LocalDateTime.of(2018, 7, 2, 8, 15), new Room("R1.007", 50));
    HashSet<ExamRoom> rooms = new HashSet<>();
    rooms.add(r);
    assertEquals(rooms, exam.getExamRooms());
    assertFalse(exam.validate());
  }

  @Test
  public void addTwoExamRooms() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    ExamRoom s = new ExamRoom("R1.008", 50, 2);
    exam.addRoom(LocalDateTime.of(2018, 7, 2, 8, 00), r);
    exam.addRoom(LocalDateTime.of(2018, 7, 2, 8, 15), s);
    HashSet<ExamRoom> rooms = new HashSet<ExamRoom>();
    rooms.add(r);
    rooms.add(s);
    assertEquals(rooms, exam.getExamRooms());
    assertFalse(exam.validate());
  }

  @Test
  public void addAndRemoveExamRooms() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    ExamRoom s = new ExamRoom("R1.008", 50, 2);
    exam.addRoom(LocalDateTime.of(2018, 7, 10, 8, 30), r);
    exam.addRoom(LocalDateTime.of(2018, 7, 10, 8, 50), s);
    HashSet<ExamRoom> rooms = new HashSet<ExamRoom>();
    rooms.add(r);
    exam.removeRoom(LocalDateTime.of(2018, 7, 10, 8, 50));
    assertEquals(rooms, exam.getExamRooms());
    assertFalse(exam.validate());
  }

  @Test
  public void addStudent() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(t, r);
    Student s = new Student("Helge");
    exam.addStudent(t, s);
    HashSet<Student> studs = new HashSet<>();
    studs.add(s);
    assertEquals(studs, exam.getStudents());
    assertEquals(r, exam.getExamRoom(s));
    assertEquals(t, exam.getStartDateTime(s));
    assertTrue(exam.validate());
  }

  @Test
  public void addStudentWrongTime() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(LocalDateTime.of(2018, 7, 10, 8, 31), r);
    Student s = new Student("Helge");
    exam.addStudent(t, s);
    HashSet<Student> studs = new HashSet<>();
    studs.add(s);
    assertEquals(studs, exam.getStudents());
    assertEquals(null, exam.getExamRoom(s));
    assertEquals(t, exam.getStartDateTime(s));
    assertFalse(exam.validate());
  }

  @Test
  public void addTwoStudents() {
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t1 = LocalDateTime.of(2018, 7, 10, 8, 30);
    LocalDateTime t2 = LocalDateTime.of(2018, 7, 10, 8, 31);
    ExamRoom r1 = new ExamRoom("R1.006", 60, 2);
    ExamRoom r2 = new ExamRoom("R1.007", 60, 2);
    exam.addRoom(t1, r1);
    exam.addRoom(t2, r2);
    Student s1 = new Student("Helge");
    Student s2 = new Student("Helga");
    exam.addStudent(t1, s1);
    exam.addStudent(t2, s2);
    HashSet<Student> studs = new HashSet<>();
    studs.add(s1);
    studs.add(s2);
    assertEquals(studs, exam.getStudents());
    assertEquals(t1, exam.getStartDateTime(s1));
    assertEquals(t2, exam.getStartDateTime(s2));
    assertEquals(r1, exam.getExamRoom(s1));
    assertEquals(r2, exam.getExamRoom(s2));
    assertTrue(exam.validate());
  }

  @Test
  public void oralExamIsExam() {
    Exam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    assertEquals(90, exam.getDuration());
    assertEquals(Title.ProfDr + " " + "Oliver Braun", exam.getExaminer().toString());
    assertEquals(new HashSet<Room>(), exam.getExamRooms());
    assertEquals(new HashSet<Student>(), exam.getStudents());
    assertTrue(exam.validate());
  }
}
