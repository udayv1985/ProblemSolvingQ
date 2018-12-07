package com.uday.dp;

public class MinCostPath {
	
	public static int minCostPath(int[][] a, int x, int y){
		int c = Integer.MAX_VALUE;
		int rows = a.length;
		int columns = a[0].length;
		if(x<0 || y<0){
			return c;
		}
		if(x==0 && y==0){
			return a[x][y];
		}
		 c = a[x][y] + Math.min(minCostPath(a,x-1,y), 
				 		Math.min(minCostPath(a,x,y-1), minCostPath(a,x-1,y-1)));
	
		
		/*if(x<rows){
			int p4 = a[x+1][y] + minCostPath(a,x+1,y);
			c = Math.min(c, p4);
		}
		if(y<columns){
			int p5 = a[x][y+1] + minCostPath(a,x,y+1);
			c = Math.min(c, p5);
		}
		if(y<columns && x<columns){
			int p6 = a[x+1][y+1] + minCostPath(a,x+1,y+1);
			c = Math.min(c, p6);
		}*/
		return c;
	}
	
	public static void main(String[] args){
		int cost[][] = { {1, 2, 3}, 
                	     {4, 8, 2}, 
                		 {1, 5, 3} }; 
                  
		System.out.print(minCostPath(cost, 2, 2)); 
	}

}
