package com.uday.design.chess;

public interface GameBehavior {

    public String gameStatus();

    public Move executeTurn(Move move);
}
