package com.uday.design.chess;

public class Pawn extends Piece {

    public Pawn(){
        this.movementStrategy = new PawnMovementStartegy();
    }

    @Override
    public Move execute(Spot src, Spot dest) throws InvalidMoveException {
        return null;
    }
}
