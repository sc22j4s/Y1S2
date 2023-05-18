import java.util.List;
import java.util.Collections;

class Shoe {

  private List<Card> cards;
  private int deckCount;

  public Shoe(int decks) {

    // check for valid deck size
    if (decks != 6 && decks != 8) {
      throw new CardException(null);
    }

    // for method size()
    deckCount = decks;

    // adding decks to card list
    Card.Rank rank;
    Card.Suit suit;

    for (int i = 0; i < decks; i++) {
      // add each card per deck to the shoe
      for (int j = 0; j < 4; j++) {
        suit = Card.Suit.values()[j];
        System.out.println(suit);

        // for each suit add each rank of card
        for (int k = 0; k < 13; k++) {
          System.out.println(k);

          rank = Card.Rank.values()[k];
          System.out.println(rank);

          BaccaratCard tmp = new BaccaratCard(rank, suit);
          System.out.println(tmp);
          // cards.add(tmp);
        }
      }

    }
  }

  public int size() {
    // number of cards in shoe
    return deckCount * 52;
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public Card deal() {

    // handle empty shoe
    if (cards.size() == 0) {
      throw new CardException(null);
    } else {
      return cards.remove(0);
    }

  }
}
