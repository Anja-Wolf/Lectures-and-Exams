/**
 * Enum für Titel.
 * 
 * @author anjawolf
 * @version 1.0
 */

enum Title {
  Dr("Dr."), Prof("Prof."), ProfDr("Prof. Dr.");

  private String title;

  /**
   * Konstruktor für title.
   * 
   * @param title Vorlesungstitel
   */
  Title(String title) {
    this.title = title;
  }

  /**
   * überschreibt toString Methode.
   * 
   * @return gibt String aus
   */
  @Override
  public String toString() {
    return this.title;
  }
}
