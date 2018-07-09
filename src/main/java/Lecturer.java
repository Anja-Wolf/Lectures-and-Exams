/**
 * Klasse Lecturer (erweitert Person).
 * 
 * @author anjawolf
 * @version 1.0
 */

class Lecturer extends Person {
  private Title title;

  /**
   * Konstruktor fuer Prof.
   * @param name Profname
   */
  public Lecturer(final String name) {
    super(name);
    this.title = null;
  }

  /**
   * weiterer Konstruktor fuer Prof.
   * @param title Anrede
   * @param name Profname
   */
  public Lecturer(final Title title, final String name) {
    this(name);
    this.title = title;
  }

  /**
   * setzt die Anrede des Prof.
   * @param title Anrede
   */
  public void setTitle(final Title title) {
    this.title = title;
  }

  /**
   * ueberschreibt die toString Methode.
   * @return gibt String zurueck
   */
  @Override
  public String toString() {
    if (this.title == null) {
      return super.toString();
    }
    return this.title + " " + super.toString();
  }
}
