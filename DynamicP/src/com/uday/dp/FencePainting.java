package com.uday.dp;

//Given a fence with n posts and k colors, 
//find out the number of ways of painting the fence 
//such that at most 2 adjacent posts have the same color
public class FencePainting {
	
	public static double ways(int n, int k){ 
		double s = 0;
		if(n<=2){
			return Math.pow(k, n);
		}
		s = (ways(n-1,k)-k)*k+k*(k-1);
		return s;
	}
	
	public static void main(String[] args){
		System.out.println(ways(4,4));
	}

}
