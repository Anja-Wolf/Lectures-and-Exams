import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasse für Sommersemester.
 * 
 * @author anjawolf
 * @version 1.0
 */
public class Summerterm2018 {

  private static HashSet<Group> seib() {
    HashSet<Group> seib = new HashSet<Group>();
    seib.add(Group.IB);
    return seib;
  }

  public static Lecture seiiib = new Lecture("Softwareentwicklung II (IB)",
      new Lecturer(Title.ProfDr, "Oliver Braun"), new Room("R1.006", 60), seib(), Examtype.Written);

  static {
    WrittenExam exam = new WrittenExam(90, new Lecturer(Title.ProfDr, "Oliver Braun"));
    seiiib.setExam(exam);
    exam.setStartDateTime(LocalDateTime.of(2018, 7, 10, 10, 30));
    exam.addRoom(new ExamRoom("R1.046", 120, 57));
  }

  private static HashSet<Group> algdati() {
    HashSet<Group> alg = new HashSet<Group>();
    alg.add(Group.IC);
    alg.add(Group.IF);
    return alg;
  }

  public static Lecture algdatii = new Lecture("Algorithmen und Datenstrukturen II",
      new Lecturer(Title.ProfDr, "Oliver Braun"), new Room("R0.010", 40), algdati(), Examtype.Oral);

  static {
    OralExam exam = new OralExam(15, new Lecturer(Title.ProfDr, "Oliver Braun"));
    algdatii.setExam(exam);
    LocalDateTime a = LocalDateTime.of(2018, 7, 3, 8, 00);
    LocalDateTime b = LocalDateTime.of(2018, 7, 3, 8, 20);
    exam.addStudent(b, new Student("Christoph Schmitt"));
    exam.addStudent(a, new Student("Christa Schmidt"));
    exam.addRoom(a, new ExamRoom("R3.013", 10, 5));
    exam.addRoom(b, new ExamRoom("R3.013", 10, 5));
    System.out.print(exam.getStudents());
  }
}
