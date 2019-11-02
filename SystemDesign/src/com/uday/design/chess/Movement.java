package com.uday.design.chess;

public interface Movement {

    default Move move(Spot src, Spot dest) throws  InvalidMoveException{
        validateDestSpot(src,dest);
        return execute(src,dest);
    }

    Move execute(Spot src, Spot dest) throws InvalidMoveException;

    static boolean validateDestSpot(Spot src, Spot dest) throws InvalidMoveException{
        if(src.piece== null || (dest.piece!=null && dest.piece.color == src.piece.color)){
            throw new InvalidMoveException();
        }
        return true;

    }
}
