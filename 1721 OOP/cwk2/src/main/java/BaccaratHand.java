// TODO: Implement the BaccaratHand class in the file

// subclass of CardCollection
public class BaccaratHand extends CardCollection {

    public BaccaratHand() {
      super();
    }
  
    public int size() {
      return super.size();
    }
  
    public void add(Card card) {
      super.add(card);
    }
  
    public int value() {
  
      int sum = 0;
  
      // iterate through each Card instance
      for (Card card : cards) {
        // cards originally valued at 10 by superclass method are invalid in Baccarat
        if (card.value() != 10) {
          // other cards are valid
          sum += card.value();
        }
      }
      // modulo 10 applied when totalling cards in game
      return sum % 10;
    }
  
    public boolean isNatural() {
      if (cards.size() == 2 && (this.value() == 8 || this.value() == 9)) {
        return true;
  
      }
      return false;
    }
  
    public String toString() {
  
      String s = "";
  
      // superclass method checks if empty
      if (cards.isEmpty()) {
        return s;
      }
  
      // append string format using superclass method
      // and space inbetween cards
      for (int i = 0; i < cards.size(); i++) {
        s += cards.get(i).toString() + " ";
      }
      // removal of extra whitespace at end of string
      s = s.substring(0, s.length() - 1);
      return s;
    }
  }
  