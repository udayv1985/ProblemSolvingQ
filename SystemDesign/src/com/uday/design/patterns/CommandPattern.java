package com.uday.design.patterns;

public class CommandPattern {

	static class TV{

		String state = "off";

		public void changeState(){
			if(state.equalsIgnoreCase("off")){
				state = "on";
			}
			else{
				state = "off";
			}
			System.out.println("TV is now "+state);
		}

	}
	
	static abstract class Button{

		public Button(Command command){
			this.command = command;
		}
		
		Command command;

		public void press(){
			command.execute();
		}
	}

	static class PowerButton extends Button {

		public PowerButton(){
			super(new TVOPowerCommand());
		}

	}

	interface Command {

		public void execute();

		public void setObj(Object t);
	}

	static class TVOPowerCommand implements Command {

		TV tv;

		@Override
		public void execute() {
			tv.changeState();
		}

		@Override
		public void setObj(Object t) {
			tv = (TV) t;
		}
	}
	
	 static class RemoteController{
		
		Button button;
		public void pressButton(){
			button.press();
		}
	}

	public static void main(String args[]){
		RemoteController rc = new RemoteController();
		TV tv = new TV();
		rc.button = new PowerButton();
		rc.button.command.setObj(tv);
		rc.pressButton();
		rc.pressButton();
	}

}
