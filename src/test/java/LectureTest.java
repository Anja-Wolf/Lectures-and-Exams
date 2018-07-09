import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class LectureTest {

  @Test
  public void lecture() {
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    groups.add(Group.IC);
    groups.add(Group.IF);
    Lecture l =
        new Lecture(
            "Funktionale Programmierung",
            new Lecturer(Title.ProfDr, "Oliver Braun"),
            new Room("R1.007", 50),
            groups,
            Examtype.Written);
    assertEquals("Funktionale Programmierung", l.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", l.getLecturer().toString());
    assertEquals(new Room("R1.007", 50), l.getRoom());
    assertEquals(groups, l.getGroups());
    assertEquals(new HashSet<Student>(), l.getStudents());
    assertNull(l.resetExam());
    assertTrue(l.validate());
  }

  @Test
  public void lectureWithStudents() {
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    groups.add(Group.IC);
    groups.add(Group.IF);
    Lecture l =
        new Lecture(
            "Funktionale Programmierung",
            new Lecturer(Title.ProfDr, "Oliver Braun"),
            new Room("R1.007", 50),
            groups,
            Examtype.Written);
    assertEquals("Funktionale Programmierung", l.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", l.getLecturer().toString());
    assertEquals(new Room("R1.007", 50), l.getRoom());
    assertEquals(groups, l.getGroups());
    Set<Student> studs = new HashSet<>();
    studs.add(new Student("Holger"));
    studs.add(new Student("Hilma"));
    studs.add(new Student("Wilma"));
    studs.add(new Student("Wolger"));
    l.addStudents(studs);
    assertEquals(studs, l.getStudents());
    assertNull(l.resetExam());
    assertTrue(l.validate());
  }

  @Test
  public void lectureWithStudentsRoomToSmall() {
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    groups.add(Group.IC);
    groups.add(Group.IF);
    Lecture l =
        new Lecture(
            "Funktionale Programmierung",
            new Lecturer(Title.ProfDr, "Oliver Braun"),
            new Room("R1.007", 2),
            groups,
            Examtype.Written);
    assertEquals("Funktionale Programmierung", l.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", l.getLecturer().toString());
    assertEquals(new Room("R1.007", 2), l.getRoom());
    assertEquals(groups, l.getGroups());
    Set<Student> studs = new HashSet<>();
    studs.add(new Student("Holger"));
    studs.add(new Student("Hilma"));
    studs.add(new Student("Wilma"));
    studs.add(new Student("Wolger"));
    l.addStudents(studs);
    assertEquals(studs, l.getStudents());
    assertNull(l.resetExam());
    assertFalse(l.validate());
  }

  @Test
  public void lectureWithWrongExam() {
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    groups.add(Group.IC);
    groups.add(Group.IF);
    Lecture l =
        new Lecture(
            "Funktionale Programmierung",
            new Lecturer(Title.ProfDr, "Oliver Braun"),
            new Room("R1.007", 2),
            groups,
            Examtype.Written);
    assertEquals("Funktionale Programmierung", l.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", l.getLecturer().toString());
    assertEquals(new Room("R1.007", 6), l.getRoom());
    assertEquals(groups, l.getGroups());
    Set<Student> studs = new HashSet<>();
    studs.add(new Student("Holger"));
    studs.add(new Student("Hilma"));
    studs.add(new Student("Wilma"));
    studs.add(new Student("Wolger"));
    l.addStudents(studs);
    assertEquals(studs, l.getStudents());
    assertFalse(l.setExam(new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"))));
    assertNull(l.resetExam());
    assertFalse(l.validate());
  }

  @Test
  public void lectureWithExam() {
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    groups.add(Group.IC);
    groups.add(Group.IF);
    Lecture l =
        new Lecture(
            "Funktionale Programmierung",
            new Lecturer(Title.ProfDr, "Oliver Braun"),
            new Room("R1.007", 6),
            groups,
            Examtype.Written);
    assertEquals("Funktionale Programmierung", l.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", l.getLecturer().toString());
    assertEquals(new Room("R1.007", 6), l.getRoom());
    assertEquals(groups, l.getGroups());
    Set<Student> studs = new HashSet<>();
    studs.add(new Student("Holger"));
    studs.add(new Student("Hilma"));
    studs.add(new Student("Wilma"));
    studs.add(new Student("Wolger"));
    l.addStudents(studs);
    assertEquals(studs, l.getStudents());
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 8);
    exam.addRoom(r);
    Student s1 = new Student("Helge");
    Student s2 = new Student("Helga");
    HashSet<Student> studsE = new HashSet<>();
    studsE.add(s1);
    studsE.add(s2);
    exam.addStudents(studsE);
    assertTrue(l.setExam(exam));
    assertEquals(t, l.getStartDateTime(s1));
    assertEquals(t, l.getStartDateTime(s2));
    Set<ExamRoom> rs = new HashSet<>();
    rs.add(r);
    assertEquals(rs, l.getExamRooms(s1));
    assertEquals(rs, l.getExamRooms(s2));
    assertTrue(l.validate());
    assertEquals(exam, l.resetExam());
    assertNull(l.resetExam());
    assertTrue(l.validate());
  }

  @Test
  public void lectureWithExamRoomTooSmall() {
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    groups.add(Group.IC);
    groups.add(Group.IF);
    Lecture l =
        new Lecture(
            "Funktionale Programmierung",
            new Lecturer(Title.ProfDr, "Oliver Braun"),
            new Room("R1.007", 6),
            groups,
            Examtype.Written);
    assertEquals("Funktionale Programmierung", l.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", l.getLecturer().toString());
    assertEquals(new Room("R1.007", 6), l.getRoom());
    assertEquals(groups, l.getGroups());
    Set<Student> studs = new HashSet<>();
    studs.add(new Student("Holger"));
    studs.add(new Student("Hilma"));
    studs.add(new Student("Wilma"));
    studs.add(new Student("Wolger"));
    l.addStudents(studs);
    assertEquals(studs, l.getStudents());
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t = LocalDateTime.of(2018, 7, 10, 8, 30);
    exam.setStartDateTime(t);
    ExamRoom r = new ExamRoom("R1.006", 60, 1);
    exam.addRoom(r);
    Student s1 = new Student("Helge");
    Student s2 = new Student("Helga");
    HashSet<Student> studsE = new HashSet<>();
    studsE.add(s1);
    studsE.add(s2);
    exam.addStudents(studsE);
    assertTrue(l.setExam(exam));
    assertEquals(t, l.getStartDateTime(s1));
    assertEquals(t, l.getStartDateTime(s2));
    Set<ExamRoom> rs = new HashSet<>();
    rs.add(r);
    assertEquals(rs, l.getExamRooms(s1));
    assertEquals(rs, l.getExamRooms(s2));
    assertFalse(l.validate());
    assertFalse(l.resetExam().validate());
  }

  @Test
  public void lectureWithOralExamWrong() {
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    groups.add(Group.IC);
    groups.add(Group.IF);
    Lecture l =
        new Lecture(
            "Funktionale Programmierung",
            new Lecturer(Title.ProfDr, "Oliver Braun"),
            new Room("R1.007", 6),
            groups,
            Examtype.Oral);
    assertEquals("Funktionale Programmierung", l.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", l.getLecturer().toString());
    assertEquals(new Room("R1.007", 6), l.getRoom());
    assertEquals(groups, l.getGroups());
    Set<Student> studs = new HashSet<>();
    studs.add(new Student("Holger"));
    studs.add(new Student("Hilma"));
    studs.add(new Student("Wilma"));
    studs.add(new Student("Wolger"));
    l.addStudents(studs);
    assertEquals(studs, l.getStudents());
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    assertFalse(l.setExam(exam));
    assertNull(l.resetExam());
  }

  @Test
  public void lectureWithOralExam() {
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    groups.add(Group.IC);
    groups.add(Group.IF);
    Lecture l =
        new Lecture(
            "Funktionale Programmierung",
            new Lecturer(Title.ProfDr, "Oliver Braun"),
            new Room("R1.007", 6),
            groups,
            Examtype.Oral);
    assertEquals("Funktionale Programmierung", l.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", l.getLecturer().toString());
    assertEquals(new Room("R1.007", 6), l.getRoom());
    assertEquals(groups, l.getGroups());
    Set<Student> studs = new HashSet<>();
    studs.add(new Student("Holger"));
    studs.add(new Student("Hilma"));
    studs.add(new Student("Wilma"));
    studs.add(new Student("Wolger"));
    l.addStudents(studs);
    assertEquals(studs, l.getStudents());
    OralExam exam = new OralExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    LocalDateTime t1 = LocalDateTime.of(2018, 7, 10, 8, 30);
    LocalDateTime t2 = LocalDateTime.of(2018, 7, 10, 8, 31);
    ExamRoom r1 = new ExamRoom("R1.006", 60, 2);
    ExamRoom r2 = new ExamRoom("R1.007", 60, 2);
    exam.addRoom(t1,r1);
    exam.addRoom(t2,r2);
    Student s1 = new Student("Helge");
    Student s2 = new Student("Helga");
    exam.addStudent(t1, s1);
    exam.addStudent(t2, s2);
    Set<ExamRoom> r1s = new HashSet<>();
    r1s.add(r1);
    Set<ExamRoom> r2s = new HashSet<>();
    r2s.add(r2);
    assertTrue(l.setExam(exam));
    assertEquals(t1, l.getStartDateTime(s1));
    assertEquals(t2, l.getStartDateTime(s2));
    assertEquals(r1s, l.getExamRooms(s1));
    assertEquals(r2s, l.getExamRooms(s2));
    assertTrue(exam.validate());
    assertTrue(l.validate());
  }
}
