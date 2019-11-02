package com.uday.design.chess;

public abstract class Piece implements Movement {

    MovementStrategy movementStrategy;

    Color color = Color.WHITE;

    boolean isAlive = true;


}
