public class BaccaratCard extends Card {

    public BaccaratCard(Rank r, Suit s) {
      super(r, s);
    }
  
    public BaccaratCard(String name) {
      super(name);
    }
  
    public Rank getRank() {
      return super.getRank();
    }
  
    public Suit getSuit() {
      return super.getSuit();
    }
  
    public String toString() {
      return super.toString();
    }
  
    public boolean equals(Object thing) {
      return super.equals(thing);
    }
  
    public int compareTo(Card other) {
      return super.compareTo(other);
    }
  
    /**
     * Returns value of card in Baccarat game.
     * Ranks of Ace, 10, Jack, Queen, and King have a score of zero
     * 
     */
    public int value() {
      if (this.getRank().ordinal() > 8) {
        return 0;
      } else {
        return super.value();
      }
  
    }
  
  }
  