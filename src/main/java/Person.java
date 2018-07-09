/**
 * Klasse Person für Erstellen einer neuen Person.
 * 
 * @author anjawolf
 * @version 1.0
 */

public class Person {

  String name;

  /**
   * Custom Konstruktor für Class Person.
   * @param name Name der Person
   */

  public Person(String name) {
    this.name = name;
  }

  /**
   * Getter für Variable name.
   * 
   * @return Variable name
   */

  public String getName() {
    return this.name;
  }

  /**
   * Redefinieren der Methode toString um auch hier Namen zurückzugeben.
   * 
   * @return String Name
   */

  @Override
  public String toString() {
    return this.name;
  }

}
