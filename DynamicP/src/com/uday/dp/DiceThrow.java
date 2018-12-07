package com.uday.dp;

// no of ways to get sum x by a total of n -  m numbered dices 
public class DiceThrow {

	
	public static int diceThrowCount(int m, int n, int sum){
		int r = 0;
	
		if(sum<1){
			return 0;
		}
		if(n==1){
			return 1;
		}
		for(int i = 1; i <=m ; i ++){
			if(i<=sum){
				r = r + diceThrowCount(n-1,m,sum-i);
			}
		}
		return r;
	}
	
	public static void main(String args[]){
		System.out.println(diceThrowCount(4,2,1));
		System.out.println(diceThrowCountBottomUp(6,3,8));
	}
	
	public static int diceThrowCountBottomUp(int m, int n, int sum){
		int r = 0;
		int mem[][] = new int[n+1][sum+1];
	
		for(int i =1; i<=n; i++){
			for(int j=1; j<=sum; j++){
				mem[i][j]=0;
			}
		}
		for(int j=1; j<=sum && j<=m; j++){
			mem[1][j]=1;
		}
		
		for(int i =2; i<=n; i++){
			for(int j=1; j<=sum; j++){
				for(int k =1;k<=m && k<=j;k++){
					mem[i][j] = mem[i][j] + mem[i-1][j-k];
				}
				
			}
		}
	
		return mem[n][sum];
	}
}
