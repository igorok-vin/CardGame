package com.cardgame.model;
/*
* Decorator pattern
*
* */
public class WinningPlayer implements IPlayer {
    IPlayer winner; // Part one of the decorator is it needs to hold an instance of the actual winner,

    public WinningPlayer (IPlayer player){ //which needs to be set in its constructor.
        winner = player;
    }

    //And here is the decorating part. It will implement the getname method
    // but by adding a little flourish calling the existing getname function,
    //and then adding another little flourish at the end.
    //only winners get to be decorated.
    @Override
    public String getName() {
        return "****" + winner.getName() + "****";
    }

    @Override
    public PlayingCard getCard(int index) {
        return null;
    }

    @Override
    public void addCardToHand(PlayingCard pc) {

    }

    @Override
    public PlayingCard removeCard() {
        return null;
    }


}
