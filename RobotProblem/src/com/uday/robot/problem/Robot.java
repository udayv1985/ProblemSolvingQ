package com.uday.robot.problem;

public class Robot {
	
	private String name; 
	
	private int location; 
	
	private int timeOfLastAction; 
	
	public Robot(String name) {
		this.name = name;
		location = 0;
		timeOfLastAction = 0;
	}

	public static void main(String[] args){
		Robot r1 = new Robot("A");
		Robot r2 = new Robot("B");
		
		
		String code = new String("4 B2 A1 A2 B4");
		String[] codes = code.split(" ");
		int j = 1;
		int totalSecs = 0;
		while(j<=Integer.valueOf(codes[0]).intValue()){
			String robotName = codes[j].substring(0, 1);
			int buttonNumber = Integer.valueOf(codes[j].substring(1));
			Robot r = null;	
			if("A".equals(robotName)){
				r = r1;
			}
			else{
				r = r2;
			}
			int distance = Math.abs(buttonNumber-r.location);
			int timeSinceLastAction = totalSecs - r.timeOfLastAction;
			int timeCurrentAct = 0;
			if(distance < timeSinceLastAction ){
				// assume robot walked to the location by the secs
				// no need to increase secs, just update robot location
				timeCurrentAct = 0;
			}
			else if(distance == timeSinceLastAction ){
				// robot just reached location by the secs 
				// update location but also increment secs by 1 
				timeCurrentAct+=1;
				
			}
			else if(distance > timeSinceLastAction){
				
				int extraTime = distance-timeSinceLastAction+1;
				timeCurrentAct = timeCurrentAct + extraTime;
			}
			totalSecs+=timeCurrentAct;
			r.location = buttonNumber;
			r.timeOfLastAction=totalSecs;
			j++;					
		}
		System.out.println("Total time: " + totalSecs);

	}
	
	/*
	 * calculate distance to be covered
	 * calculate time diff between last time logged for robot's action and total time
	 * if time diff is more than distance then no need to increment total time
	 * if time diff is same as distance then increment by 1
	 * if time diff is less than distance then increment by diff+1
	 * update robot location as button number
	 * update robot's time as total secs
	 * 
	 * 
	 */
	
	

}

