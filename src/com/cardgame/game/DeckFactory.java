package com.cardgame.game;

import com.cardgame.model.Deck;
import com.cardgame.model.NormalDeck;
import com.cardgame.model.SmallDeck;
import com.cardgame.model.TestDeck;

public class DeckFactory {
    /*
    * we need a way of indicating specific deck types.
    * We can do that with an enumeration.
    * */
    public enum DeckType {
        Normal,
        Small,
        Test  //Test deck that will only make one specific card a bunch of times.
    };

    /*
    * Static method that takes the type of deck to create as a parameter.
    * Then based on the type asked for, creates the correct type of deck.
    * */
    public static Deck makeDeck(DeckType type){
        switch (type) {
            case Normal: return new NormalDeck();
            case Small: return new SmallDeck();
            case Test: return new TestDeck();
        }
        return new NormalDeck();
    }
}
