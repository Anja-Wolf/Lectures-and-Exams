/**
 * Klasse für Raum.
 * @author anjawolf
 * @version 1.0
 */

public class Room {
  final String name;
  final int seats;

  /**
   * Custom Konstrukor um neuen Raum zu erstellen.
   * @param name Name des Raums
   * @param seats Anzahl Sitze
   */
  public Room(final String name, final int seats) {
    this.name = name;
    this.seats = seats;
  }

  /**
   * Getter für Name/Sitzanzahl des Raumes.
   * 
   * @return Name bzw. Sitzanzahl
   */

  public String getName() {
    return this.name;
  }

  public int getSeats() {
    return this.seats;
  }

  /**
   * Redefinieren der Methode equals; ist gleich wenn Name des Raums gleich ist.
   * 
   * @param other Object das verglichen werden soll
   * @return boolean true oder false ob Räume übereinstimmen
   */

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Room)) {
      return false;
    }
    Room r = (Room) other;
    return (r.getName() == this.getName());
  }

  /**
   * Redefinieren der Mehtode hashCode.
   * 
   * @return int HashCode
   */
  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + name.hashCode();
    return result;
  }
}
