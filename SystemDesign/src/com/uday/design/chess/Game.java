package com.uday.design.chess;

import java.util.List;
import java.util.Set;

public class Game implements GameBehavior {

    List<Player> players;

    Board board;

    int turnPlayer = 0;

    List<Move> moves;

    Player winner;

    GameStatus gameStatus;

    Set<Piece> discardedPieces;

    @Override
    public String gameStatus() {
        return gameStatus.name();
    }

    @Override
    public Move executeTurn(Move move) {
        try {
            move.piece.execute(move.src,move.dest);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        int currentPlayer = players.indexOf(players.get(turnPlayer));
        updateGameStatus();
        turnPlayer = rotateTurn(currentPlayer);

        return null;
    }

    private void updateGameStatus() {
    }

    private int rotateTurn(int currentPlayer) {
        if(currentPlayer == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
