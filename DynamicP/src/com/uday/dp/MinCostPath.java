package com.uday.dp;

public class MinCostPath {
    /**
     * Given a cost matrix cost[][] and a position (m, n) in cost[][],
     * write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
     * Each cell of the matrix represents a cost to traverse through that cell.
     * Total cost of a path to reach (m, n) is sum of all the costs on that path
     * (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell,
     * i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
     * You may assume that all costs are positive integers
     */
    public static int minCostPath(int[][] a, int x, int y) {
        int c = Integer.MAX_VALUE;
        if (x < 0 || y < 0) {
            return c;
        }
        if (x == 0 && y == 0) {
            return a[x][y];
        }
        c = a[x][y] + Math.min(minCostPath(a, x - 1, y),
                Math.min(minCostPath(a, x, y - 1), minCostPath(a, x - 1, y - 1)));
	
		
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

    public static void main(String[] args) {
        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3}};

        System.out.print(bottomUp(cost, 2, 2));
    }

    public static int bottomUp(int[][] a, int x, int y) {
        int c = Integer.MAX_VALUE;
        int[][] cost = new int[x + 1][y + 1];
        cost[0][0] = a[0][0];
        for (int i = 1; i <= x; i++) {
            cost[i][0] = a[i][0] + cost[i - 1][0];
        }
        for (int i = 1; i <= y; i++) {
            cost[0][i] = a[0][i] + cost[0][i - 1];
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                cost[i][j] = a[i][j] + Math.min(cost[i - 1][j], Math.min(cost[i][j - 1], cost[i - 1][j - 1]));
            }
        }
        return cost[x][y];
    }

}
