package com.uday.battleship;

public class BattleShipFactory {
	
	private static BattleShipFactory instance;
	
	private BattleShipFactory(){
		
	}
	
	public static BattleShipFactory getInstance(){
		if(null == instance){
			synchronized(BattleShipFactory.class){
				if(null==instance){
					instance = new BattleShipFactory();
				}
			}
		}
		return instance;
	}
	
	public static BattleShip createBattleShip(BattleShipType type){
		BattleShip battleShip = null;
		switch (type){
			case P :{
				battleShip = new PBattleShip();
			}
			case Q : {
				battleShip = new QBattleShip();
			}
			default:{
				
			}
		}
		return battleShip;
	}
	
	public static BattleBoardSquare createBattleBoardSquare(String square, boolean isBattleShip){
		BattleBoardSquare bbs = null;
		int w = square.charAt(0);
		char h = square.charAt(1);
		if(isBattleShip){
			bbs = new BattleShipSquare(w,h);
		}
		else{
			bbs = new BattleBoardSquare(w,h);
		}
		return bbs;
	}

}
