package com.uday.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ByteLandianCoinProblem {
	
	static Map<Integer,Integer> mem = new HashMap<>();
	
	public static int maxUSD(int goldN){
		int r = 0;
		
		if(mem.containsKey(goldN)){
			return mem.get(goldN);
		}
		if(goldN<=3){
			r =  goldN;
		}
		else{
			r =  maxUSD(goldN/2) + maxUSD(goldN/3) + maxUSD(goldN/4);
			if(r<goldN){
				r = goldN;
			}
		}
		mem.put(goldN, r);
		return r;
	}
	
	
	public static void main(String[] args){
		 Scanner in = new Scanner(System.in);
	     int a = in.nextInt();
	     int b = in.nextInt();
		System.out.println(maxUSD(a));
		System.out.println(maxUSD(b));
	}

}
