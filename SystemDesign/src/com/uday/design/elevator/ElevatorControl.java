package com.uday.design.elevator;

import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorControl implements RequestProcessor,Runnable {
	
	private Elevator elevator;
	
	private Queue<Request> reqQ = new PriorityQueue<>();
	
	private Queue<Request> upQ  = new PriorityQueue<>();
	
	private Queue<Request> downQ =  new PriorityQueue<>();

	@Override
	public boolean pressFloorButton(int floor, Direction dir) {
		// TODO Auto-generated method stub
		reqQ.add(new FloorPanelReq(floor,dir));
		this.notifyAll();
		return true;
	}

	@Override
	public ElevatorPanelReq pressElevatorButton(int floor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		elevator = new Elevator();
		while(true){
			while(!reqQ.isEmpty()){
				Request r = reqQ.poll();
				int currentFloor = elevator.getLocation();
				if(elevator.getState()==ElevatorState.STATIONARY){
					elevator.setState(ElevatorState.RUNNING);
					if(r instanceof ElevatorPanelReq){
						if(currentFloor<r.getFloor()){
							elevator.setDirection(Direction.UP);
						}
						else{
							elevator.setDirection(Direction.DOWN);
						}
					}
					else{
						
					}
				}
				//serviceCurrentFloor();
				elevator.setLocation(currentFloor+1);
				
			}
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void serviceCurrentFloor(int currentFloor) {
		// should door open -> check if any elevatoR for current floor or 
		// floor r with floor and same direction 
		
		// process door open - purge requests from that floor 
		
		// continue current dir if more reqs left otherwise reverse 
		
		
		
		
	}
	
	private void doorDecision(){
		
	}
	
	/*
	 *  button pressed -> request generated ->  
	 *  add it to q -> 
	 *  a) if elevator is stationary, start running ->
	 * set direction wrt requested floor -> 
	 * b) if elevator is already running process request for right queue ->
	 * b1) if requested floor is in same dir, add to the same 
	 * b2) if on opposite, add to the same 
	 * b3) corner case when elevator already moving to 5th floor and 4th floor requested
	 * when elevator at third floor 
	 */
	 private void addReqToQ(Request req){
		 int e_floor = elevator.getFloorCount();
		 if(req instanceof ElevatorPanelReq){
			 if(req.getFloor()<e_floor){
				 downQ.add(req);
			 }
			 else{
				 upQ.add(req);
			 }
		 }
		 else{
			 FloorPanelReq fr = (FloorPanelReq)req;
			 if(fr.getDirection()==Direction.UP){
				 upQ.add(req);
			 }
			 else{
				 downQ.add(req);
			 }
		 }
		 
	 }
	 
	 private void processReqs() throws InterruptedException{
		 while(!upQ.isEmpty()){
			 int first_req = upQ.peek().getFloor();
			 if(first_req==elevator.getLocation().intValue()){
				 // open door 
				while(upQ.peek().getFloor().equals(elevator.getLocation())){
					upQ.poll();
				}
			 }
			 // close door 
			 elevator.incrementFloor();
			 Thread.sleep(1000);
		 }
	 }
	 
	 private void process(){
		 if(ElevatorState.STATIONARY == elevator.getState()){
			 
		 }
		 else{
			 
		 }
	 }
	 
}
