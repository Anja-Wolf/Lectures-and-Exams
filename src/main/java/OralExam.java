import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Klasse fuer muendliche Pruefung.
 * 
 * @author anjawolf
 * @version 1.0
 */
public class OralExam implements Exam {
  private final Map<Student, LocalDateTime> startDateTimes = new HashMap<>();
  private final Map<LocalDateTime, Room> rooms = new HashMap<>();
  private final Lecturer lecturer;
  private final int duration;
  private LocalDateTime startDateTime;

  /**
   * Konstruktor fuer OralExam.
   * 
   * @param duration Dauer
   * @param examiner Pruefer
   */
  public OralExam(final int duration, final Lecturer examiner) {
    this.lecturer = examiner;
    this.duration = duration;
  }

  /**
   * gibt Prüfungsstart aus.
   * 
   * @param student Student der Klasse Student
   * @return gibt Prüfungsstart aus
   */
  public LocalDateTime getStartDateTime(final Student student) {
    if (startDateTimes.containsKey(student)) {
      return startDateTimes.get(student);
    }
    return null;
  }

  /**
   * gibt Startdatum zurueck.
   * 
   * @return Startdatum
   */
  public LocalDateTime getStartDateTimes() {
    return this.startDateTime;
  }

  /**
   * gibt den Prüfungsraum aus.
   * 
   * @param student Student der Klasse Student
   * @return gibt den Prüfungsraum aus
   */
  public Room getExamRoom(final Student student) {
    if (startDateTimes.containsKey(student)) {
      return rooms.get(startDateTimes.get(student));
    }
    return null;
  }

  /**
   * fuegt Student hinzu.
   * 
   * @param localDateTime Startdatum
   * @param student Student
   */
  public void addStudent(final LocalDateTime localDateTime, final Student student) {
    startDateTimes.put(student, localDateTime);
    this.startDateTime = localDateTime;
  }

  /**
   * fuegt einen Raum hinzu.
   * 
   * @param localDateTime setzt die Zeit
   * @param room setzt den Raum
   */
  public void addRoom(final LocalDateTime localDateTime, final Room room) {
    if (room instanceof ExamRoom) {
      rooms.put(localDateTime, room);
      this.startDateTime = localDateTime;
    }
  }

  /**
   * loescht einen Raum.
   * 
   * @param localDateTime Startdatum
   * @return gibt Raum zurueck
   */
  public Room removeRoom(final LocalDateTime localDateTime) {
    return rooms.remove(localDateTime);
  }

  /**
   * ueberschreibt Methode validate.
   * 
   * @return gibt boolean zurueck
   */
  @Override
  public boolean validate() {
    if (this.lecturer != null) {
      for (LocalDateTime k : this.rooms.keySet()) {
        if (!this.startDateTimes.containsValue(k)) {
          return false;
        }
      }
      for (LocalDateTime a : this.startDateTimes.values()) {
        if (!this.rooms.containsKey(a)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * ueberschreibt Methode getStudents.
   * 
   * @return Studenten
   */
  @Override
  public Set<Student> getStudents() {
    Set<Student> students = new HashSet<Student>();
    for (Student k : startDateTimes.keySet()) {
      students.add(k);
    }
    return students;
  }

  /**
   * ueberschreibt Methode getExaminer.
   * 
   * @return gibt Pruefer zurueck
   */
  @Override
  public Lecturer getExaminer() {
    return this.lecturer;
  }

  /**
   * ueberschreibt Methode getExamRooms.
   * 
   * @return gibt Raeume aus
   */
  @Override
  public Set<Room> getExamRooms() {
    Set<Room> examrooms = new HashSet<Room>();
    for (Room k : rooms.values()) {
      examrooms.add(k);
    }
    return examrooms;
  }

  /**
   * ueberschreibt Methode getDuration.
   * 
   * @return gibt Dauer aus
   */
  @Override
  public int getDuration() {
    return this.duration;
  }

  /**
   * ueberschreibt getStudentTime Methode.
   * 
   * @return gibt Startdatum zurueck
   */
  @Override
  public Map<Student, LocalDateTime> getStudentTime() {
    return this.startDateTimes;
  }

  /**
   * ueberschreibt getRoomsTime Methode.
   * 
   * @return gibt Raeume zurueck
   */
  @Override
  public Map<LocalDateTime, Room> getRoomsTime() {
    return this.rooms;
  }
}
