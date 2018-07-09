import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Klasse fuer schriftliche Prüfung.
 * 
 * @author anjawolf
 * @version 1.0
 */
public class WrittenExam implements Exam {
  private final int duration;
  private final Lecturer lecturer;
  private LocalDateTime startDateTime;
  private Room room;
  HashSet<Student> students = new HashSet<>();
  HashSet examrooms = new HashSet<ExamRoom>();
  private final Map<LocalDateTime, Room> rooms = new HashMap<>();

  WrittenExam(final int duration, final Lecturer examiner) {
    this.duration = duration;
    this.lecturer = examiner;
  }

  @Override
  public Map<LocalDateTime, Room> getRoomsTime() {
    return this.rooms;
  }

  public Room getExamRoom(final Student student) {
    System.out.print("test");
    return this.room;
  }

  @Override
  public Map<Student, LocalDateTime> getStudentTime() {
    final Map<Student, LocalDateTime> startDateTimes = new HashMap<>();
    return startDateTimes;
  }

  public LocalDateTime getStartDateTimes() {
    return this.startDateTime;
  }

  public LocalDateTime getStartDateTime() {
    return this.startDateTime;
  }

  public void addStudent(final Student student) {
    this.students.add(student);
  }

  /**
   * Methode um Student hinzuzufügen.
   * 
   * @param students Variable für Student
   */
  public void addStudents(final Set<Student> students) {
    for (Student k : students) {
      this.students.add(k);
    }
  }

  /**
   * Methode um Raum hinzuzufügen.
   * 
   * @param room Variable für Raum
   */
  public void addRoom(final Room room) {
    if (room instanceof ExamRoom) {
      this.examrooms.add(room);
      this.room = room;
    }
  }

  /**
   * Methode um Raum zu entfernen.
   * 
   * @param room Variable für Raum
   */
  public void removeRoom(final Room room) {
    if (room instanceof ExamRoom) {
      examrooms.remove(room);
    }
  }

  /**
   * setzt das Starttermin der Prüfung.
   * 
   * @param t Startzeit
   */
  public void setStartDateTime(LocalDateTime t) {
    this.startDateTime = t;
  }

  /**
   * gibt alle Studenten der Prüfung zurueck.
   * 
   * @return
   */
  @Override
  public Set<Student> getStudents() {
    return this.students;
  }

  /**
   * gibt die Prüfer zurueck.
   * 
   * @return Prüfer
   */
  @Override
  public Lecturer getExaminer() {
    return this.lecturer;
  }

  /**
   * gibt alle Prüfungsräume zurueck.
   * 
   * @return Prüfungsräume
   */
  @Override
  public Set<Room> getExamRooms() {
    return this.examrooms;
  }

  /**
   * ueberprueft ob Prüfung richtig ist.
   * 
   * @return gibt boolean zurueck
   */
  @Override
  public boolean validate() {
    int seats = 0;
    for (Object k : examrooms) {
      seats = seats + ((ExamRoom) k).getSeatsForExam();
    }
    if ((this.startDateTime != null) && (this.lecturer != null)
        && (this.students.size() <= seats)) {
      return true;
    }
    return false;
  }

  /**
   * gibt die Dauer der Prüfung aus.
   * 
   * @return Dauer als int
   */
  @Override
  public int getDuration() {
    return this.duration;
  }
}
