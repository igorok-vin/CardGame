package com.cardgame.game;

import com.cardgame.model.IPlayer;
import com.cardgame.model.PlayingCard;

import java.util.List;

public class HighCardEvaluator implements GameEvaluator {
    public IPlayer evaluateWinner(List<IPlayer> IPlayerList) {
        IPlayer bestIPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;
        for (IPlayer IPlayer : IPlayerList) {
            boolean newBestPlayer = false;
            if (bestIPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard playingCard = IPlayer.getCard(0);
                int thisRank = playingCard.getRank().value();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (playingCard.getSuit().value() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }
            if (newBestPlayer){
                bestIPlayer = IPlayer;
                PlayingCard playingCard = IPlayer.getCard(0);
                bestRank = playingCard.getRank().value();
                bestSuit = playingCard.getSuit().value();
            }
        }
        return bestIPlayer;
    }
}
