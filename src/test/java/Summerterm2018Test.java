import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class Summerterm2018Test {

  @Test
  public void seiiib() {
    Lecture lecture = Summerterm2018.seiiib;
    assertTrue(lecture.validate());
    assertEquals("Softwareentwicklung II (IB)", lecture.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", lecture.getLecturer().toString());
    assertEquals("R1.006", lecture.getRoom().getName());
    assertEquals(60, lecture.getRoom().getSeats());
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IB);
    assertEquals(groups, lecture.getGroups());
    Set<String> studentNames = new HashSet<>();
    studentNames.add("Helga Meier");
    studentNames.add("Helge Mayer");
    assertTrue(
        lecture
            .getStudents()
            .stream()
            .map(s -> studentNames.contains(s.getName()))
            .reduce(true, (a, b) -> a && b));
    WrittenExam exam = (WrittenExam) lecture.resetExam();
    assertEquals(90, exam.getDuration());
    assertEquals("Prof. Dr. Oliver Braun", exam.getExaminer().toString());
    assertEquals(LocalDateTime.of(2018, 7, 10, 10, 30), exam.getStartDateTime());
    Set<Room> examRooms = new HashSet<>();
    examRooms.add(new ExamRoom("R1.046", 120, 57));
    assertEquals(examRooms, exam.getExamRooms());
    assertTrue(
        exam.getStudents()
            .stream()
            .map(s -> studentNames.contains(s.getName()))
            .reduce(true, (a, b) -> a && b));
  }

  @Test
  public void algdatii() {
    Lecture lecture = Summerterm2018.algdatii;
    assertTrue(lecture.validate());
    assertEquals("Algorithmen und Datenstrukturen II", lecture.getLectureName());
    assertEquals("Prof. Dr. Oliver Braun", lecture.getLecturer().toString());
    assertEquals("R0.010", lecture.getRoom().getName());
    assertEquals(40, lecture.getRoom().getSeats());
    Set<Group> groups = new HashSet<>();
    groups.add(Group.IC);
    groups.add(Group.IF);
    assertEquals(groups, lecture.getGroups());
    Set<String> studentNames = new HashSet<>();
    studentNames.add("Christa Schmidt");
    studentNames.add("Christoph Schmitt");
    assertTrue(
        lecture
            .getStudents()
            .stream()
            .map(s -> studentNames.contains(s.getName()))
            .reduce(true, (a, b) -> a && b));
    OralExam exam = (OralExam) lecture.resetExam();
    assertEquals(15, exam.getDuration());
    assertEquals("Prof. Dr. Oliver Braun", exam.getExaminer().toString());
    assertTrue(
        exam.getStudents()
            .stream()
            .map(s -> studentNames.contains(s.getName()))
            .reduce(true, (a, b) -> a && b));
    for (Student s: exam.getStudents()) {
      if (s.getName().equals("Christa Schmidt")) {
        assertEquals(LocalDateTime.of(2018, 7, 3, 8, 0), exam.getStartDateTime(s));
      }
      if (s.getName().equals("Christoph Schmitt")) {
        assertEquals(LocalDateTime.of(2018, 7, 3, 8, 20), exam.getStartDateTime(s));
      }
    }
    Set<Room> examRooms = new HashSet<>();
    examRooms.add(new ExamRoom("R3.013", 120, 57));
    assertEquals(examRooms, exam.getExamRooms());
  }
}
