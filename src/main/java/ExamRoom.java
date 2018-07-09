/**
 * Klasse für ExamRoom (erweitert Room).
 * @author anjawolf
 * @version 1.0
 */

class ExamRoom extends Room {
  private int seatsForExam;

  /**
   * Custome Konstruktor.
   * @param name Raum-Name
   * @param seats Anzahl Sitzplätze Raum
   * @param seatsForExam Anzahl Sitzplätze Exam
   */
  public ExamRoom(final String name, final int seats, final int seatsForExam) {
    super(name, seats);
    this.seatsForExam = seatsForExam;
  }
  
  /**
   * weiterer Custom Konstruktor.
   * @param room Raum
   * @param seatsForExam Anzahl Sitzplätze Exam
   */

  public ExamRoom(final Room room, final int seatsForExam) {
    this(room.name, room.seats, seatsForExam);
  }
  
  /**
   * Getter für SeatsforExam.
   * @return Anzahl Sitzplätze Exam
   */

  public int getSeatsForExam() {
    return this.seatsForExam;
  }
}
