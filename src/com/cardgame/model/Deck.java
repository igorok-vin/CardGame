package com.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/*
* Since we goind to use Factory object creation pattern for different type of Decks.
* We dont need here a constructor but It will still hold and manage the cards.
* Instead of making the deck an interface, since much of the behaviour is small,
* we'll make the deck an abstract class.
* The different types of decks will implement their constructor uniquely.
* */
public abstract class Deck {
    ArrayList<PlayingCard> cards;

    /*public Deck() {
        cards = new ArrayList<PlayingCard>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                System.out.println("Creating cards: [" + rank + "] [" + suit + "]");
                cards.add(new PlayingCard(rank, suit));
            }
        }
        shuffle();
    }*/

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); ++i) {
            Collections.swap(cards, i, random.nextInt(cards.size()));
        }
    }

    public PlayingCard removeTopCard() {
        return cards.remove(0);
    }

    public void returnCardToDeck(PlayingCard pc) {
        cards.add(pc);
    }

    public void addCard(PlayingCard pc){
        cards.add(pc);
    }

    public PlayingCard getCard (int index){
        return cards.get(index);
    }

    public PlayingCard removeCard(){
        return cards.remove(0);
    }


}
