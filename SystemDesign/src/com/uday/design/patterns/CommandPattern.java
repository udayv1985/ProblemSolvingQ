package com.uday.design.patterns;

public class CommandPattern {
	
	abstract class Button{
		
		public abstract void execute();
	}
	
	public class RemoteController{
		
		Button onButton;
		
		public void switchOn(){
			onButton.execute();
		}
	}

}
