package com.uday.design.patterns;

public class SingletonClass {
	
	private static volatile SingletonClass singleton; 
	
	private SingletonClass(){
		
	}
	
	public static SingletonClass getInstance(){
		if(null==singleton){
			synchronized(SingletonClass.class){
				if(null==singleton){
					singleton = new SingletonClass();
				}
			}
		}
		return singleton;
	}

}
