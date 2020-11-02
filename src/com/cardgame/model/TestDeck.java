package com.cardgame.model;

import com.cardgame.game.DeckFactory;

import java.util.ArrayList;

/*
* TestDeck which only makes the ace of clubs.
* */
public class TestDeck extends Deck {
    public TestDeck() {
        cards = new ArrayList<PlayingCard>();
        for (int i = 0; i < 20; ++i) {
            cards.add(new PlayingCard(Rank.ACE, Suit.CLUBS));
        }
    }
}
