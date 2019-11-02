package com.uday.ds.problems;

import java.util.*;

public class CircularPetrolTour {
	
	static class PP{

		int cap; 
		
		int distance; 
		
		public PP(int a, int b){
			cap=a;
			distance = b;
		}
		
		public int mileage(){
			return this.cap-this.distance;
		}
	}
	
	public static void findTour(PP[] arr){
		Queue<PP> q = new LinkedList<>();
		int petrol = 0;
				//arr[0].mileage();
		//q.add(arr[0]);
		int i = 0;
		int n = arr.length;
		boolean firstTime = true;
		while(petrol<0 || q.size()<n){
			if(q.size()==0 && !firstTime){
				System.out.println("No Solution");
				return;
			}
			petrol += arr[i].mileage();
			q.add(arr[i]);
			while(petrol<0  && q.size()>0){
				PP p = q.poll();
				petrol  -= p.mileage();
			}
			i = i+1;
			if(i>=n){
				i=0;
			}
			firstTime = false;
		}
		System.out.println("Found, start at "+ i + ", petrol left "+petrol);
	}
	
	public static void main(String[] args){
		 PP[] arr = {new PP(2, 6),
                 new PP(3, 3), 
                 new PP(7, 5)}; 
		 findTour(arr);
	}

}
