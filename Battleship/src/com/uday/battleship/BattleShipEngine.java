package com.uday.battleship;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BattleShipEngine {
	
	public void play(BattleBoard board, Map<Player,Queue<BattleBoardSquare>> playerSeq){
		
		Set<Player> players = playerSeq.keySet();
		
		Player turnPlayer = null;
		Player opposingPlayer = null;
		String turnPlayerName = players.stream().findFirst().get().getName();
		
		while(players.stream().noneMatch(player -> player.isWinner())){
			turnPlayer = players.stream().filter(
					player -> player.getName().equals(turnPlayerName)).findFirst().get();
			opposingPlayer = players.stream().filter(
					player -> !player.getName().equals(turnPlayerName)).findFirst().get();
			BattleBoardSquare nextGuess = playerSeq.get(turnPlayer).poll();
			boolean success = processHitGuess(opposingPlayer,nextGuess);
			if(success){
				if(opposingPlayer.allBattleShipDestroyed()){
					turnPlayer.setWinner(true);
				}
			}
			else if (!success || playerSeq.get(turnPlayer).isEmpty()){
				if(!playerSeq.get(opposingPlayer).isEmpty()){
					turnPlayer = opposingPlayer;
					//turnPlayerName = opposingPlayer.getName();
				}
				else{
					if(playerSeq.get(turnPlayer).isEmpty()){
						System.out.println("Both guesses exhausted without a winner!");
						break;
					}
				}
				
			}
		}
	}
	
	
	private boolean processHitGuess(Player opposingPlayer, BattleBoardSquare guessSq){
		if(null==guessSq){
			return false;
		}
		return opposingPlayer.getBattleShips().stream().anyMatch(
				battleShip -> battleShip.processHit(guessSq));
	}

}
