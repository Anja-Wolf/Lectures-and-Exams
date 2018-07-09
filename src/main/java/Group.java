import java.util.HashSet;
import java.util.Set;

/**
 * Enum Group.
 * @author anjawolf
 * @version 1.0
 */

public enum Group {
  IB("Wirtschaftsinformatik"), IC("Scientific Computing"), IF("Informatik"), IG("Informatik"), IN(
      "Wirtschaftsinformatik"), IS("Stochastic Engineering");

  private String longname;
  private boolean bachelor;

  /**
   * Konstruktor für Group.
   *
   * @param longname Name des Kurses
   */
  Group(String longname) {
    this.longname = longname;
  }

  /**
   * Boolean ob Bachelor Kurs oder nicht.
   *
   * @return boolean
   */
  public boolean getbachelor() {
    return this.bachelor;
  }

  /**
   * Überprueft ob es ein Bachelorkurs ist.
   *
   * @return boolean
   */
  public boolean isBachelor() {
    if ((this.equals(Group.IB)) || (this.equals(Group.IC)) || (this.equals(Group.IF))) {
      return true;
    }
    return false;
  }

  /**
   * Überprueft ob es ein Masterkurs ist.
   *
   * @return boolean
   */
  public boolean isMaster() {
    if ((this.equals(Group.IG)) || (this.equals(Group.IN)) || (this.equals(Group.IS))) {
      this.bachelor = false;
      return true;
    }
    this.bachelor = true;
    return false;
  }

  /**
   * Override toString-Methode.
   *
   * @return gibt einen String aus
   */
  @Override
  public String toString() {
    if (this.isBachelor()) {
      return this.longname + " (Bachelor)";
    }
    return this.longname + " (Master)";
  }

  /**
   * Alle Bachelorkurse in ein Set.
   *
   * @return gibt Set aus
   */
  public static Set<Group> getBachelors() {
    Set<Group> bachelors = new HashSet<>();
    for (Group g : Group.values()) {
      if (g.isBachelor()) {
        bachelors.add(g);
      }
    }
    return bachelors;
  }

  /**
   * Alle Masterkurse in en Set.
   *
   * @return gibt Set aus
   */
  public static Set<Group> getMasters() {
    Set<Group> masters = new HashSet<>();
    masters.add(IG);
    masters.add(IN);
    masters.add(IS);
    return masters;
  }
}
