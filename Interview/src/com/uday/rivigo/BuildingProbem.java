package com.uday.rivigo;

public class BuildingProbem {
	
	
	public static int getMinCost(int n, int[][] cost){
		
		//int rows = cost.length;
		int cols = cost[0].length;
		
		for(int i=1; i<n; i++){
			for(int j=0; j<cols; j++){
				int min = Integer.MAX_VALUE;
				for(int k =0; k<cols; k++){
					if(k!=j){
						min = Math.min(min,cost[i-1][k]);
					}
				}
				cost[i][j] += min;
			}
		}
		
		int min_total = Integer.MAX_VALUE;
		
		for(int j =0; j < cols; j++){
			min_total = Math.min(min_total, cost[n-1][j]);
		}
		
		return min_total;

	}
	
	public static void main(String[] args){
		//int[][] cost = new int[3][3];
		int cost[][]=  new int[][] {{1,1,1,1}, 
            {2, 2, 2,2}, 
            {6, 6, 6,6} 
           }; 
           
         System.out.println(getMinCost(3,cost));
	}

}
