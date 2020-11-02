package com.cardgame.game;

import com.cardgame.model.IPlayer;

import java.util.List;

public interface GameEvaluator {
    public IPlayer evaluateWinner(List<IPlayer> IPlayerList);
    }

