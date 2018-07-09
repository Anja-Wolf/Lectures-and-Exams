
/**
 * @author anjawolf
 * @version 1.0
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Lecture {

  private String lectureName;
  Lecturer lecturer;
  Room room;
  Set<Group> groups;
  Examtype examtype;
  Set<Student> students;
  Exam exam;
  LocalDateTime startDateTime;

  /**
   * Konstruktor für Prof.
   * 
   * @param lecturename Vorlesungsname
   * @param lecturer Profname
   * @param room Raum
   * @param groups Welcher Veranstaltung diese Vorl. angehoert
   * @param examtype schriftlich oder muendlich
   */
  Lecture(final String lecturename, final Lecturer lecturer, final Room room,
      final Set<Group> groups, final Examtype examtype) {
    this.lectureName = lecturename;
    this.lecturer = lecturer;
    this.room = room;
    this.groups = groups;
    this.examtype = examtype;
    this.exam = null;
    this.students = new HashSet<>();
  }

  /**
   * Einen Student hinzufuegen.
   *
   * @param students Student der Klasse Student
   */
  public void addStudents(final Set<Student> students) {
    for (Student k : students) {
      this.students.add(k);
    }
  }

  /**
   * Setter Klausur.
   *
   * @param exam Klausur
   * @return ob Klausur wahr oder nicht
   */
  public boolean setExam(final Exam exam) {
    if (((exam instanceof WrittenExam) && this.examtype.equals(examtype.Written))
        || ((exam instanceof OralExam) && this.examtype.equals(examtype.Oral))) {
      this.exam = exam;
      return true;
    }
    return false;
  }

  /**
   * Getter Starttermin der Klausur aus.
   *
   * @param student Student Variable
   * @return gibt Starttermin wieder
   */
  public LocalDateTime getStartDateTime(final Student student) {
    Student a = null;
    if (this.exam instanceof OralExam) {
      for (Student k : this.exam.getStudentTime().keySet()) {
        if (k.equals(student)) {
          a = k;
          break;
        }
      }
      return this.exam.getStudentTime().get(a);
    } else {
      return this.exam.getStartDateTimes();
    }
  }

  /**
   * Methode um Klasse fuer Pruefungsraeume auszugeben.
   *
   * @param student Variable fuer Student
   * @return gibt Set mit den Rauumen wieder
   */
  public Set<Room> getExamRooms(final Student student) {
    if (this.examtype.equals(examtype.Oral)) {
      LocalDateTime a = null;
      for (LocalDateTime k : this.exam.getRoomsTime().keySet()) {
        if (k.isEqual(this.exam.getStudentTime().get(student))) {
          a = k;
        }
      }
      Set<Room> help = new HashSet<Room>();
      help.add(this.exam.getRoomsTime().get(a));
      return help;
    } else {
      return this.exam.getExamRooms();
    }
  }

  /**
   * Methode um zu pruefen ob Pruefung durchfuehrbar.
   *
   * @return gibt Wahrheitswert zurueck
   */
  public boolean validate() {
    if (this.students.size() <= this.room.getSeats()) {
      if (this.exam != null) {
        if (this.exam.validate()) {
          return true;
        } else {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  /**
   * Resetet Klausur.
   *
   * @return resetet eine Klausur
   */
  public Exam resetExam() {
    Exam help = this.exam;
    this.exam = null;
    return help;
  }

  /**
   * Getter Prof zurueck.
   * 
   * @return Prof
   */
  public Lecturer getLecturer() {
    return this.lecturer;
  }

  /**
   * Getter Raum zurueck.
   * 
   * @return Raum
   */
  public Room getRoom() {
    return this.room;
  }

  /**
   * Gibt zurueck welche Vorlesung der Prof haelt.
   * 
   * @return Vorlesungen als Set
   */
  public Set<Group> getGroups() {
    return this.groups;
  }

  /**
   * gibt Studenten als Set zurueck die diese Vorlesung besuche.
   * 
   * @return Studenten
   */
  public Set<Student> getStudents() {
    return this.students;
  }

  /**
   * gibt Vorlesungsname zurueck.
   * 
   * @return Vorlesungsname
   */
  public String getLectureName() {
    return this.lectureName;
  }
}
