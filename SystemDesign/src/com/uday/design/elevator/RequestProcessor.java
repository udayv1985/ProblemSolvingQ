package com.uday.design.elevator;

public interface RequestProcessor {
	
	//public void processRequest(Request req);
	
	public boolean pressFloorButton(int floor, Direction dir);
	
	public ElevatorPanelReq pressElevatorButton(int floor);

}
