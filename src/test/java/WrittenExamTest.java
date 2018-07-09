import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;
import org.junit.Test;

public class WrittenExamTest {

  @Test
  public void writtenExam() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    assertEquals(90, exam.getDuration());
    assertEquals(Title.ProfDr + " " + "Oliver Braun", exam.getExaminer().toString());
    assertNull(exam.getStartDateTime());
    assertEquals(new HashSet<Room>(), exam.getExamRooms());
    assertEquals(new HashSet<Student>(), exam.getStudents());
    assertFalse(exam.validate());
  }

  @Test
  public void writtenExamWithStartDate() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    assertEquals(t, exam.getStartDateTime());
    assertTrue(exam.validate());
  }

  @Test
  public void addNotExamRoom() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    exam.addRoom(new Room("R1.006", 60));
    assertEquals(new HashSet<Room>(), exam.getExamRooms());
    assertTrue(exam.validate());
  }

  @Test
  public void addExamRoom() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(r);
    HashSet<ExamRoom> rooms = new HashSet<ExamRoom>();
    rooms.add(r);
    assertEquals(rooms, exam.getExamRooms());
    assertTrue(exam.validate());
  }

  @Test
  public void addExamRoomAndNonExamRoom() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(r);
    exam.addRoom(new Room("R1.007", 50));
    HashSet<ExamRoom> rooms = new HashSet<ExamRoom>();
    rooms.add(r);
    assertEquals(rooms, exam.getExamRooms());
    assertTrue(exam.validate());
  }

  @Test
  public void addTwoExamRooms() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    ExamRoom s = new ExamRoom("R1.008", 50, 2);
    exam.addRoom(r);
    exam.addRoom(s);
    HashSet<ExamRoom> rooms = new HashSet<ExamRoom>();
    rooms.add(r);
    rooms.add(s);
    assertEquals(rooms, exam.getExamRooms());
    assertTrue(exam.validate());
  }

  @Test
  public void addAndRemoveExamRooms() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    ExamRoom s = new ExamRoom("R1.008", 50, 2);
    exam.addRoom(r);
    exam.addRoom(s);
    HashSet<ExamRoom> rooms = new HashSet<ExamRoom>();
    rooms.add(r);
    exam.removeRoom(s);
    assertEquals(rooms, exam.getExamRooms());
    assertTrue(exam.validate());
  }

  @Test
  public void addStudent() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(r);
    Student s = new Student("Helge");
    exam.addStudent(s);
    HashSet<Student> studs = new HashSet<>();
    studs.add(s);
    assertEquals(studs, exam.getStudents());
    assertTrue(exam.validate());
  }

  @Test
  public void addTwoStudents() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 2);
    exam.addRoom(r);
    Student s1 = new Student("Helge");
    Student s2 = new Student("Helga");
    exam.addStudent(s1);
    exam.addStudent(s2);
    HashSet<Student> studs = new HashSet<>();
    studs.add(s1);
    studs.add(s2);
    assertEquals(studs, exam.getStudents());
    assertTrue(exam.validate());
  }

  @Test
  public void addTwoStudentsRoomsTooSmall() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(r);
    Student s1 = new Student("Helge");
    Student s2 = new Student("Helga");
    exam.addStudent(s1);
    exam.addStudent(s2);
    HashSet<Student> studs = new HashSet<>();
    studs.add(s1);
    studs.add(s2);
    assertEquals(studs, exam.getStudents());
    assertFalse(exam.validate());
  }

  @Test
  public void addStudents() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 2);
    exam.addRoom(r);
    Student s1 = new Student("Helge");
    Student s2 = new Student("Helga");
    HashSet<Student> studs = new HashSet<>();
    studs.add(s1);
    studs.add(s2);
    exam.addStudents(studs);
    assertEquals(studs, exam.getStudents());
    assertTrue(exam.validate());
  }

  @Test
  public void addStudentsRoomTooSmall() {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(r);
    Student s1 = new Student("Helge");
    Student s2 = new Student("Helga");
    HashSet<Student> studs = new HashSet<>();
    studs.add(s1);
    studs.add(s2);
    exam.addStudents(studs);
    assertEquals(studs, exam.getStudents());
    assertFalse(exam.validate());
  }

  @Test
  public void writtenExamIsExam() {
    Exam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    assertEquals(90, exam.getDuration());
    assertEquals(Title.ProfDr + " " + "Oliver Braun", exam.getExaminer().toString());
    assertEquals(new HashSet<Room>(), exam.getExamRooms());
    assertEquals(new HashSet<Student>(), exam.getStudents());
    assertFalse(exam.validate());
  }
}
