/**
 * Klasse um Student zu erstellen.
 * 
 * @author anjawolf
 * @version 1.0
 */

class Student extends Person {
  private static int hilfe = 1000000;
  private int matrikel;

  /**
   * Konstruktor für Student.
   * 
   * @param name Name als String
   */
  Student(String name) {
    super(name);
    this.matrikel = hilfe;
    hilfe++;
  }

  /**
   * gibt Matr.Nr. aus.
   * 
   * @return MatrNr als int
   */
  public int getMatrikel() {
    return this.matrikel;
  }
}
