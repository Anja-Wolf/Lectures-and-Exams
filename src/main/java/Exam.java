import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

/**
 * Interface für Exam.
 * 
 * @author anjawolf
 * @version 1.0
 */

public interface Exam {

  int getDuration();

  Lecturer getExaminer();

  Set<Room> getExamRooms();

  Set<Student> getStudents();

  boolean validate();

  Map<Student, LocalDateTime> getStudentTime();

  LocalDateTime getStartDateTimes();

  Map<LocalDateTime, Room> getRoomsTime();

}
